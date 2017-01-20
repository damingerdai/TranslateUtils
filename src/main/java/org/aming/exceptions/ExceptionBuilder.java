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
	/**
	 * 创建一个由错误代码引发的AcxionException
	 * 
	 * @param errorCode
	 * @param cause
	 * @return
	 */
	public static AmingException buildAmingException(String errorCode, Throwable cause) {
		String errorMsg = ApplicationConfiguration.getProperty(errorCode);
		AmingException exception = new AmingException(errorCode, errorMsg, cause);
		log(exception);
		return exception;
	}
	
	/**
	 * 创建一个由错误代码引发的AcxionException
	 * parameter将取代第{ }错误代码属性文件中定义的错误消息。
	 * @param errorCode
	 * @param parameter
	 * @param cause
	 * @return
	 */
	public static AmingException buildAAmingException(String errorCode, String parameter, Throwable cause) {
		return buildAmingException(errorCode,new String[]{parameter}, cause);
	}

	/**
	 * 创建一个由错误代码引发的AcxionException
	 * parameters将取代第{ }错误代码属性文件中定义的错误消息。
	 * @param errorCode
	 * @param parameter
	 * @param cause
	 * @return
	 */
	public static AmingException buildAmingException(String errorCode, String[] parameters, Throwable cause) {
		String errorMsg = ApplicationConfiguration.getProperty(errorCode);
		errorMsg = getDetailMsg(errorMsg, parameters);
		AmingException exception = new AmingException(errorCode, errorMsg, cause);
		log(exception);
		return exception;
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
				//arg = StringUtils.replaceAll(arg, replace, paraValue);
				StringUtils.replace
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
