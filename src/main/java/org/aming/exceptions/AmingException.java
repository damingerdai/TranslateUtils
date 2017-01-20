package org.aming.exceptions;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 异常类
 * @author aming
 * @version 2017-01-20
 *
 */
public class AmingException extends RuntimeException{
	
	private static final long serialVersionUID = 183970057515588395L;

	/**
	 * 异常代码
	 */
	private String errCode;
	
	/**
	 * 异常信息
	 */
	private String errMsg;
	
	/**
	 * 异常
	 */
	private Throwable cause;
	
	public AmingException(){
		super();
	}
	
	public AmingException(String errCode, String errMsg, Throwable cause) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.cause = cause;
	}

	public String toString() {
		return  ToStringBuilder.reflectionToString(this);
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	} 	
}
