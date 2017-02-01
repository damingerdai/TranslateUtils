package org.aming.translate;

import org.aming.lang.Language;

public interface Dispatch {
	
	String translate(Language from ,Language targ,String query);
}
