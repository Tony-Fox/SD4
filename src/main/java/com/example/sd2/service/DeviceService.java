package com.example.sd2.service;

import com.example.sd2.dtos.DeviceDTO;
import com.example.sd2.dtos.SensorDTO;
import com.example.sd2.entity.Device;
import com.example.sd2.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

@Service
public class DeviceService {


	private java.util.logging.Logger logger;


	public DeviceService() {
		logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler(this.getClass().getName() + ".log");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		logger.addHandler(fileHandler);
	}

	public DeviceService(DeviceRepository repository) {
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

	@Autowired
	private DeviceRepository repository;

	/**
	 * Saves a device in the database
	 * @param device the device to save
	 */
	public void save(Device device){
		repository.save(device);
		logger.info("Saved new device: " + device.getName());
	}

	/**
	 * Finds the device by its id
	 * @param id the id of the device to find
	 * @return the device if it finds it
	 */
	public Device findById(Long id){
		if(repository.findById(id).isPresent())
			return repository.findById(id).get();
		else {
			System.out.println("Invalid ID!");
			logger.warning("Invalid ID: " + id);
			return null;
		}
	}

	/**
	 * Returns all sensors installed in a given device
	 * @param id the id of the device
	 * @return the sensors of the device
	 */
	public List<SensorDTO> getSensors(Long id) {
		SensorService sensorService = new SensorService();
		Device device = findById(id);
		return sensorService.toDTOs(device.getProducts());
	}

	/**
	 * Converts a Device to a DeviceDTO
	 * @param device the Device to convert
	 * @return the converted DeviceDTO
	 */
	public DeviceDTO toDTO (Device device) {
		return new DeviceDTO(device.getDeviceId(), device.getName(), device.getLocation());
	}

	/**
	 * Converts Devices to DeviceDTOs
	 * @param devices the Devices to convert
	 * @return the converted DeviceDTOs
	 */
	public List<DeviceDTO> toDTOs (List<Device> devices) {
		List<DeviceDTO> dtos = new ArrayList<>();
		for (Device device : devices) {
			dtos.add(toDTO(device));
		}
		return dtos;
	}

	/**
	 * Finds all devices in the database
	 * @return the list of all devices
	 */
	public List<DeviceDTO> findAll(){
		return toDTOs(repository.findAll());
	}

	/**
	 * Converts a DeviceDTO to a Device
	 * @param deviceDTO the DeviceDTO to convert
	 * @return the converted Device
	 */
	public Device toDevice(DeviceDTO deviceDTO) {
		return new Device(
				deviceDTO.getName(),
				deviceDTO.getLocation()
		);
	}

}
