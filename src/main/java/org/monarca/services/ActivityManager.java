package org.monarca.services;

import java.util.List;

import org.monarca.dao.JPAActivityDao;
import org.monarca.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivityManager {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private JPAActivityDao activityDao;

	public void setActivityDao(JPAActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	public List<Activity> getActivitiesByTopicAndUser(int idTopic, int idUser) {
		return activityDao.getActivitiesByTopicAndUser(idTopic,idUser);
	}

}
