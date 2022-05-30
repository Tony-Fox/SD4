package com.example.sd2.service;

import com.example.sd2.dtos.SensorReadingDTO;
import com.example.sd2.entity.Sensor;
import com.example.sd2.entity.SensorReading;
import com.example.sd2.repository.SensorReadingRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Service
public class SensorReadingService {

	private java.util.logging.Logger logger;

	private SensorReadingRepository repository;

	public SensorReadingService(SensorReadingRepository repository) {
		this.repository = repository;
		logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler(this.getClass().getName() + ".log");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		logger.addHandler(fileHandler);
	}

	/**
	 * Saves a sensorReading in the database
	 * @param sensorReading The sensorReading to save
	 */
	public void save(SensorReading sensorReading){
		repository.save(sensorReading);
		logger.info("Saved new sensor: " + sensorReading.getSensor().getName());
	}


	/**
	 * Finds the sensorReading by its ID
	 * @param id the id of the sensorReading to find
	 * @return the sensorReading if it finds it
	 */
	public SensorReading findBySensorReadingId(Long id){
		if(repository.findById(id).isPresent())
			return repository.findById(id).get();
		else {
			System.out.println("Invalid ID!");
			logger.warning("Invalid ID: " + id);
			return null;
		}
	}


	/**
	 * Converts a SensorReading to a SensorReadingDTO
	 * @param sensorReading the sensorReading to convert
	 * @return the sensorReadingDTO
	 */
	public SensorReadingDTO toDto(SensorReading sensorReading) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return new SensorReadingDTO(
				sensorReading.getSensorReadingId(),
				format.format(sensorReading.getTime()),
				sensorReading.getSensor().getSensorId(),
				sensorReading.getReading());
	}

	/**
	 * Finds the sensorReading by the sensor ID
	 * @param id the id of the sensor to find its sensorReadings
	 * @return the sensorReadings if it finds them
	 */
	public List<SensorReadingDTO> findBySensorId(Long id){
		List<SensorReading> sensorReadings = repository.findAll();
		List<SensorReadingDTO> sensorReadingDTOS = new ArrayList<>();
		for(SensorReading sensorReading : sensorReadings) {
			if (Objects.equals(sensorReading.getSensor().getSensorId(), id)) {
				sensorReadingDTOS.add(toDto(sensorReading));
			}

		}
		return sensorReadingDTOS;
	}


}
