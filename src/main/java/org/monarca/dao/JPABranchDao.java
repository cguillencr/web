package org.monarca.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.monarca.entities.Branch;
import org.springframework.stereotype.Repository;

@Repository(value = "branchDao")
public class JPABranchDao {

    private EntityManager em = null;

 
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }


    public List<Branch> getBranchList() {
        return em.createQuery("select p from Branch p order by p.id").getResultList();
    }
       
    public Branch getBranchByDescription(String description) {
	     Query query = em.createNativeQuery ("Select * FROM branch AS b WHERE  b.description = :description");
	     query.setParameter("description", description);
	     List listBranches = query.getResultList ();
	     Iterator listBranchesIterator = listBranches.iterator ();
		 
	     Branch branch = new Branch();  
	     if (listBranchesIterator.hasNext()) {  
	           Object[] objectBranch = (Object[])listBranchesIterator.next();
	           Branch newBranch = new Branch();
	           newBranch.setId((Integer)(objectBranch[0]));
	           newBranch.setDescription((String) objectBranch[1]);
	           newBranch.setCreatedOn((Date)(objectBranch[2])); 
	           branch = newBranch;
	       }
	       return branch;
    }

    public List<Branch> getBranchByProjectDescription (String description)
    {
	     Query query = em.createNativeQuery ("Select * FROM branch AS b, project AS p WHERE b.project = p.id AND p.description = :description");
	     query.setParameter("description", description);
	     List listBranches = query.getResultList ();
	     Iterator listBranchesIterator = listBranches.iterator ();
	     List<Branch> branchs = new ArrayList<Branch> (); 
           
           while (listBranchesIterator.hasNext()) {
        	   
                 Object[] objectBranch = (Object[])listBranchesIterator.next();
               Branch newBranch = new Branch();
               newBranch.setId((Integer)(objectBranch[0]));
               newBranch.setDescription((String) objectBranch[1]);
               newBranch.setCreatedOn((Date)(objectBranch[2])); 
               branchs.add(newBranch);
           }
           
           return branchs;
    }

}
