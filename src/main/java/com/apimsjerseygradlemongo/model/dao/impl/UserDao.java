/**
 * 
 */
package com.apimsjerseygradlemongo.model.dao.impl;

import javax.inject.Inject;

import org.mongodb.morphia.Datastore;

import com.apimsjerseygradlemongo.config.IConnectionDB;
import com.apimsjerseygradlemongo.model.dao.AbstractDao;
import com.apimsjerseygradlemongo.model.entity.User;

/**
 * @author eloibilek@gmail.com
 */
//@ApplicationScoped
public class UserDao extends AbstractDao<User> {

	@Inject
	private IConnectionDB mongoConnection;

	public UserDao(Class<User> entityClass) {
		super(entityClass);
	}

	public UserDao() {
		super(User.class);
	}

	@Override
	public Datastore getDatastore() {
		return mongoConnection.getConnection();
	}

}
