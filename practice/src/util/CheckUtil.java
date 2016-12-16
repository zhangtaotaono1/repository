package util;
 

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/** 
 * @author fengmaogen 
 * @version 创建时间：2016-2-18 上午11:08:40 
 * appservice的工具类
 */
public class CheckUtil {
	
	public static String cardBinUrl = SystemConfig.getProperty("cardBin");


	private static Logger logger = LoggerFactory
			.getLogger(CheckUtil.class);
	/**
	 * request参数验证
	 * @param parameters
	 * @return
	 */
	public static boolean validateRequest(Map<String, String> request){
		if(request != null && !request.isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * 单个参数验证
	 * @param parameters
	 * @return
	 */
	public static boolean validateParameters(String parameters){
		if(parameters != null && !"".equals(parameters)){
			return true;
		}
		return false;
	}
	
	/**
	 * 必输参数验证
	 * @param parameters
	 * @return
	 */
	public static String validateMustEnter(Map<String, String> request, String...strings){
		if(validateRequest(request)){
			for (String str : strings) {
				if(!validateParameters(request.get(str))){
					logger.debug("必输参数验证=========================>" + str);
					return str;
				}
			}
		}else{
			return "request";
		}
		return "0000";
	}
	
	/**
	 * 校验银行卡卡号
	 * 
	 * @param cardId
	 * @return
	 */
	public static boolean checkBankCard(String cardId) {
		char bit = getBankCardCheckCode(cardId
				.substring(0, cardId.length() - 1));
		if (bit == 'N') {
			return false;
		}
		Double cardNo = Double.valueOf(cardId);
		if(cardNo <= 0){
			return false;
		}
		return cardId.charAt(cardId.length() - 1) == bit;
	}

/**
	 * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
	 * 
	 * @param nonCheckCodeCardId
	 * @return
	 */
	public static char getBankCardCheckCode(String nonCheckCodeCardId) {
		if (nonCheckCodeCardId == null
				|| nonCheckCodeCardId.trim().length() == 0
				|| !nonCheckCodeCardId.matches("\\d+")) {
			// 如果传的不是数据返回N
			return 'N';
		}
		char[] chs = nonCheckCodeCardId.trim().toCharArray();
		int luhmSum = 0;
		for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
			int k = chs[i] - '0';
			if (j % 2 == 0) {
				k *= 2;
				k = k / 10 + k % 10;
			}
			luhmSum += k;
		}
		return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
	}
	
	/**
	 * 查询银行卡信息
	 * 
	 * @param getCardBin
	 * @return
	 */
	public static String getCardBin(String cardNo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("kahao", cardNo);
		
		String bankName = "";  //发卡行名称
		String ret = null;
		try {
			ret = HttpClientUtils.postForm(cardBinUrl, map, null, HttpClientUtils.connTimeout, HttpClientUtils.readTimeout);
			CardBinResponse msgResponse = (CardBinResponse) JSONUtil.parseJson(ret, CardBinResponse.class);
			List<Map<String, Object>> backList = msgResponse.getData();
			JSONArray backArray = JSONArray.fromObject(backList);
			for (Object backtObj : backArray) {
				JSONObject acctObject = JSONObject.fromObject(backtObj);
				String[] type = acctObject.getString("backname").split("\n");
				bankName = type[0];
				logger.info("根据银行卡号查询出银行信息===================>" + ret);
				logger.info("根据银行卡号查询出银行名称信息===================>" + bankName);
			}
		} catch (ConnectTimeoutException e) {
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bankName;
	}
	
	/**
	 * 查询银行卡信息
	 * @param cardNo
	 * @param queryResults
	 * @return
	 */
	public static String getCardBinByResults(String cardNo, String queryResults) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("kahao", cardNo);
		
		String results = "";  //发卡行名称
		String ret = null;
		try {
			ret = HttpClientUtils.postForm(cardBinUrl, map, null, HttpClientUtils.connTimeout, HttpClientUtils.readTimeout);
			CardBinResponse msgResponse = (CardBinResponse) JSONUtil.parseJson(ret, CardBinResponse.class);
			List<Map<String, Object>> backList = msgResponse.getData();
			JSONArray backArray = JSONArray.fromObject(backList);
			for (Object backtObj : backArray) {
				JSONObject acctObject = JSONObject.fromObject(backtObj);
				String[] type = acctObject.getString(queryResults).split("\n");
				results = type[0];
				logger.info("根据银行卡号查询出银行信息===================>" + ret);
				logger.info("根据银行卡号查询出银行结果信息===================>" + results);
			}
		} catch (ConnectTimeoutException e) {
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	/**
	 * 必输参数验证
	 * @param parameters
	 * @return
	 */
	public static String validateParmByString(String...strings){
		for (String str : strings) {
			if(!validateParameters(str)){
				logger.debug("必输参数验证=========================>" + str);
				return str;
			}
		}
		return "0000";
	}
}
 