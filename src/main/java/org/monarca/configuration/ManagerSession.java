package org.monarca.configuration;

import java.util.concurrent.CopyOnWriteArrayList;

public class ManagerSession {
	
	private static ManagerSession managerSession = new ManagerSession();
	private CopyOnWriteArrayList<SessionEntry> list = new CopyOnWriteArrayList<SessionEntry>();
	
	public ManagerSession() 
	 {

	  
	 } 
	 
    public static ManagerSession getInstance() 
    {
        return managerSession;
    }
    
    public static CopyOnWriteArrayList<SessionEntry> getSessionEntries()
    {
    	return getInstance().list;
    }
    
    public static void  addSessionEntry(SessionEntry sessionEntry )
    {
    	
    	getInstance().list.add(sessionEntry);
    }
       
    
    public static void unbindSession(String session, String monarcaUser)
    {
    	CopyOnWriteArrayList<SessionEntry> list = ManagerSession.getSessionEntries();
    	boolean sessionExists=false;
    	SessionEntry entry = new SessionEntry();
    	for(SessionEntry sessionEntry :  list)
    	{
    		entry = sessionEntry;						
			if(session.equalsIgnoreCase(entry.getSession())&& ! sessionExists)
			{
				entry.setMonarcaUser(null);
				sessionExists=true;
				break;
			}
		}
    }
    
    public static void bindSession(String session, String monarcaUser)
    {   	
    	CopyOnWriteArrayList<SessionEntry> list = ManagerSession.getSessionEntries();
    	boolean sessionExists=false;
    	SessionEntry entry = new SessionEntry();
    	for(SessionEntry sessionEntry :  list)
    	{
    		entry = sessionEntry;						
			if(session.equalsIgnoreCase(entry.getSession())&& ! sessionExists)
			{
				entry.setMonarcaUser(monarcaUser);
				sessionExists=true;
				break;
			}
		}
    }
}
