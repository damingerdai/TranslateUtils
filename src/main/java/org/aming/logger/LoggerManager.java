package org.aming.logger;

import java.util.Map;
import org.slf4j.LoggerFactory;
import com.google.common.collect.Maps;

/**
 * 日志管理器
 * @author aming
 * @version 2017-01-20
 */
public class LoggerManager {
	/**
	 * 存储日志对象
	 */
	private static Map<String,AmingLogger> loggerMap;
	
	static{
		loggerMap = Maps.newHashMap();
	}
	

	/**
	 * Return the logger by logger name defined in logger property file
	 * @param loggerName
	 * @return
	 */
	public static AmingLogger getLogger(String loggerName) {
		if (loggerMap.containsKey(loggerName)) {
			return loggerMap.get(loggerName);
		} else {
			AmingLogger logger = new AmingLogger(
					LoggerFactory.getLogger(loggerName));
			loggerMap.put(loggerName, logger);
			return logger;
		}
	}
	
	public static AmingLogger getLogger(Class<?> clazz){
		return getLogger(clazz.getSimpleName());
	}
}
