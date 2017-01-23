package org.aming.utils;

import java.util.Map;


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
	
	public static String toURLParams(Map<String, String> params) {
		StringBuffer buffer = new StringBuffer();
		for (Map.Entry<String, String> param : params.entrySet()) {
			buffer.append("&").append(param.getKey()).append("=").append(param.getValue());
		}
		return buffer.substring(1);
	}
}
