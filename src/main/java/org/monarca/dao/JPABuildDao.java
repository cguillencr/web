package org.monarca.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.monarca.entities.Build;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository(value = "buildDao")
public class JPABuildDao {

    private EntityManager em = null;

 
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

 
    public List<Build> getBuildList() {
        return em.createQuery("select p from Build p order by p.id").getResultList();
    }
       

    public List<Build> getBuildByBranchDescription (String description)
    {
	     Query query = em.createNativeQuery ("Select * FROM build AS b, branch AS p WHERE b.branch = p.id AND p.description = :description");
	     query.setParameter("description", description);
	     List listBuilds = query.getResultList ();
	     Iterator listBuildsIterator = listBuilds.iterator ();
	     List<Build> builds = new ArrayList<Build> (); 
           
           while (listBuildsIterator.hasNext()) {
        	   
               Object[] objectBuild = (Object[])listBuildsIterator.next();
               Build newBuild = new Build();
               newBuild.setId( (Integer)(objectBuild[0]));
               newBuild.setDescription((String) objectBuild[1]);
               newBuild.setVersion((String)(objectBuild[2])); 
               builds.add(newBuild);
           }
           
           return builds;
    }
    
	public boolean save(Build build) throws DataAccessException {		
		return em.merge(build) != null;
	}


}
