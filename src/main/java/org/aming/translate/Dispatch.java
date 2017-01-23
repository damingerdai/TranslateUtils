package org.aming.translate;

import org.aming.enums.Language;

public interface Dispatch {
	
	String translate(Language from ,Language targ,String query);
	
	//String translate(String from ,String targ,String query);
}
