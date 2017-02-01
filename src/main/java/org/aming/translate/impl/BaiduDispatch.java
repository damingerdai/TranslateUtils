package org.aming.translate.impl;

import java.util.Map;

import org.aming.http.HttpRequest;
import org.aming.translate.AbstractDispatch;
import org.aming.translate.Dispatch;

import com.google.common.collect.Maps;

public class BaiduDispatch extends AbstractDispatch implements Dispatch {

	private static final String URL = "http://fanyi.baidu.com/v2transapi";

	public String translate(String from, String targ, String query) {
		HttpRequest httpRequest = new HttpRequest();
		return httpRequest.doPost(URL, initParamsMap(from, targ, query));
	}

	protected Map<String, String> initParamsMap(String from, String targ, String query) {
		Map<String, String> paramsMap = Maps.newHashMap();
		paramsMap.put("from", from);
		paramsMap.put("to", targ);
		paramsMap.put("query", query);
		paramsMap.put("transtype", "translang");
		paramsMap.put("simple_means_flag", "3");
		return paramsMap;
	}

 
	protected String translate(int from, int targ, String query) {
		return null;
	}

	 
	protected Map<String, String> initParamsMap(int from, int targ, String query) {

		return null;
	}

}
