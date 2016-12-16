package util;


import java.util.HashMap;
import java.util.Map;

public class BusUtil {
	
	//直辖市编码
	private static Map<String, String> municipalityMap;
	
	static {
		municipalityMap = new HashMap<String, String>();
		//北京市
		municipalityMap.put("110000", "北京市");
		municipalityMap.put("120000", "天津市");
		municipalityMap.put("310000", "上海市");
		municipalityMap.put("500000", "重庆市");
	}

	/**
	 * 判断是否为直辖市
	 * @param provinceId 省id
	 * @return
	 */
	public static boolean isMunicipality(String provinceId) {
		if(municipalityMap.containsKey(provinceId)) {
			return true;
		}
		return false;
	}
	
}
