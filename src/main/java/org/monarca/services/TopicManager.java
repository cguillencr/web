package org.monarca.services;

import java.util.List;

import org.monarca.dao.JPATopicDao;
import org.monarca.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopicManager {
	
	
	private static final long serialVersionUID = 1L;
		
	@Autowired
	private JPATopicDao topicDao;
		


	public void setTopicDao(JPATopicDao topicDao) {
		this.topicDao = topicDao;
	}


	public List<Topic> getTopicList() {		
		return topicDao.getTopicList();
	}

	public boolean save(Topic topic) throws DataAccessException {
		return topicDao.save(topic);
	}

	public Topic findById(int topic_id) throws DataAccessException {
		return topicDao.findById(topic_id);
	}

	public boolean delete(int topic_id) throws DataAccessException {
		return topicDao.delete(topic_id);
	}

	public List<Topic> getTopicsByUser(int id_user) throws DataAccessException {		
		return topicDao.getTopicsByUser(id_user);
	}

}
