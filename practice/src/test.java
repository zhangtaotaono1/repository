
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.conn.ConnectTimeoutException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import util.HttpClientUtils;

public class test {

	public static void main(String[] args) {
		// String url = Global.getConfig("smsUrl");
		// 请求参数
		Map<String, String> params = new HashMap<String, String>();
		params.put("organ_code", "");
		params.put("organ_name", "代理");
		params.put("valCode", "");

		String smsJson = "";
		try {
			smsJson = HttpClientUtils.post(
					"http://iir.circ.gov.cn/web/searchOrganInfoAction.html",
					"organ_name=%B4%FA%C0%ED&organ_code=&valCode=",
					"application/x-www-form-urlencoded", "GBK", 30000, 30000);
			
			Document document = Jsoup.parse(smsJson);
			Elements elements = document.select("td[align=\"center\"]");
		} catch (ConnectTimeoutException e) {
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(smsJson);
		
	}
//  organ_name=%B4%FA%C0%ED&organ_code=&valCode=
//	organ_name=%B4%FA%C0%ED&organ_code=&currentPage=1&totalCount=10269&isTable=true
//	organ_name=%B4%FA%C0%ED&organ_code=&currentPage=2&totalCount=10258&isTable=true
//  organ_name=%B4%FA%C0%ED&organ_code=&currentPage=3&totalCount=10269&isTable=true
}
