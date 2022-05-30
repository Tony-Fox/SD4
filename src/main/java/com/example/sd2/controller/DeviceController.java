package com.example.sd2.controller;

import com.example.sd2.dtos.DeviceDTO;
import com.example.sd2.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DeviceController {

	private java.util.logging.Logger logger;

	public DeviceController() {
		logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler(this.getClass().getName() + ".log");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		logger.addHandler(fileHandler);
	}

	@Autowired
	private DeviceService service;


	@GetMapping("/devices")
	public ResponseEntity<List<DeviceDTO>> findAll(){



		List<DeviceDTO> restaurants ;

		restaurants = service.findAll();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Responded", "DeviceController");
		return ResponseEntity.accepted().headers(httpHeaders).body(restaurants);
	}


	@PostMapping("/device/add")
	public ResponseEntity addRestaurant(@RequestBody DeviceDTO deviceDTO) {
		service.save(service.toDevice(deviceDTO));
		logger.info("Created restaurant: " + deviceDTO.getName());
		return ResponseEntity.noContent().build();
	}

//	@PostMapping("/restaurants/add")
//	public ResponseEntity addRestaurant(@RequestBody DeviceDTO restaurantDTO){
//		System.out.println(restaurantDTO.getName()+restaurantDTO.getId()+restaurantDTO.getAddress()+restaurantDTO.getDescription());
//		service.save(restaurantDTO);
//		return ResponseEntity.noContent().build();
//	}

}
