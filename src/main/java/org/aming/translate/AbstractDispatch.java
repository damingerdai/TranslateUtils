package org.aming.translate;

import org.aming.enums.Language;

public abstract class AbstractDispatch implements Dispatch {
	protected final static String URL = null;
 
	public String translate(Language from, Language targ, String query)  {		 
		 throw new UnsupportedOperationException();
	}
	
	public abstract String translate(String from,String targ,String query);
}
