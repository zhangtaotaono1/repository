package util;


import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {

	// 加密
	public static String getEncodeBase64(String str, String charset) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	// 解密
	public static String getDecodeBase64(String str, String charset) {
		byte[] b = null;
		String result = null;
		if (str != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(str);
				result = new String(b, charset);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
