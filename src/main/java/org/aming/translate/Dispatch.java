package org.aming.translate;

import org.aming.enums.Language;
import org.aming.exceptions.AmingException;

public interface Dispatch {
	
	String translate(Language from ,Language targ,String query) throws AmingException;
	
	String translate(String from ,String targ,String query) throws AmingException;
}
