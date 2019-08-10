/**
 * 
 */
package com.apimsjerseygradlemongo.model.service.impl;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.apimsjerseygradlemongo.model.dao.AbstractDao;
import com.apimsjerseygradlemongo.model.dao.IOperationsDao;
import com.apimsjerseygradlemongo.model.entity.User;
import com.apimsjerseygradlemongo.model.service.AbstractService;

/**
 * @author eloibilek@gmail.com
 */
@Transactional
public class UserService extends AbstractService<User> {

	private IOperationsDao<User> userDao;

	public UserService() {
	}

	@Inject
	private UserService(IOperationsDao<User> userDao) {
		this.userDao = userDao;
	}

	@Override
	public AbstractDao<User> getDao() {
		return (AbstractDao<User>) userDao;
	}
}
