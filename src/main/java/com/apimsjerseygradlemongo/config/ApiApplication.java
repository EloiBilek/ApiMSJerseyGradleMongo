package com.apimsjerseygradlemongo.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.apimsjerseygradlemongo.resource.UserResource;

/**
 * @author eloi eloibilek@gmail.com
 */

public class ApiApplication extends Application {

	private final Set<Class<?>> classes;

	public ApiApplication() {
		HashSet<Class<?>> c = new HashSet<Class<?>>();
		c.add(UserResource.class);
		classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}
