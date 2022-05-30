package com.example.sd2.controller;

import com.example.sd2.dtos.SensorDTO;
import com.example.sd2.entity.Sensor;
import com.example.sd2.entity.SensorReading;
import com.example.sd2.service.DeviceService;
import com.example.sd2.service.EmailService;
import com.example.sd2.service.SensorReadingService;
import com.example.sd2.service.SensorService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.FileHandler;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SensorController {

	private java.util.logging.Logger logger;
	public SensorController(SensorService service, DeviceService deviceService, EmailService emailService, SensorReadingService sensorReadingService) {
		this.sensorReadingService = sensorReadingService;
		logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler(this.getClass().getName() + ".log");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		logger.addHandler(fileHandler);
		this.service = service;
		this.deviceService = deviceService;
		this.emailService = emailService;
	}

	private final SensorService service;

	private final DeviceService deviceService;

	private final EmailService emailService;

	private final SensorReadingService sensorReadingService;

	@PostMapping("/sensor/add")
	public ResponseEntity addProduct(@RequestBody SensorDTO sensorDTO) {
		service.save(service.toSensor(sensorDTO));
		emailService.sendMail(sensorDTO, "tonivulpe@yahoo.com");
		logger.info("Created new product: " + sensorDTO.getName());

		simulateSensorReading(sensorDTO, 10);

		return ResponseEntity.noContent().build();
	}

//	@PostMapping("/restaurants/addfood")
//	public ResponseEntity addFood(@RequestParam String id, @RequestBody FoodDTO dto){
//		System.out.println(dto.getName()+dto.getCategory()+dto.getDescription()+dto.getPrice()+dto.getId()+id);
//		service.save(service.FromDto(dto,id));
//		return ResponseEntity.noContent().build();
//	}



	public void simulateSensorReading(SensorDTO sensorDTO, int number) {

		Random rand = new Random();


		for (int i = 0; i < number; i ++) {
			Sensor s = service.findBySensorName(sensorDTO.getName());
			sensorReadingService.save(
					new SensorReading(
							rand.nextLong(50),
							new Date(1652874117000L + i* 10000000L),
							s
					));

		}
	}

	@GetMapping("/sensors")
	public ResponseEntity<List<SensorDTO>> findAll() {




		List<SensorDTO> products;


//		service.save(new Sensor("Apple", "Tasty", "Breakfast", 1L, restaurantService.findById(1L)));

		products = service.findAll();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Responded", "SensorController");
		return ResponseEntity.accepted().headers(httpHeaders).body(products);
	}


	@GetMapping("/sensor")
	public ResponseEntity<List<SensorDTO>> findById(@RequestParam String id) {

		List<SensorDTO> products;
		products = deviceService.getSensors(Long.parseLong(id));
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Responded", "SensorController");
		return ResponseEntity.accepted().headers(httpHeaders).body(products);
	}

}
