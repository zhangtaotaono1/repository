package util;
/**   
 * @Title: StringUtils.java 
 * @Package com.lc.acct.util 
 * @Description: 文字列共通处理类
 * @author kouken   
 * @date 2015-12-24
 * @version V1.0   
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName: DateUtils
 * @Description: 日期共通处理类
 * 
 */
public class StringUtils {

	/**
	 * 文字列入力判断 判断文字列是否为NULL或空
	 * 
	 * @param value
	 *            文字列
	 * @return boolean NULL或空返回true，否则返回false
	 */
	public static boolean isEmpty(String value) {
		if (null == value || value.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Double入力判断 判断文字列是否为NULL或空
	 * 
	 * @param value
	 *            文字列
	 * @return boolean NULL或空返回true，否则返回false
	 */
	public static boolean isEmpty(Double value) {
		if (null == value || value == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 文字列转换 文字列转换成Long型
	 * 
	 * @param value
	 *            文字列
	 * @return Long NULL或空返回NULL，否则返回转换后的值
	 */
	public static long stringToLong(String value) {
		if (null == value || value.isEmpty()) {
			return 0l;
		} else {
			return new Long(value).longValue();
		}
	}

	/**
	 * 文字列转换 文字列转换成Double型
	 * 
	 * @param value
	 *            文字列
	 * @return Double NULL或空返回NULL，否则返回转换后的值
	 */
	public static double stringToDouble(String value) {
		if (null == value || value.isEmpty()) {
			return 0.00d;
		} else {
			return new Double(value).doubleValue();
		}
	}

	/**
	 * 文字列转换 文字列转换成日期型（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param value
	 *            文字列
	 * @return Date NULL或空返回NULL，否则返回转换后的值
	 */
	public static Date stringToDateTime(String value) {
		if (null == value || value.isEmpty()) {
			return null;
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			try {
				return dateFormat.parse(value);
			} catch (ParseException e) {
				return null;
			}
		}
	}

	/**
	 * 文字列转换 文字列转换成日期型（yyyy-MM-dd）
	 * 
	 * @param value
	 *            文字列
	 * @return Date NULL或空返回NULL，否则返回转换后的值
	 */
	public static Date stringToDate(String value) {
		if (null == value || value.isEmpty()) {
			return null;
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return dateFormat.parse(value);
			} catch (ParseException e) {
				return null;
			}
		}
	}

	/**
	 * 请求内容转换
	 * 
	 * @param key
	 *            商户编号
	 * @param request
	 *            记账请求Request
	 * @return returnCode String
	 */
	public static String getRequestMapValue(String key,
			Map<String, String> request) {
		if (null == request) {
			return "";
		} else {
			if (request.containsKey(key)) {
				Object obj = request.get(key);
				if (null == obj || "null".equals(obj.toString())) {
					return "";
				} else {
					return obj.toString();
				}
			} else {
				return "";
			}
		}
	}
}