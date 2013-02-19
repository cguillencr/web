package org.monarca.exceptions;

public class NoProjectWithThatDescription extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NoProjectWithThatDescription()
	{
		super("There is more than 1 project with that description");
	}
}
