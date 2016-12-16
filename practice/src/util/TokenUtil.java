package util;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

/**
 * Token工具类
 */
public class TokenUtil {
	
	private static String KEY_NAME = "login.key";
	
	private static String BROKER_ID_KEY = "brokerId";
	private static String LOGIN_NAME_KEY = "loginName";
	private static String AREA_ID_KEY = "areaId";
	
	private static String AUTH_TOKEN_KEY = "auth_token";
	private static String CHARSET = "utf-8";
	
	/**
	 * 生成token(经纪人编号+手机号+区域ID+日期+key)
	 */
	public static String createToken(String brokerId, String loginName, String areaId) throws Exception {
		Map<String, String> claimsMap = new HashMap<String, String>();
		claimsMap.put(BROKER_ID_KEY, brokerId);
		claimsMap.put(LOGIN_NAME_KEY, loginName);
		claimsMap.put(AREA_ID_KEY, areaId);
		String jsonClaims = JSONUtil.packJson(claimsMap);
		//base64加密
		String encodeBase64Claims = Base64.encodeBase64String(jsonClaims.getBytes(CHARSET));
		//生成工作密钥
		String workKey = getWorkKey(brokerId, loginName, areaId);
		//token格式为base64.workKey
		String token = encodeBase64Claims + "." + workKey;
		return token;
	}
	
	/**
	 * 验证token是否正确
	 */
	public static boolean verifyToken(String token) throws Exception {
		//解析token
		String [] tokenArray = parseToken(token);
		String base64Claims = tokenArray[0].trim();
		//工作密钥
		String inWorkKey = tokenArray[1].trim();
		
		//解析参数
		Map<String, String> claimsMap = getClaimsMap(base64Claims);
		if(!claimsMap.containsKey(BROKER_ID_KEY)
				|| !claimsMap.containsKey(LOGIN_NAME_KEY)
				|| !claimsMap.containsKey(AREA_ID_KEY)) {
			throw new Exception("载荷中不存在键" + BROKER_ID_KEY + "或" + LOGIN_NAME_KEY + "或" + AREA_ID_KEY);
		}
		//经纪人id
		String brokerId = claimsMap.get(BROKER_ID_KEY);
		//手机号
		String loginName = claimsMap.get(LOGIN_NAME_KEY);
		//地区ID
		String areaId = claimsMap.get(AREA_ID_KEY);
		if(brokerId.trim().isEmpty() || loginName.trim().isEmpty() || areaId.trim().isEmpty()) {
			throw new Exception("载荷中键" + BROKER_ID_KEY + "或" 
					+ LOGIN_NAME_KEY + "的值为空" + "或" + AREA_ID_KEY + "的值为空");
		}
		String workKey = getWorkKey(brokerId, loginName, areaId);
		if(inWorkKey.equalsIgnoreCase(workKey)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 生成工作密钥
	 */
	private static String getWorkKey(String brokerId, String loginName, String areaId) throws Exception {
		//密钥
		String key = SystemConfig.getProperty(KEY_NAME);
		Date now = new Date();
		String nowStr = ConvertTimeUtil.formatYYYYMMDD(now);
		//工作密钥明文
		String workKeyPlain = brokerId + loginName + areaId + nowStr + key;
		//加密
		String workKey = MD5Util.getMD5Code(workKeyPlain, CHARSET);
		return workKey;
	}
	
	/**
	 * 解析token，将token用.分割开
	 */
	private static String[] parseToken(String token) throws Exception {
		if(!token.isEmpty() && !token.contains(".")) {
			throw new Exception("token格式错误!");
		}
		//用.切割token
		String [] tokenArray = token.split("\\.");
		return tokenArray;
	}
	
	/**
	 * 将token的第一部分解析成map
	 */
	private static Map<String, String> getClaimsMap(String base64Claims) throws Exception {
		//base64解密
		String decodeBase64Claims = new String(Base64.decodeBase64(base64Claims), CHARSET);
		//json解析
		Map<String, String> claimsMap = JSONUtil.jsonToMap(decodeBase64Claims);
		return claimsMap;
	}
	
	/**
	 * 获取claims中的值
	 */
	private static String getClaimsValue(String token, String key) throws Exception {
		//解析token
		System.out.println("token==============>" + token);
		String [] tokenArray = parseToken(token);
		System.out.println("tokenArray==============>" + tokenArray.length);
		String base64Claims = tokenArray[0].trim();
		//得到参数
		Map<String, String> claimsMap = getClaimsMap(base64Claims);
		String value = claimsMap.get(key);
		return value;
	}
	
	/**
	 * 获取HttpServletRequest头中的auth_token
	 */
	private static String getHeaderValue(HttpServletRequest request, String headerName) throws Exception {
		String headerValue = request.getHeader(headerName);
		return headerValue;
	}
	
	/**
	 * 获取经纪人编号
	 */
	public static String getMercId(HttpServletRequest request) throws Exception {
		String token = getHeaderValue(request, AUTH_TOKEN_KEY);
		String value = getClaimsValue(token, BROKER_ID_KEY);
		return value;
	}
	
	/**
	 * 获取登录手机号
	 */
	public static String getLoginName(HttpServletRequest request) throws Exception {
		String token = getHeaderValue(request, AUTH_TOKEN_KEY);
		String value = getClaimsValue(token, LOGIN_NAME_KEY);
		return value;
	}
	
	/**
	 * 获取地区ID
	 */
	public static String getAreaId(HttpServletRequest request) throws Exception {
		String token = getHeaderValue(request, AUTH_TOKEN_KEY);
		System.out.println("token==============>" + token);
		String value = getClaimsValue(token, AREA_ID_KEY);
		return value;
	}
	
}
