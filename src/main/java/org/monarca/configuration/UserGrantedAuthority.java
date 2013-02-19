package org.monarca.configuration;


import org.springframework.security.core.GrantedAuthority;

	public class UserGrantedAuthority implements GrantedAuthority {
	    private static final long serialVersionUID = -3786297951121082647L;
	    private String authority = null;	
	    public UserGrantedAuthority(String auth) {
	        authority = auth;	
	    }
	    @Override	
	    public String getAuthority() {	
	        return authority;	
	    }
}
