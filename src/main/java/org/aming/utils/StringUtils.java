package org.aming.utils;

import java.util.Map;

import org.aming.constants.Constant;

/**
 * 字符串工具类
 * @author aming
 * @version 2017-01-06
 *
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	public static String replaceAll(final String text, final String searchString, final String replacement){
		return replace(text, searchString,replacement);
	}
	
	/**
	 * Replace the {0}-{1}-{2} to the parameter values
	 * 
	 * @param arg
	 * @param parameters
	 * @return
	 */
	public static String getDetailMsg(String arg, String[] parameters) {
		if (arg == null || parameters == null || parameters.length < 1) {
			return arg;
		}
		try {
			String prefix = Constant.ERROR_REPLACE_PREFIX;
			String suffix = Constant.ERROR_REPLACE_SUFFIX;
			String replace = null;
			String paraValue = null;
			for (int i = 0, len = parameters.length; i < len; i++) {
				paraValue = parameters[i];
				paraValue = paraValue == null ? "" : paraValue;
				replace = prefix + i + suffix;
				arg = StringUtils.replaceAll(arg, replace, paraValue);
			}
		} catch (Exception e) {
			//logger.error("[Error:{}]", e.getMessage());
		}

		return arg;
	}
	
	public static String toURLParams(Map<String, String> params) {
		StringBuffer buffer = new StringBuffer();
		for (Map.Entry<String, String> param : params.entrySet()) {
			buffer.append("&").append(param.getKey()).append("=").append(param.getValue());
		}
		return buffer.substring(1);
	}
}
