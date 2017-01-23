package org.aming.http;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.aming.logger.AmingLogger;
import org.aming.logger.LoggerManager;
import org.aming.utils.DateUtils;
import org.aming.utils.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Lists;

/**
 * 发送http请求
 * 
 * @author aming
 * @version 2017-01-20
 */
public class HttpRequest {
	private static AmingLogger logger = LoggerManager.getLogger(HttpRequest.class);
	
	public String doGet(String url){
		HttpGet httpGet = new HttpGet();
		httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
		return doHttp(new HttpGet(url));
		 
	}
	
	public String doGet(String url, Map<String, String> paramsMap) {
		return doHttp(new HttpGet(url + "?" + StringUtils.toURLParams(paramsMap)));
	}

	public String doGet(String url, String params) {
		return doHttp(new HttpGet(url + "?" + params));
	}

	public String doPost(String url, Map<String, String> paramsMap) {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(toPostParams(paramsMap), Consts.UTF_8));
		httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
		return doHttp(httpPost);
	}

	protected String doHttp(HttpRequestBase httpMethod) {
		HttpClient httpclient = HttpClients.createDefault();
		String result = null;
		CloseableHttpResponse response = null;
		try {
			// 请求开始
			long start = System.currentTimeMillis();
			// 执行请求
			response = (CloseableHttpResponse) httpclient.execute(httpMethod, HttpClientContext.create());
			// 请求结束
			long end = System.currentTimeMillis();

			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				// 转换结果
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity, "UTF-8");
					// 消费掉内容
					EntityUtils.consume(entity);
				}
			}
			logger.info("调用耗时：{}, 状态码：{}, 结果：{}", DateUtils.formatTime(end - start),
					response.getStatusLine().getStatusCode(), result);
		} catch (Exception e) {
			logger.error("调用异常：{}", e.getMessage());
		} finally {
			// 释放连接
			try {
				response.close();
			} catch (IOException e) {
				logger.error("{}关闭异常：{}", response, e.getMessage());
			}
			httpMethod.releaseConnection();
		}
		return result;
	}

	private List<NameValuePair> toPostParams(Map<String, String> params) {
		List<NameValuePair> paramsList = Lists.newArrayList();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			paramsList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return paramsList;
	}
}
