package org.monarca.services;

import java.util.List;

import org.monarca.dao.JPABranchDao;
import org.monarca.entities.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private JPABranchDao branchDao;

    public void setBranchDao(JPABranchDao branchDao) {
        this.branchDao = branchDao;
    }

    public List<Branch> getBranches() {
        return branchDao.getBranchList();
    }
  
	public List<Branch> getBranchByProjectDescription(String description) {
		return branchDao.getBranchByProjectDescription(description);
	}
	
	public Branch getBranchByDescription(String description) {
		return branchDao.getBranchByDescription(description);
	}
    
}