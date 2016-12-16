package util;
/**   
 * @Title: AmountUtil.java 
 * @Package com.lc.acct.util
 * @Description: Amount处理工具类
 * @author kouken   
 * @date 2015-12-24
 * @version V1.0   
 */


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @ClassName: AmountUtil
 * @Description: Amount处理工具类
 * 
 */
public class AmountUtil {

	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 10;

	// 保留小数位数
	private static final int SCALE_LENGTH = 2;

	// 费率换算单位
	private static final String RATE_TYPE = "10000";

	/**
	 * 对double数据进行取精度
	 * 
	 * @param value
	 *            double数据
	 * @param scale
	 *            精度位数(保留的小数位数)
	 * @param roundingMode
	 *            精度取值方式
	 * @return 精度计算后的数据.
	 */
	public static double round(double value, int scale, int roundingMode) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(scale, roundingMode);
		double d = bd.doubleValue();
		bd = null;
		return d;
	}

	/**
	 * 提供加法运算。(四舍五入)
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		BigDecimal C1 = b1.add(b2);
		return C1.setScale(SCALE_LENGTH, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * 提供减法运算。(四舍五入)
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		BigDecimal C1 = b1.subtract(b2);
		return C1.setScale(SCALE_LENGTH, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * 提供减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double subNoHalfUp(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		BigDecimal C1 = b1.subtract(b2);
		return C1.doubleValue();
	}

	/**
	 * 提供手续费取得运算。(四舍五入) 小数点后保留位数：2位 精度取值方式：ROUND_HALF_UP 四舍五入
	 * 
	 * @param v1
	 *            金额
	 * @param v2
	 *            费率
	 * @return 手续费
	 */
	public static double getRate(double v1, double v2) {
		// 如果费率为0时，直接返回金额
		if (v2 == 0) {
			return 0.00d;
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		BigDecimal mulResult = b1.multiply(b2);
		BigDecimal DivideResult = mulResult.divide(new BigDecimal(RATE_TYPE),
				SCALE_LENGTH, BigDecimal.ROUND_HALF_UP);
		return DivideResult.doubleValue();
	}

	// /**
	// * 两个值比较取最小的。
	// *
	// * @param v1 金额1
	// * @param v2 金额2
	// * @return 最小的金额
	// */
	// public static double getSmailRate(double v1, double v2) {
	// // 如果封顶金额为0时，直接返回费率
	// if (v2==0 && v1!= 0){
	// return v1;
	// }else if(v1==0 && v2!= 0){
	// return v2;
	// }
	//    	
	// BigDecimal b1 = new BigDecimal(Double.toString(v1));
	// BigDecimal b2 = new BigDecimal(Double.toString(v2));
	// if (b1.compareTo(b2) > 0) {
	// return v2;
	// }else {
	// return v1;
	// }
	// }

	/**
	 * 商户手续费取得。
	 * 
	 * @param v1
	 *            手续费
	 * @param v2
	 *            附加费
	 * @return 手续费 + 附加费
	 */
	public static double getSmailRate(double v1, double v2) {
		return AmountUtil.add(v1, v2);
	}

	/**
	 * 提供乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		BigDecimal c1 = b1.divide(b2);
		return c1.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 金额编辑处理。 若金额中包含小数点，需要处掉。 金额长度不足12位，左边补0到12位
	 * 
	 * @param data
	 *            金额
	 * @return 编辑后的金额
	 */
	public static String moneyYu(String data) {
		String payAmount = new BigDecimal(data).multiply(new BigDecimal(100))
				.setScale(0, BigDecimal.ROUND_DOWN).toString();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 12 - payAmount.length(); i++) {
			sb.append("0");
		}

		return sb.toString() + payAmount;
	}

	/**
	 * 金额编辑处理。 若金额中包含小数点，需要处掉。 金额长度不足12位，左边补0到12位
	 * 
	 * @param data
	 *            金额
	 * @return 编辑后的金额
	 */
	public static Double parseAmt(String amtStr) {
		Double amt = 0.00d;
		try {
			// 去掉字符串前面的0
			int zeroIndex = 0;
			int strLength = amtStr.length();
			for (int i = 0; i < amtStr.length(); i++) {
				char charAmt = amtStr.charAt(i);
				if (charAmt != '0') {
					zeroIndex = i;
					break;
				}
			}
			// 去掉前面的空格
			amtStr = amtStr.substring(zeroIndex, strLength);
			amtStr = amtStr.substring(0, amtStr.length() - 2) + "."
					+ amtStr.substring(amtStr.length() - 2);
			amt = Double.valueOf(amtStr);
		} catch (Exception ex) {
			amt = 0.00d;
		}
		return amt;
	}

	/**
	 * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额
	 * 
	 * @param amount
	 * @return
	 */
	public static String changeY2F(String amount) {
		String currency = amount.replaceAll("\\$|\\￥|\\,", ""); // 处理包含, ￥
																// 或者$的金额
		int index = currency.indexOf(".");
		int length = currency.length();
		Long amLong = 0l;
		if (index == -1) {
			amLong = Long.valueOf(currency + "00");
		} else if (length - index >= 3) {
			amLong = Long.valueOf((currency.substring(0, index + 3)).replace(
					".", ""));
		} else if (length - index == 2) {
			amLong = Long.valueOf((currency.substring(0, index + 2)).replace(
					".", "") + 0);
		} else {
			amLong = Long.valueOf((currency.substring(0, index + 1)).replace(
					".", "")
					+ "00");
		}
		return amLong.toString();
	}

	/**
	 * 以分为单位的整数转换为以元为单位的小数（n,nnn.nn）元
	 * 
	 * @param price
	 * @return
	 */
	public static String num2Currency(Object currency) {
		String result = NumberFormat.getCurrencyInstance(Locale.CHINA).format(
				currency);
		return result;
	}

	/**
	 * 以分为单位的整数转换为以元为单位的小数（ nnn.nn）元
	 * 
	 * @param n
	 * @return
	 */
	public static String long2money(long n) {
		String result = n / 100 + "." + n % 100;
		return result;
	}
}