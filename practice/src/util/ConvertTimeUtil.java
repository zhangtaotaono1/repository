package util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间转换
 * @author Feng Maogen
 *
 */
public class ConvertTimeUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ConvertTimeUtil.class);
	
	/**
	 * 将字符串日期格式化成时间
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parseYYYYMMDDDate(String dateStr) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			logger.error("格式化日期时发生错误：" , e);
			return null;
		}
	}
	/**
	 * 将时间转换成字符串yyyy-MM-dd HH:mm:ss
	 */
	public static Date convertTime() {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			logger.error("格式化日期时发生错误：" , e);
			return null;
		}
	}
	
	/**
	 * 取得当前日期（日期类型）
	 * yyyy-MM-dd
	 * 
	 * @param formatType 日期格式
	 * @throws ParseException 
	 */	
	public static Date getCurrentDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(df.format(new Date()));
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 将时间格式化成yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 * @
	 */
	public static String formatTime(Date date) {
		if(date == null){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成yyyy-MM-dd HH:mm
	 * @param date
	 * @return
	 * @
	 */
	public static String formatYMDHMTime(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成yyyy年MM月dd HH时mm分
	 * @param date
	 * @return
	 * @
	 */
	public static String formatymdHmTime(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd HH时mm分");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成yyyy-MM-dd
	 * @param date
	 * @return
	 * @
	 */
	public static String formatYMDTime(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成yyyyMMdd
	 * @param date
	 * @return
	 * @
	 */
	public static String formatYyMDTime(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成HHmmss
	 * @param date
	 * @return
	 * @
	 */
	public static String formatHMSTime(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("HHmmss");
		
		return sdf.format(date);
	}

	/**
	 * 将时间格式化成MMdd
	 * @param date
	 * @return
	 * @
	 */
	public static String formatMDTime(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("MMdd");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成MM
	 * @param date
	 * @return
	 * @
	 */
	public static String formatMMTime(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("MM");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成YYYYMM
	 * @param date
	 * @return
	 * @
	 */
	public static String formatYYYYMM(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成YYYY
	 * @param date
	 * @return
	 * @
	 */
	public static String formatYYYY(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成YYYYMMdd
	 * @param date
	 * @return
	 * @
	 */
	public static String formatYYYYMMDD(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成YYYYMMdd
	 * @param date
	 * @return
	 * @
	 */
	public static String formatYYYYMMDDHHMM(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
		
		return sdf.format(date);
	}
	
	/**
	 * 将时间格式化成YYYYMMdd
	 * @param date
	 * @return
	 * @
	 */
	public static String formatYYYYMMDDHHMMSS(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		return sdf.format(date);
	}
	/**
	 * 将yyyy-MM-dd HH:mm:ss转换成时间
	 * @param date
	 * @return
	 * @
	 */
	public static Date formatDate(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date == null || date.equals("")) {
			return null;
		}
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			logger.error("格式化日期时发生错误：" , e);
			return null;
		}
	}
	
	/**
	 * 将yyyyMMdd转换成时间
	 * @param date
	 * @return
	 * @
	 */
	public static Date formatDateByYYYYMMDD(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		if(date == null || date.equals("")) {
			return null;
		}
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			logger.error("格式化日期时发生错误：" , e);
			return null;
		}
	}
	
	/**
	 * 将时间格式化成HHmm
	 * @param date
	 * @return
	 * @
	 */
	public static String formatHMTime(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("HHmm");
		
		return sdf.format(date);
	}
}
