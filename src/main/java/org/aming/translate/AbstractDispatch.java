package org.aming.translate;

import java.util.Map;

import org.aming.enums.Language;

public abstract class AbstractDispatch implements Dispatch {
	// final static String URL = null;
 
	public String translate(Language from, Language targ, String query)  {		 
		return translate(from.getStatus(),targ.getStatus(),query);
	}
	
	public abstract String translate(String from,String targ,String query);
	
	protected abstract Map<String,String> initParamsMap(String from,String targ,String query);
	 
}
