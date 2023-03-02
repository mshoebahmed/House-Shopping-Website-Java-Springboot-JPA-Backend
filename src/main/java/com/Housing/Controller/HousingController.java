package com.Housing.Controller;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Housing.Model.HouseData;
import com.Housing.Service.HousingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api")
public class HousingController {
	

	@Autowired
	HousingService service;

	@PostMapping(path = "/addHouse")
	public Map<String, String> addHouse(@RequestBody HouseData param) {
		if (param.getId() == 0) {
			param.setId(System.currentTimeMillis());
		}
		return service.addHouseData(param);
	}

	@GetMapping(path = "/deleteHouse")
	public Map<String, Object> deleteHouse(@RequestParam long id) {
		return service.deleteHouseData(id);
	}

	@GetMapping(path = "/searchHouse")
	public Map<String, Object> searchHouse() {
		return service.getHouseData();
	}
	
	@GetMapping(path = "/searchHouseById")
	public Map<String, Object> searchHouseById(@RequestBody Map<String,Long >params) {
		long id = params.get("id");
		return service.getHouseDataById(id);
	}
	
	@GetMapping(path = "/searchHouseByCity")
	public Map<String, Object> searchHouseByCity(@RequestParam String city) {
		return service.getHouseDataByCity(city);
	}

}
