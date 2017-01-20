package org.aming.utils;

/**
 * 字符串工具类
 * @author aming
 * @version 2017-01-06
 *
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	public String replaceAll(final String text, final String searchString, final String replacement){
		return replace(text, searchString,replacement);
	}
}
