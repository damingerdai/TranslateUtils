package org.aming.translate;

import org.aming.constants.ErrorCodeConstant;
import org.aming.enums.Language;
import org.aming.exceptions.AmingException;
import org.aming.exceptions.ExceptionBuilder;

public abstract class AbstractDispatch implements Dispatch {
	
	protected final static String URL = null;
	
	public String translate(Language from, Language targ, String query) throws AmingException {		 
		throw ExceptionBuilder.buildAmingException(ErrorCodeConstant.ERROR_TRANSLATE,from.getStatus(),targ.getStatus(),query);
	}
	
	public String translate(String from,String targ,String query) throws AmingException{
		return translate(Language.getLanguage(from),Language.getLanguage(targ),query);
	}
}
