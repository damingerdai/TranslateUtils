package org.aming.translate.impl;

import java.util.Map;

import org.aming.http.HttpRequest;
import org.aming.translate.AbstractDispatch;
import org.aming.translate.Dispatch;
import org.aming.translate.impl.YoudaoDispatch.YoudaoLanguage;
import org.aming.utils.Assert;
import org.aming.utils.StringUtils;

import com.google.common.collect.Maps;

public class BaiduDispatch extends AbstractDispatch implements Dispatch {

	private static final String URL = "http://fanyi.baidu.com/v2transapi";

	public String translate(String from, String targ, String query) {
		HttpRequest httpRequest = new HttpRequest();
		return StringUtils.trim(httpRequest.doPost(URL, initParamsMap(from, targ, query)));
	}
	
	protected String translate(int from, int targ, String query) {
		HttpRequest httpRequest = new HttpRequest();
		return StringUtils.trim(httpRequest.doPost(URL, initParamsMap(from, targ, query)));
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
	
	protected Map<String, String> initParamsMap(int from, int targ, String query) {
		return initParamsMap(BaiduLanguage.getLanguage(from),BaiduLanguage.getLanguage(targ),query);
	}
	
	private Map<String,String> initParamsMap(BaiduLanguage from,BaiduLanguage targ,String query){
		Assert.notNull(from, targ, "from或者targ必须初始化");
		return initParamsMap(from.getStatus(),targ.getStatus(),query);
	}
	
	/**
	 * 将标准的语言代码转化为baidu标准的语言代码
	 * @author aming
	 * @version 2017-02-09
	 */
	protected static enum BaiduLanguage {
		EN(1,"en"),
		ZH_CN(2,"zh");
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

		private BaiduLanguage(int id,String status){
			this.id = id;;
			this.status = status;
		}
		
		public static BaiduLanguage getLanguage(int status){
			for(BaiduLanguage bl:values()){
				if(bl.id == status){
					return bl;
				}
			}
			return null;
		}
		
		public static BaiduLanguage getLanguage(String status){
			for(BaiduLanguage bl:values()){
				if(StringUtils.equalsIgnoreCase(bl.status, status)){
					return bl;
				}
			}
			return null;
		}
	}
}
