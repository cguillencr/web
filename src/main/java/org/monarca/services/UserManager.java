package org.monarca.services;

import java.util.List;

import org.monarca.dao.JPARoleDao;
import org.monarca.dao.JPAUserDAO;
import org.monarca.entities.Role;
import org.monarca.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserManager implements  UserDetailsService{

	private static final long serialVersionUID = 1L;

    @Autowired
    private JPAUserDAO  userDao;
    
    @Autowired
    private JPARoleDao roleDao;
    

    public void setUserDao(JPAUserDAO userDao) {
        this.userDao = userDao;
    }	

	public List<User> getUserList() throws DataAccessException {
		return userDao.getUserList();
	}

	public boolean save(User user) throws DataAccessException {
		return userDao.save(user);
	}

	public User findById(int user_id) throws DataAccessException {
		return userDao.findById(user_id);
	}

	public List<User> getUsersByRole(int role_id) throws DataAccessException {
		return userDao.getUsersByRole(role_id);
	}

	public boolean delete(int user_id) throws DataAccessException {
		return userDao.delete(user_id);
	}

	public User getUser(String name, String password)
			throws DataAccessException {
		return userDao.getUser(name, password);
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {		

		User user = userDao.loadUserByName(username);	
		List<Role> roles = roleDao.getRolesByUser(user.getId());
		GrantedAuthority[] ga = new GrantedAuthority[roles.size()];
		int index = 0;
		for(Role role : roles)
		{
			ga[index] = new GrantedAuthorityImpl(role.getName());
			index++;
		}			          
		user.setAuthorities(ga);			          
		return user;			
	}
}
