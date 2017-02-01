package org.aming.translate;


import java.util.Map;

import org.aming.lang.Language;
import org.aming.utils.Assert;

public abstract class AbstractDispatch implements Dispatch {
 
	public String translate(Language from, Language targ, String query)  {
		Assert.notNull(from, targ, "from或者targ必须初始化");
		return translate(from.getId(),targ.getId(),query);
	}
	
	@Deprecated
	public abstract String translate(String from,String targ,String query);
	
	protected abstract String translate(int from,int targ,String query);
	
	@Deprecated
	protected abstract Map<String,String> initParamsMap(String from,String targ,String query);
	
	protected abstract Map<String,String> initParamsMap(int from,int targ,String query);
	 
}
