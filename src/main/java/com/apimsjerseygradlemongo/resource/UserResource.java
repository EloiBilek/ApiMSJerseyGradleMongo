package com.apimsjerseygradlemongo.resource;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.apimsjerseygradlemongo.model.entity.User;
import com.apimsjerseygradlemongo.model.service.IOperationsService;

/**
 * @author eloi eloibilek@gmail.com
 */

@ManagedBean
@Path("users")
public class UserResource {

	@Inject
	private IOperationsService<User> userService;

	private static Logger LOGGER = Logger.getLogger(UserResource.class.getName());

	public UserResource() {
		super();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> findAll() {
		try {
			return userService.findAll();
		} catch (Exception e) {
			throw new WebApplicationException(e, 500);
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public User findById(@PathParam("id") final String id) {
		try {
			return userService.findById(id);
		} catch (Exception e) {
			throw new WebApplicationException(e, 500);
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response create(User resource) {
		try {
			resource = userService.create(resource);
			return Response.status(201).entity(resource).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new WebApplicationException(e, 500);
		}
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(User resource) {
		try {
			resource = userService.update(resource);
			return Response.status(200).entity(resource).build();
		} catch (Exception e) {
			throw new WebApplicationException(e, 500);
		}
	}

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response delete(@PathParam("id") final String id) {
		try {
			userService.deleteById(id);
			return Response.status(200).entity("User id " + id + " - deleted.").build();
		} catch (Exception e) {
			throw new WebApplicationException(e, 500);
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/test")
	public Response testCall() {
		return Response.status(200).entity(">>>>>> Jersey Microservice ON <<<<<<<").build();
	}

	public void run() {
		LOGGER.info(":::: API Run ::::");
	}
}
