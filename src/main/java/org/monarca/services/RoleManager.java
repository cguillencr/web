package org.monarca.services;

import java.util.List;

import org.monarca.dao.JPARoleDao;
import org.monarca.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleManager {

	@Autowired
    private JPARoleDao roleDao;

    public void setRoleDao(JPARoleDao roleDao) {
        this.roleDao = roleDao;
    }    

	public boolean save(Role role) throws DataAccessException {
		return roleDao.save(role);
	}

	public List<Role> getRoleList() throws DataAccessException {
		return roleDao.getRoleList();
	}

	public List<Role> getRolesByUser(int user_id) throws DataAccessException {
		return roleDao.getRolesByUser(user_id);
	}

	public Role findById(int id) throws DataAccessException {
		return roleDao.findById(id);
	}

	public boolean delete(int id_role) throws DataAccessException {
		return roleDao.delete(id_role);
	}

}
