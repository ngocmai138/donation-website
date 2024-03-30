package donation.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StatusDonation {
	private static final Map<Integer, String> statusMap = new HashMap<>();
	static {
		statusMap.put(0, "Mới tạo");
		statusMap.put(1, "Đang quyên góp");
		statusMap.put(2, "Kết thúc đợt quyên góp");
		statusMap.put(3, "Đóng quyên góp");
	}
	public static String getStatusString(int status) {
		return statusMap.get(status);
	}
	public static List<Integer> getStatusValues(String keyword){
		List<Integer> statusValues = new ArrayList<>();
		for(Entry<Integer, String> entry : statusMap.entrySet()) {
			
			if(entry.getValue().toUpperCase().contains(keyword.toUpperCase())) {
				statusValues.add(entry.getKey());
			}
		}
		return statusValues;
	}
	public static String getButtonLabel(int status) {
		if(status == 0) return "Quyên góp";
		else if(status == 1) return "Kết thúc";
		else if(status ==2) return "Đóng";
		else return null;
	}
}
