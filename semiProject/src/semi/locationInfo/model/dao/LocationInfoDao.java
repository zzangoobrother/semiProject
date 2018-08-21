package semi.locationInfo.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import semi.locationInfo.model.vo.LocationInfo;

public class LocationInfoDao {

	public String toolSelect(Connection conn, String borough) {
		return null;
	}
	
	public ArrayList<LocationInfo> boroughSelect(Connection conn, String borough) {
		ArrayList<LocationInfo> list = new ArrayList<LocationInfo>();
		
		return list;
	}
	
	public ArrayList<LocationInfo> listView(Connection conn) {
		ArrayList<LocationInfo> list = new ArrayList<LocationInfo>();
		
		return list;
	}
}
