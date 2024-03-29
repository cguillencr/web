package org.monarca.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user")
public class User implements UserDetails{ 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name = "userName")
	private String name;
	

	@Column(name = "password")
	private String password;
    private GrantedAuthority[] authorities = null;	

	public void setAuthorities(GrantedAuthority[] authorities) {
		this.authorities = authorities;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
    @Override
    public String getPassword() {
        return this.password;
    }

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
	       Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	        for (int i = 0; i < authorities.length; i++) {
	            auth.add(authorities[i]);
	        }
	        return auth;

	}
	   @Override
	    public String getUsername() {
	        return this.name;
	    }
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
}
