package org.aming.exceptions;

import org.aming.config.ApplicationConfiguration;
import org.aming.constants.Constant;
import org.aming.logger.LoggerManager;
import org.aming.utils.StringUtils;
import org.slf4j.Logger;

 

/**
 * 异常创建器
 * @author aming
 * @version 2017-01-20
 *
 */
public class ExceptionBuilder {
	private static Logger logger = LoggerManager.getErrorLogger().getLogger();
 
	public static AmingException buildAmingException(String errorCode, Throwable cause) {
		String errorMsg = ApplicationConfiguration.getProperty(errorCode);
		AmingException exception = new AmingException(errorCode, errorMsg, cause);
		log(exception);
		return exception;
	}
	
	 
	public static AmingException buildAmingException(String errorCode, String parameter, Throwable cause) {
		return buildAmingException(errorCode,new String[]{parameter}, cause);
	}

	 
	public static AmingException buildAmingException(String errorCode, String[] parameters, Throwable cause) {
		String errorMsg = ApplicationConfiguration.getProperty(errorCode);
		errorMsg = getDetailMsg(errorMsg, parameters);
		AmingException exception = new AmingException(errorCode, errorMsg, cause);
		log(exception);
		return exception;
	}
	
	public static AmingException buildAmingException(String errorCode,String...parameters){
		return buildAmingException(errorCode,parameters,null);
	}
	
	/**
	 * Replace the {0}-{1}-{2} to the parameter values
	 * 
	 * @param arg
	 * @param parameters
	 * @return
	 */
	private static String getDetailMsg(String arg, String[] parameters) {
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
			logger.error("[Error:{}]", e.getMessage());
		}

		return arg;
	}

	/**
	 * 打印log
	 * 
	 * @param exception
	 */
	private static void log(AmingException exception) {
		if (exception.getCause() != null) {
			logger.error("[ERROR-CODE:{}] [ERROR-MSG:{}] [LOCALMESSAGE:{}]", exception.getErrCode(),
					exception.getErrMsg(), exception.getCause().getMessage());
		} else {
			logger.error("[ERROR-CODE:{}] [ERROR-MSG:{}]", exception.getErrCode(), exception.getErrMsg());
		}
	}
}
