package org.aming.translate.impl;

import java.util.Map;

import org.aming.enums.Language;
import org.aming.http.HttpRequest;
import org.aming.translate.AbstractDispatch;
import org.aming.translate.Dispatch;
import org.aming.utils.StringUtils;

import com.google.common.collect.Maps;

public class YoudaoDispatch extends AbstractDispatch implements Dispatch {

	private final static String URL = "http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule&smartresult=ugc&sessionFrom=https://www.baidu.com/link";
	
	public String translate(String from, String targ, String query){
		Map<String,String> paramsMap = initParamsMap(from,targ,query);
		HttpRequest httpRequest = new HttpRequest();
		return StringUtils.trim(httpRequest.doGet(URL+"&"+StringUtils.toURLParams(paramsMap)));
	}
	
	 
	protected String translate(int from, int targ, String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected Map<String,String> initParamsMap(String from,String targ,String query){
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
	
	/**
	 * 将标准的语言代码转化为youdao标准的语言代码
	 * @author aming
	 * 
	 */
	private static enum YoudaoLanguage{
		EN(1,"EN"),
		ZH_CN(2,"ZH_CN");
		private int id;
		private String status;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		private YoudaoLanguage(int id,String status){
			this.id = id;;
			this.status = status;
		}
	}

	
	
}
