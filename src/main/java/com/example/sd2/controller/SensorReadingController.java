package com.example.sd2.controller;

import com.example.sd2.dtos.SensorDTO;
import com.example.sd2.dtos.SensorReadingDTO;
import com.example.sd2.repository.SensorReadingRepository;
import com.example.sd2.service.SensorReadingService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SensorReadingController {

	private final SensorReadingService service;

	public SensorReadingController(SensorReadingService service) {
		this.service = service;
	}

	@GetMapping("/sensorreading")
	public ResponseEntity<List<SensorReadingDTO>> findById(@RequestParam String id) {

		List<SensorReadingDTO> sensorReadingDTOS;
		sensorReadingDTOS = service.findBySensorId(Long.parseLong(id));
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Responded", "SensorController");
		return ResponseEntity.accepted().headers(httpHeaders).body(sensorReadingDTOS);
	}
}
