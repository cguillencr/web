package org.monarca.services;

import java.util.List;

import org.monarca.dao.JPAProjectDao;
import org.monarca.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectManager{

	   private static final long serialVersionUID = 1L;

	    @Autowired
	    private JPAProjectDao projectDao;

	    public void setProjectDao(JPAProjectDao projectDao) {
	        this.projectDao = projectDao;
	    }

	    public List<Project> getProjects() {
	        return projectDao.getProjectList();
	    }
	    
	    public Project getProjectByDescription(String description) {
	    	return projectDao.getProjectByDescription(description);
	    }

}
