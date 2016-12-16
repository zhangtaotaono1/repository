package util;
/**   
 * @Title: HttpClientUtils.java 
 * @Package com.lc.pays.util
 * @Description: HttpClientUtils
 * @author kouken   
 * @date 2015-12-24
 * @version V1.0   
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/**
 * HttpClientUtils
 * 依赖的jar包有：commons-lang-2.6.jar、httpclient-4.3.2.jar、httpcore-4.3
 * .1.jar、commons-io-2.4.jar
 * 
 */
public class HttpClientUtils {

	public static final int connTimeout = 60000;
	public static final int readTimeout = 60000;
	public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";
	public static final String URL_PARAM_DECODECHARSET_GBK = "GBK";
	public static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";
	public static final String APPLICATION_STANDARD = "application/x-www-form-urlencoded";

	private static HttpClient client = null;

	static {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(128);
		cm.setDefaultMaxPerRoute(128);
		client = HttpClients.custom().setConnectionManager(cm).build();
	}
	
	/**
	 * 
	 * @param httpUrl   URL
	 * @param Method    请求方式 get/post
	 * @param httpArg   请求参数
	 * @param params
	 * @return
	 */
	public static String request(String httpUrl,String Method, String httpArg,Map<String, String> params) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		if ("GET".equalsIgnoreCase(Method)) {
			httpUrl=httpUrl+"?"+httpArg;
		}
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
			.openConnection();
			connection.setRequestMethod(Method);//请求方式
			Set<Entry<String, String>> entrySet = params.entrySet();  
           
			if (params != null && !params.isEmpty()){
			for (Entry<String, String> entry : entrySet) {  
              connection.setRequestProperty(entry.getKey(), entry.getValue());
//              connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
//              connection.setRequestProperty("apikey", "8ace4f47915ebed5baf86eef11827bda");
             }
		    }
			if ("POST".equalsIgnoreCase(Method)) {
				connection.setDoOutput(true);
				connection.getOutputStream().write(httpArg.getBytes("UTF-8"));
			}
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Post请求发送 (JSON)
	 * 
	 * @param url
	 * @param String
	 *            json
	 * @return ResponseBody, 使用指定的字符集编码.
	 * @throws ConnectTimeoutException
	 *             建立链接超时异常
	 */
	public static String postParametersWithJson(String url, String json)
			throws Exception {
		return postForm(url, json, connTimeout, readTimeout);
	}

	/**
	 * Post请求发送 (String)
	 * 
	 * @param url
	 * @param parameterStr
	 * @return ResponseBody, 使用指定的字符集编码.
	 * @throws ConnectTimeoutException
	 *             建立链接超时异常
	 * @throws SocketTimeoutException
	 *             响应超时
	 * @throws Exception
	 */
	public static String postParameters(String url, String parameterStr)
			throws ConnectTimeoutException, SocketTimeoutException, Exception {
		return post(url, parameterStr, APPLICATION_STANDARD,
				URL_PARAM_DECODECHARSET_UTF8, connTimeout, readTimeout);
	}

	/**
	 * Post请求发送 (String)
	 * 
	 * @param url
	 * @param parameterStr
	 * @param mimeType
	 *            例如 application/xml "application/x-www-form-urlencoded"
	 *            a=1&b=2&c=3
	 * @param charset
	 *            编码
	 * @param connTimeout
	 *            建立链接超时时间,毫秒.
	 * @param readTimeout
	 *            响应超时时间,毫秒.
	 * @return ResponseBody, 使用指定的字符集编码.
	 * @throws ConnectTimeoutException
	 *             建立链接超时异常
	 * @throws SocketTimeoutException
	 *             响应超时
	 * @throws Exception
	 */
	public static String postParameters(String url, String parameterStr,
			String charset, Integer connTimeout, Integer readTimeout)
			throws ConnectTimeoutException, SocketTimeoutException, Exception {
		return post(url, parameterStr, APPLICATION_STANDARD, charset,
				connTimeout, readTimeout);
	}

	/**
	 * Post请求发送 (Map)
	 * 
	 * @param url
	 * @param params
	 *            Map
	 * @return ResponseBody, 使用指定的字符集编码.
	 * @throws ConnectTimeoutException
	 *             建立链接超时异常
	 */
	public static String postParameters(String url, Map<String, String> params)
			throws ConnectTimeoutException, SocketTimeoutException, Exception {
		return postForm(url, params, null, connTimeout, readTimeout);
	}

	/**
	 * Post请求发送 (Map)
	 * 
	 * @param url
	 * @param params
	 *            Map
	 * @param mimeType
	 *            例如 application/xml "application/x-www-form-urlencoded"
	 *            a=1&b=2&c=3
	 * @param connTimeout
	 *            建立链接超时时间,毫秒.
	 * @param readTimeout
	 *            响应超时时间,毫秒.
	 * @return ResponseBody, 使用指定的字符集编码.
	 * @throws ConnectTimeoutException
	 *             建立链接超时异常
	 * @throws SocketTimeoutException
	 *             响应超时
	 * @throws Exception
	 */
	public static String postParameters(String url, Map<String, String> params,
			Integer connTimeout, Integer readTimeout)
			throws ConnectTimeoutException, SocketTimeoutException, Exception {
		return postForm(url, params, null, connTimeout, readTimeout);
	}

	/**
	 * get请求发送
	 * 
	 * @param url
	 * @return ResponseBody, 使用指定的字符集编码.
	 * @throws ConnectTimeoutException
	 *             建立链接超时异常
	 * @throws SocketTimeoutException
	 *             响应超时
	 * @throws Exception
	 */
	public static String get(String url) throws Exception {
		return get(url, URL_PARAM_DECODECHARSET_UTF8, null, null);
	}

	/**
	 * get请求发送
	 * 
	 * @param url
	 * @param charset
	 *            编码
	 * @return ResponseBody, 使用指定的字符集编码.
	 * @throws ConnectTimeoutException
	 *             建立链接超时异常
	 * @throws SocketTimeoutException
	 *             响应超时
	 * @throws Exception
	 */
	public static String get(String url, String charset) throws Exception {
		return get(url, charset, connTimeout, readTimeout);
	}

	/**
	 * Post请求发送 (String)
	 * 
	 * @param url
	 * @param body
	 *            RequestBody
	 * @param mimeType
	 *            例如 application/xml "application/x-www-form-urlencoded"
	 *            a=1&b=2&c=3
	 * @param charset
	 *            编码
	 * @param connTimeout
	 *            建立链接超时时间,毫秒.
	 * @param readTimeout
	 *            响应超时时间,毫秒.
	 * @return ResponseBody, 使用指定的字符集编码.
	 * @throws ConnectTimeoutException
	 *             建立链接超时异常
	 * @throws SocketTimeoutException
	 *             响应超时
	 * @throws Exception
	 */
	public static String post(String url, String body, String mimeType,
			String charset, Integer connTimeout, Integer readTimeout)
			throws ConnectTimeoutException, SocketTimeoutException, Exception {
		HttpClient client = null;
		HttpPost post = new HttpPost(url);
		String result = "";
		try {
			if (StringUtils.isNotBlank(body)) {
				HttpEntity entity = new StringEntity(body, ContentType.create(
						mimeType, charset));
				post.setEntity(entity);
			}
			// 设置参数
			Builder customReqConf = RequestConfig.custom();
			if (connTimeout != null) {
				customReqConf.setConnectTimeout(connTimeout);
			}
			if (readTimeout != null) {
				customReqConf.setSocketTimeout(readTimeout);
			}
			post.setConfig(customReqConf.build());

			HttpResponse res;
			if (url.startsWith("https")) {
				// 执行 Https 请求.
				client = createSSLInsecureClient();
				res = client.execute(post);
			} else {
				// 执行 Http 请求.
				client = HttpClientUtils.client;
				res = client.execute(post);
			}
			result = IOUtils.toString(res.getEntity().getContent(), charset);
		} finally {
			post.releaseConnection();
			if (url.startsWith("https") && client != null
					&& client instanceof CloseableHttpClient) {
				((CloseableHttpClient) client).close();
			}
		}
		return result;
	}
	
	/**
	 * Post请求发送 (String)
	 * 
	 * @param url
	 * @param body
	 *            RequestBody
	 * @param headers
	 * 			  请求头参数
	 * @param mimeType
	 *            例如 application/xml "application/x-www-form-urlencoded"
	 *            a=1&b=2&c=3
	 * @param charset
	 *            编码
	 * @param connTimeout
	 *            建立链接超时时间,毫秒.
	 * @param readTimeout
	 *            响应超时时间,毫秒.
	 * @return ResponseBody, 使用指定的字符集编码.
	 * @throws ConnectTimeoutException
	 *             建立链接超时异常
	 * @throws SocketTimeoutException
	 *             响应超时
	 * @throws Exception
	 */
	public static String post(String url, Map<String, String> headers, String body, String mimeType,
			String charset, Integer connTimeout, Integer readTimeout)
			throws ConnectTimeoutException, SocketTimeoutException, Exception {
		HttpClient client = null;
		HttpPost post = new HttpPost(url);
		String result = "";
		try {
			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, String> entry : headers.entrySet()) {
					post.addHeader(entry.getKey(), entry.getValue());
				}
			}
			if (StringUtils.isNotBlank(body)) {
				HttpEntity entity = new StringEntity(body, ContentType.create(
						mimeType, charset));
				post.setEntity(entity);
			}
			// 设置参数
			Builder customReqConf = RequestConfig.custom();
			if (connTimeout != null) {
				customReqConf.setConnectTimeout(connTimeout);
			}
			if (readTimeout != null) {
				customReqConf.setSocketTimeout(readTimeout);
			}
			post.setConfig(customReqConf.build());

			HttpResponse res;
			if (url.startsWith("https")) {
				// 执行 Https 请求.
				client = createSSLInsecureClient();
				res = client.execute(post);
			} else {
				// 执行 Http 请求.
				client = HttpClientUtils.client;
				res = client.execute(post);
			}
			result = IOUtils.toString(res.getEntity().getContent(), charset);
		} finally {
			post.releaseConnection();
			if (url.startsWith("https") && client != null
					&& client instanceof CloseableHttpClient) {
				((CloseableHttpClient) client).close();
			}
		}
		return result;
	}

	/**
	 * 提交form表单 (Map)
	 * 
	 * @param url
	 * @param params
	 * @param connTimeout
	 * @param readTimeout
	 * @return
	 * @throws ConnectTimeoutException
	 * @throws SocketTimeoutException
	 * @throws Exception
	 */
	public static String postForm(String url, Map<String, String> params,
			Map<String, String> headers, Integer connTimeout,
			Integer readTimeout) throws ConnectTimeoutException,
			SocketTimeoutException, Exception {

		HttpClient client = null;
		HttpPost post = new HttpPost(url);
		try {
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> formParams = new ArrayList<org.apache.http.NameValuePair>();
				Set<Entry<String, String>> entrySet = params.entrySet();
				for (Entry<String, String> entry : entrySet) {
					formParams.add(new BasicNameValuePair(entry.getKey(), entry
							.getValue()));
				}
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
						formParams, URL_PARAM_DECODECHARSET_UTF8);
				post.setEntity(entity);
			}

			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, String> entry : headers.entrySet()) {
					post.addHeader(entry.getKey(), entry.getValue());
				}
			}
			// 设置参数
			Builder customReqConf = RequestConfig.custom();
			if (connTimeout != null) {
				customReqConf.setConnectTimeout(connTimeout);
			}
			if (readTimeout != null) {
				customReqConf.setSocketTimeout(readTimeout);
			}
			post.setConfig(customReqConf.build());
			HttpResponse res = null;
			if (url.startsWith("https")) {
				// 执行 Https 请求.
				client = createSSLInsecureClient();
				res = client.execute(post);
			} else {
				// 执行 Http 请求.
				client = HttpClientUtils.client;
				res = client.execute(post);
			}
			return IOUtils.toString(res.getEntity().getContent(),
					URL_PARAM_DECODECHARSET_UTF8);
		} finally {
			post.releaseConnection();
			if (url.startsWith("https") && client != null
					&& client instanceof CloseableHttpClient) {
				((CloseableHttpClient) client).close();
			}
		}
	}

	/**
	 * 提交form表单 (JSON)
	 * 
	 * @param url
	 * @param jsonString
	 * @param connTimeout
	 * @param readTimeout
	 * @return
	 * @throws ConnectTimeoutException
	 * @throws SocketTimeoutException
	 * @throws Exception
	 */
	public static String postForm(String url, String jsonString,
			Integer connTimeout, Integer readTimeout)
			throws ConnectTimeoutException, SocketTimeoutException, Exception {

		HttpClient client = null;
		HttpPost post = new HttpPost(url);
		try {
			if (jsonString != null && !jsonString.isEmpty()) {
				post.addHeader(HTTP.CONTENT_TYPE, CONTENT_TYPE_TEXT_JSON);
				StringEntity se = new StringEntity(jsonString,
						URL_PARAM_DECODECHARSET_UTF8);
				se.setContentType(CONTENT_TYPE_TEXT_JSON);
				se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
						CONTENT_TYPE_TEXT_JSON));
				post.setEntity(se);
			}

			// 设置参数
			Builder customReqConf = RequestConfig.custom();
			if (connTimeout != null) {
				customReqConf.setConnectTimeout(connTimeout);
			}
			if (readTimeout != null) {
				customReqConf.setSocketTimeout(readTimeout);
			}
			post.setConfig(customReqConf.build());
			HttpResponse res = null;
			if (url.startsWith("https")) {
				// 执行 Https 请求.
				client = createSSLInsecureClient();
				res = client.execute(post);
			} else {
				// 执行 Http 请求.
				client = HttpClientUtils.client;
				res = client.execute(post);
			}
			return IOUtils.toString(res.getEntity().getContent(),
					URL_PARAM_DECODECHARSET_UTF8);
		} finally {
			post.releaseConnection();
			if (url.startsWith("https") && client != null
					&& client instanceof CloseableHttpClient) {
				((CloseableHttpClient) client).close();
			}
		}
	}

	/**
	 * 发送一个 GET 请求
	 * 
	 * @param url
	 * @param charset
	 * @param connTimeout
	 *            建立链接超时时间,毫秒.
	 * @param readTimeout
	 *            响应超时时间,毫秒.
	 * @return
	 * @throws ConnectTimeoutException
	 *             建立链接超时
	 * @throws SocketTimeoutException
	 *             响应超时
	 * @throws Exception
	 */
	public static String get(String url, String charset, Integer connTimeout,
			Integer readTimeout) throws ConnectTimeoutException,
			SocketTimeoutException, Exception {

		HttpClient client = null;
		HttpGet get = new HttpGet(url);
		String result = "";
		try {
			// 设置参数
			Builder customReqConf = RequestConfig.custom();
			if (connTimeout != null) {
				customReqConf.setConnectTimeout(connTimeout);
			}
			if (readTimeout != null) {
				customReqConf.setSocketTimeout(readTimeout);
			}
			get.setConfig(customReqConf.build());

			HttpResponse res = null;

			if (url.startsWith("https")) {
				// 执行 Https 请求.
				client = createSSLInsecureClient();
				res = client.execute(get);
			} else {
				// 执行 Http 请求.
				client = HttpClientUtils.client;
				res = client.execute(get);
			}

			result = IOUtils.toString(res.getEntity().getContent(), charset);
		} finally {
			get.releaseConnection();
			if (url.startsWith("https") && client != null
					&& client instanceof CloseableHttpClient) {
				((CloseableHttpClient) client).close();
			}
		}
		return result;
	}

	/**
	 * 从 response 里获取 charset
	 * 
	 * @param ressponse
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getCharsetFromResponse(HttpResponse ressponse) {
		// Content-Type:text/html; charset=GBK
		if (ressponse.getEntity() != null
				&& ressponse.getEntity().getContentType() != null
				&& ressponse.getEntity().getContentType().getValue() != null) {
			String contentType = ressponse.getEntity().getContentType()
					.getValue();
			if (contentType.contains("charset=")) {
				return contentType
						.substring(contentType.indexOf("charset=") + 8);
			}
		}
		return null;
	}

	/**
	 * 创建 SSL连接
	 * 
	 * @return
	 * @throws GeneralSecurityException
	 */
	private static CloseableHttpClient createSSLInsecureClient()
			throws GeneralSecurityException {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(
					null, new TrustStrategy() {
						public boolean isTrusted(X509Certificate[] chain,
								String authType) throws CertificateException {
							return true;
						}
					}).build();

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslContext, new X509HostnameVerifier() {

						public boolean verify(String arg0, SSLSession arg1) {
							return true;
						}

						public void verify(String host, SSLSocket ssl)
								throws IOException {
						}

						public void verify(String host, X509Certificate cert)
								throws SSLException {
						}

						public void verify(String host, String[] cns,
								String[] subjectAlts) throws SSLException {
						}

					});

			return HttpClients.custom().setSSLSocketFactory(sslsf).build();

		} catch (GeneralSecurityException e) {
			throw e;
		}
	}

}
