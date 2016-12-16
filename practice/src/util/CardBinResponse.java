package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**   
	* @Title: CardBinResponse.java 
	* @Package com.lc.ebuy.response 
	* @Description: 查询卡bin返回信息
	* @author Feng Maogen  
	* @date 2016年10月24日 上午11:51:09 
	* @version V1.0   
	*/
public class CardBinResponse {

	
	/**
	 * 响应码
	 */
	private String code;
	
	/**
	 * 响应信息
	 */
	private Map<String, Object> response = new HashMap<String, Object>();
	
	
	/**
	 * 响应信息
	 */
	private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
	
	
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, Object> getResponse() {
		for(Entry<String, Object> entry : response.entrySet()) {
			Object value = entry.getValue();
			if(value == null) {
				response.put(entry.getKey(), "");
			}
		}
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

	

}
