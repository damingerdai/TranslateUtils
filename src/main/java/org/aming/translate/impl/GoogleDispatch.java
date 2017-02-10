package org.aming.translate.impl;

import java.util.Map;

import org.aming.translate.AbstractDispatch;
import org.aming.translate.Dispatch;
import org.aming.utils.StringUtils;

import com.google.common.collect.Maps;

public class GoogleDispatch extends AbstractDispatch implements Dispatch {

	@Override
	public String translate(String from, String targ, String query) {
		 
		return null;
	}

	@Override
	protected String translate(int from, int targ, String query) {
		 
		return null;
	}

	@Override
	protected Map<String, String> initParamsMap(String from, String targ, String query) {
		Map<String,String> paramsMap = Maps.newHashMap();
		paramsMap.put("client", "t");
		paramsMap.put("sl", from);
		paramsMap.put("t1",targ);
		paramsMap.put("h1","zh_CH");
		paramsMap.put("dt", "at");
		//paramsMap.put("")
		return null;
	}

	@Override
	protected Map<String, String> initParamsMap(int from, int targ, String query) {
		 
		return null;
	}
	
	protected static enum GoogleLanguage{
		EN(1,"en"),
		ZH_CN(2,"zh_CN");
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

		private GoogleLanguage(int id,String status){
			this.id = id;;
			this.status = status;
		}
		
		public static GoogleLanguage getLanguage(int status){
			for(GoogleLanguage gl:values()){
				if(gl.id == status){
					return gl;
				}
			}
			return null;
		}
		
		public static GoogleLanguage getLanguage(String status){
			for(GoogleLanguage gl:values()){
				if(StringUtils.equalsIgnoreCase(gl.status,status)){
					return gl;
				}
			}
			return null;
		}
	}

}
