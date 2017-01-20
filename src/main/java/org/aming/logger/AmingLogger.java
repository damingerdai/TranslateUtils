package org.aming.logger;

import org.slf4j.Logger;

/**
 * 日志类
 * @author aming
 * @version 2017-01-20
 */
public class AmingLogger {
	
	private Logger logger;
	
	public AmingLogger(Logger logger){
		this.logger = logger;
	}
	
	public Logger getLogger(){
		return logger;
	}
	
	
	public void trace(String msg) {
		if (logger.isTraceEnabled()) {
			logger.trace(msg);
		}
	}
	
	public void trace(String msg,Object...obj){
		if (logger.isTraceEnabled()) {
			logger.trace(msg,obj);
		}
	}
	
	public void info(String msg) {
		if (logger.isInfoEnabled()) {
			logger.info(msg);
		}
	}
	
	public void info(String msg,Object...obj){
		if (logger.isTraceEnabled()) {
			logger.trace(msg,obj);
		}
	}
	
	public void warn(String msg) {
		if (logger.isWarnEnabled()) {
			logger.warn(msg);
		}
	}
	
	public void warn(String msg,Object...obj){
		if (logger.isTraceEnabled()) {
			logger.trace(msg,obj);
		}
	}
	
	public void error(String msg) {
		if (logger.isErrorEnabled()) {
			logger.error(msg);
		}
	}
	
	public void error(String msg,Object...obj){
		if (logger.isTraceEnabled()) {
			logger.trace(msg,obj);
		}
	}
}
