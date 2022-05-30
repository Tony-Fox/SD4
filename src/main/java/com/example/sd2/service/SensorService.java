package com.example.sd2.service;

import com.example.sd2.dtos.SensorDTO;
import com.example.sd2.dtos.SensorReadingDTO;
import com.example.sd2.entity.Sensor;
import com.example.sd2.entity.SensorReading;
import com.example.sd2.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.FileHandler;

@Service
public class SensorService {

	private java.util.logging.Logger logger;

	public SensorService() {
		logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler(this.getClass().getName() + ".log");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		logger.addHandler(fileHandler);
	}

	public SensorService(DeviceService deviceService) {
		this.deviceService = deviceService;
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
	private SensorRepository repository;

	@Autowired
	private DeviceService deviceService;

	/**
	 * Saves a sensor in the database
	 * @param sensor The sensor to save
	 */
	public void save(Sensor sensor){
		repository.save(sensor);
		logger.info("Saved new sensor: " + sensor.getName());
	}

	/**
	 * Returns all sensors as dtos
	 * @return all sensors as dtos
	 */
	public List<SensorDTO> findAll(){
		return toDTOs(repository.findAll());
	}

	/**
	 * Finds the sensor by its ID
	 * @param id the id of the sensor to find
	 * @return the sensor if it finds it
	 */
	public Sensor findById(Long id){
		if(repository.findById(id).isPresent())
			return repository.findById(id).get();
		else {
			System.out.println("Invalid ID!");
			logger.warning("Invalid ID: " + id);
			return null;
		}
	}

	/**
	 * Converts a Sensor to a SensorDTO
	 * @param sensor the sensor to convert
	 * @return the sensorDTO
	 */
	public SensorDTO toDTO (Sensor sensor) {
		return new SensorDTO(sensor.getSensorId(), sensor.getName(), sensor.getDescription(), sensor.getDevice().getDeviceId() );
	}

	/**
	 * Converts Sensors to SensorDTOs
	 * @param sensors the sensors to convert
	 * @return the sensorDTOs
	 */
	public List<SensorDTO> toDTOs (List<Sensor> sensors) {
		List<SensorDTO> dtos = new ArrayList<>();
		for (Sensor sensor : sensors) {
			dtos.add(toDTO(sensor));
		}
		return dtos;
	}

	/**
	 * Converts a sensorDTO to a sensor
	 * @param sensorDTO the sensorDTO to convert
	 * @return the converted sensor
	 */
	public Sensor toSensor(SensorDTO sensorDTO) {
		return new Sensor(
				sensorDTO.getName(),
				sensorDTO.getDescription(),
				deviceService.findById(sensorDTO.getDeviceId())
				
		);
	}

	public Sensor findBySensorName(String name){
		List<Sensor> sensors = repository.findAll();
		for(Sensor sensor : sensors) {
			if (Objects.equals(sensor.getName(), name)) {
				return sensor;
			}

		}
		return null;
	}


}
