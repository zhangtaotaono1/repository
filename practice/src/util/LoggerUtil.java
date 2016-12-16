package util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.MDC;

public class LoggerUtil {

	public static String genSession() {
		String startTime = "2016-01-01 00:00:00";
		Long current = System.currentTimeMillis();
		Long start = 0L;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			start = df.parse(startTime).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Long differ = current - start;
		Integer random = (int) (Math.random() * 90 + 10);
		String sessionStr = differ.toString() + random.toString();
		String session = Long.toHexString(Long.valueOf(sessionStr))
				.toUpperCase();
		return session;
	}
	
	public static void setMDC() {
		String session = genSession();
		MDC.put("session", session);
	}

	public static void setMDC(String ip) {
		String session = genSession();
		MDC.put("session", session);
		MDC.put("ip", ip);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				public void run() {
					setMDC("");
				}
			}).start();
		}
	}

}
