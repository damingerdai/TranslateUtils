package org.aming.translate.impl;

import java.util.Map;

import org.aming.enums.Language;
import org.aming.exceptions.AmingException;
import org.aming.translate.AbstractDispatch;
import org.aming.translate.Dispatch;

import com.google.common.collect.Maps;

public class YoudaoDispatch extends AbstractDispatch implements Dispatch {

	private final static String URL = "http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule&smartresult=ugc&sessionFrom=https://www.baidu.com/link";
	public String translate(Language from, Language targ, String query) throws AmingException {
		
		return super.translate(from, targ, query);
	}
	
	private Map<String,String> initParamMap(){
		Map<String,String> paramMap = Maps.newHashMap();
		return paramMap;
	}

	 
	public String translate(String from, String targ, String query) throws AmingException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
