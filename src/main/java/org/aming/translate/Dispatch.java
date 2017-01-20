package org.aming.translate;

import org.aming.exceptions.AmingException;

public interface Dispatch {
	
	String Translate(String from ,String targ,String query) throws AmingException;
}
