package util;

import java.util.Date;

import net.sf.json.JSONObject;

public class test {
	
	public static void main(String[] args) throws Exception {
		System.out.println(new Date().getTime());
		String abc = "{\"quotations\": [{\"comment\": null, \"account_id\": \"gwe61a55g1d7n1qx\","
				+ "\"is_done\": false, \"quotation_id\": \"x684qocjj8ro81q2\", \"vehicle\": null, "
				+ "\"is_success\": false, \"ic_code\": \"pingan\", \"message\": null}],"
				+ "\"is_done\": false, \"request\": {\"extend\": {\"vehicle_class\": \"A01\","
				+ " \"load_quality\": 0, \"selected_model\": {\"vehicle_data_id\": \"XDABJD0013\","
				+ " \"auto_model_code\": \"MTD1013BJX\"}, \"fuel_type\": \"0\"}, \"selection\": {},"
				+ " \"counter_id\": 0, \"prov_code\": \"110100\", \"channel_seq_no\":"
				+ " \"09ce1831a68d43569d78b00998851c5ffcf51af1\", \"vehicle_nature\": \"211\","
				+ " \"vehicle\": {\"vehicle_class\": \"A01\", \"model_code\": \"\", "
						+ "\"tax_price\": \"149600.00\", \"vehicle_name\": \"北京现代\","
						+ " \"seat_count\": 5, \"fuel_type\": \"0\", \"license_no\": \"京A12345\","
						+ " \"enroll_date\": \"2016-12-12\", \"engine_no\": \"GW128353\","
						+ " \"frame_no\": \"LBECHAHC5GZ431498\", \"license_type\": \"02\","
						+ " \"load_quality\": 0, \"create_time\": \"2017-05-13 14:32:35\","
						+ " \"as_cache_hit_sha1\": \"a74d0175049cb888ba8631abcd0e32d59fc9b0e0\","
						+ " \"vehicle_data_id\": \"XDABJD0013\", \"owner\": \"孙永胜\","
						+ " \"purchase_price\": \"137800.00\", \"auto_model_code\": \"MTD1013BJX\"},"
						+ " \"biz_start_date\": null, \"create_time\": \"2017-05-13 14:32:35\","
						+ " \"channel\": \"A\", \"request_id\": \"195kd4i55oreoln0\","
						+ " \"force_start_date\": null, \"city_code\": \"110100\","
						+ " \"applicant_type\": \"02\"}}";
		JSONObject object = JSONUtil.parseJson2(abc);
		String aaa = object.getString("quotations");
		System.out.println(aaa);
	}
}
