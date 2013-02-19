package org.monarca.dao;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.monarca.entities.Project;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository(value = "projectDao")
public class JPAProjectDao {

    private EntityManager em = null;
    

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	public List<Project> getProjectList() throws DataAccessException {
		return em.createQuery("from Project").getResultList();
	}

	public List<Project> getProjectDescription(String description) throws DataAccessException {
		Query query =em.createQuery("from Project as project where project.description = :description");
		query.setParameter("description", description);
		return  query.getResultList();
	}
	
	public boolean save(Project project) throws DataAccessException {		
		return em.merge(project) != null;
	}
	
    public Project getProjectByDescription(String description) {
	     Query query = em.createNativeQuery ("Select * FROM project AS p WHERE  p.description = :description");
	     query.setParameter("description", description);
	     List listProjects = query.getResultList ();
	     Iterator listProjectsIterator = listProjects.iterator ();
		 
	     Project project = new Project();  
	     if (listProjectsIterator.hasNext()) {  
	           Object[] objectProject = (Object[])listProjectsIterator.next();
	           Project newProject = new Project();
	           newProject.setId((Integer)(objectProject[0]));
	           newProject.setDescription((String) objectProject[1]);
	           newProject.setCreatedOn((Date)(objectProject[2])); 
	           project = newProject;
	       }
	       return project;
	   }
	
}
