package org.aming.config;

import java.util.Map;

import org.aming.utils.PropertiesLoader;
import org.aming.utils.StringUtils;

import com.google.common.collect.Maps;

/**
 * 应用配置类
 * @author aming
 * @version 2017-01-20
 *
 */
public final class ApplicationConfiguration {
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("application.properties");
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();
	
	/**
	 * 获取application.properties配置文件信息
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		String value = map.get(key);
		if (value == null) {
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
}
