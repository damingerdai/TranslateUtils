package org.aming.translate;

import org.aming.exceptions.AmingException;
import org.aming.exceptions.ExceptionBuilder;

public abstract class AbstractDispatch implements Dispatch {

	public String Translate(String from, String targ, String query) throws AmingException {
		 
		return ExceptionBuilder.buildAAmingException();
	}

}
