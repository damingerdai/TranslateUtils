package org.aming.utils;

/**
 * 时间工具类
 * @author aming
 * @version 2017-01-20
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{
	/*
	 * 毫秒转化时分秒毫秒
	 */
	public static String formatTime(Long ms) {
		if(ms < 0){
			 return "时间异常";
		}
		if(ms < 1000){
			return (double)(ms/1000.0) + "秒";
		}
		Integer ss = 1000;
		Integer mi = ss * 60;
		Integer hh = mi * 60;
		Integer dd = hh * 24;

		Long day = ms / dd;
		Long hour = (ms - day * dd) / hh;
		Long minute = (ms - day * dd - hour * hh) / mi;
		Long second = (ms - day * dd - hour * hh - minute * mi) / ss;

		StringBuffer sb = new StringBuffer();
		if (day > 0) {
			sb.append(day + "天");
		}
		if (hour > 0) {
			sb.append(hour + "小时");
		}
		if (minute > 0) {
			sb.append(minute + "分");
		}
		if (second > 0) {
			sb.append(second + "秒");
		}
		return sb.toString();
	}
}
