package com.Housing.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Housing.Dao.mySqlDaoJPA;
import com.Housing.Model.HouseData;

@Configuration
public class HousingService {

	@Autowired
	mySqlDaoJPA dbService;

	public Map<String, String> addHouseData(HouseData param) {
		var resultParam = new HashMap<String, String>();
		HouseData result = dbService.save(param);
		if (result.getId() == param.getId()) {
			resultParam.put("status", "Success");
		} else {
			resultParam.put("status", "Failed");
		}
		return resultParam;

	}

	public Map<String, Object> getHouseData() {
		var resultParam = new HashMap<String, Object>();
		List<HouseData> result;

		result = dbService.findAll();

		resultParam.put("data", result);
		resultParam.put("status", "Success");
		return resultParam;

	}

	public Map<String, Object> getHouseDataById(long id) {
		List<HouseData> result;
		var resultParam = new HashMap<String, Object>();

		result = dbService.findById(id);

		resultParam.put("data", result);
		resultParam.put("status", "Found Record");
		return resultParam;

	}
	
	public Map<String, Object> getHouseDataByCity(String param) {
		List<HouseData> result;
		var resultParam = new HashMap<String, Object>();

		result = dbService.findByCityContaining(param);

		resultParam.put("data", result);
		resultParam.put("status", "Found Record");
		return resultParam;

	}

	public Map<String, Object> deleteHouseData(long id) {
		List<HouseData> result;
	var resultParam = new HashMap<String,Object>();
		
	    result = dbService.deleteById(id);
;
		resultParam.put("status", "Deleted Record");
		return resultParam;

	}

}
