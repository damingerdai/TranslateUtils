package org.aming.translate.impl;

import java.util.Map;

import org.aming.enums.Language;
import org.aming.exceptions.AmingException;
import org.aming.http.HttpRequest;
import org.aming.translate.AbstractDispatch;
import org.aming.translate.Dispatch;

import com.google.common.collect.Maps;

public class YoudaoDispatch extends AbstractDispatch implements Dispatch {

	private final static String URL = "http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule&smartresult=ugc&sessionFrom=https://www.baidu.com/link";
	public String translate(Language from, Language targ, String query) throws AmingException {
		try{
			translate(from.getStatus(),targ.getStatus(),query);
		}catch(Exception e){
			 
		}
		return null;
	}
	
	public String translate(String from, String targ, String query) throws AmingException {
		Map<String,String> paramsMap = initParamsMap(from,targ,query);
		HttpRequest httpRequest = new HttpRequest();
		return httpRequest.doPost(URL, paramsMap);
	}
	
	private Map<String,String> initParamsMap(String from,String targ,String query){
		Map<String,String> paramsMap = Maps.newHashMap();
		paramsMap.put("type",  from+"2"+targ);
		paramsMap.put("i", query);
		paramsMap.put("doctype", "json");
		paramsMap.put("xmlVersion", "1.8");
		paramsMap.put("keyfrom", "fanyi.web");
		paramsMap.put("ue", "UTF-8");
		paramsMap.put("action", "FY_BY_CLICKBUTTON");
		paramsMap.put("typoResult", "true");
		return paramsMap;
	}

	 
	public static void main(String[] args){
		Dispatch d = new YoudaoDispatch();
		System.out.println(d.translate(Language.ZH_CN, Language.EN,"你好"));
	}
	
}
