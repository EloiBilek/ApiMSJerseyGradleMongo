package com.apimsjerseygradlemongo.init;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.inject.Vetoed;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.apimsjerseygradlemongo.model.service.impl.UserService;
import com.apimsjerseygradlemongo.resource.UserResource;

/**
 * @author eloibilek@gmail.com
 */
@Vetoed
public class InitApplication {

	private static Logger LOGGER = Logger.getLogger(InitApplication.class.getName());

	// public static final String MYAPP = "/ApiMSJerseyGradleMongo";
	// public static final String VERSION = "/v1";

	/**
	 * Init API
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty(Weld.SHUTDOWN_HOOK_SYSTEM_PROPERTY, "true");
		final Weld weld = new Weld("::::::::Weld Microcontainer-1::::::::");

		WeldContainer container = weld.initialize();
		final UserResource resource = container.select(UserResource.class).get();
		final UserService service = container.select(UserService.class).get();
		final MicroServer server = container.select(MicroServer.class).get();

		try {
			server.start();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, ":::::::ERROR InitApplication::::::: - " + e.getMessage());
		}

		// startServer();
		// LOGGER.log(Level.INFO, "Application started.\n" + "Try accessing " +
		// getBaseURI() + "/users in the browser.\n");
		// Thread.currentThread().join();
	}

	/**
	 * Starts CDI container
	 */
	// public static void startCDI() {
	// try (CDI<Object> container = new Weld().initialize()) {
	// UserResource resource = container.select(UserResource.class).get();
	// resource.testCall();
	// }
	// }

	/**
	 * Starts the lightweight HTTP server serving the JAX-RS application.
	 *
	 * @return new instance of the lightweight HTTP server
	 * @throws IOException
	 */
	// static HttpServer startServer() throws IOException {

	// start cdi
	// container = CDI.getCDIProvider().getCDI();
	// container = new Weld().initialize();

	// start request context
	// RequestContext requestContext= container.select(RequestContext.class,
	// UnboundLiteral.INSTANCE).get();
	// requestContext.activate();

	// create a new server listening at port 8080
	// final HttpServer server = HttpServer.create(new
	// InetSocketAddress(getBaseURI().getPort()), 0);
	// Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	// @Override
	// public void run() {
	// server.stop(0);
	// // ((WeldContainer) container).shutdown();
	// }
	// }));

	// create a handler wrapping the JAX-RS application
	// HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new
	// ApiApplication(), HttpHandler.class);

	// map JAX-RS handler to the server root
	// server.createContext(getBaseURI().getPath(), handler);

	// start the server
	// server.start();

	// container.select(UserResource.class).get().run();

	// return server;
	// }

	// private static int getPort(int defaultPort) {
	// final String port =
	// System.getProperty("jersey.config.test.container.port");
	// if (null != port) {
	// try {
	// return Integer.parseInt(port);
	// } catch (NumberFormatException e) {
	// LOGGER.log(Level.SEVERE,
	// "Value of jersey.config.test.container.port property" + " is not a valid
	// positive integer ["
	// + port + "]." + " Reverting to default [" + defaultPort + "].",
	// e);
	// }
	// }
	// return defaultPort;
	// }
	// public static URI getBaseURI() {
	// return
	// UriBuilder.fromUri("http://localhost/").port(getPort(8080)).path(MYAPP +
	// VERSION).build();
	// }

}
