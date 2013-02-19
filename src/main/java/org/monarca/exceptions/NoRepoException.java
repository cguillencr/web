package org.monarca.exceptions;

public class NoRepoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NoRepoException()
	{
		super("There is no database in the workspace");
	}
}
