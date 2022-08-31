package Exceptions;

import entity.Flight;

public class NoComponentsExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoComponentsExceptions(Flight f) {
		super("The flight "+ f + " does not includes any components!");
		
	}
	
}
