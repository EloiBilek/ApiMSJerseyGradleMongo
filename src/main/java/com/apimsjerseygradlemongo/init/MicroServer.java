/**
 * 
 */
package com.apimsjerseygradlemongo.init;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Singleton;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.apimsjerseygradlemongo.config.ApiApplication;
import com.sun.jersey.spi.container.servlet.ServletContainer;

/**
 * @author eloi
 *
 */
@Singleton
public class MicroServer {

	private static Logger LOGGER = Logger.getLogger(MicroServer.class.getName());

	private final Server server;

	public MicroServer() {

		LOGGER.info("::::::::MicroServer Start::::::::");

		server = new Server();

		try {

			// HTTP connector
			ServerConnector http = new ServerConnector(server);
			http.setHost("localhost");
			http.setPort(8080);
			http.setIdleTimeout(30000);

			// Set the connector
			server.addConnector(http);
			server.setStopAtShutdown(true);

			NCSARequestLog requestLog = new NCSARequestLog("/home/eloi/logs/microservice-yyyy_mm_dd.request.log");
			requestLog.setAppend(true);
			requestLog.setExtended(false);
			requestLog.setLogTimeZone("GMT");
			requestLog.setRetainDays(10);
			server.setRequestLog(requestLog);

			final HandlerList handlers = new HandlerList();

			ResourceHandler resource_handler = new ResourceHandler();
			resource_handler.setDirectoriesListed(true);
			resource_handler.setResourceBase(".");
			server.setHandler(handlers);

			ServletContextHandler servlet_handler = new ServletContextHandler(
					ServletContextHandler.GZIP | ServletContextHandler.NO_SECURITY | ServletContextHandler.NO_SESSIONS);
			server.setHandler(servlet_handler);

			ServletHolder jerseyServletHolder = new ServletHolder("ApiApplication", ServletContainer.class);
			jerseyServletHolder.setInitOrder(0);
			jerseyServletHolder.setInitParameter("javax.ws.rs.Application", ApiApplication.class.getName());
			servlet_handler.addServlet(jerseyServletHolder, "/v1/*");

			// Add the ResourceHandler to the server.
			final GzipHandler gzip = new GzipHandler();
			server.setHandler(gzip);
			handlers.setHandlers(new Handler[] { resource_handler, servlet_handler });
			gzip.setHandler(handlers);

			// === jetty-stats.xml ===
			StatisticsHandler stats = new StatisticsHandler();
			stats.setHandler(server.getHandler());
			server.setHandler(stats);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "::::::::ERROR MICROSERVER:::::::: - " + e);
		}

	}

	public void start() throws Exception {
		// print internal state
		LOGGER.log(Level.CONFIG, server.dump());
		server.start();
		server.join();
	}

}
