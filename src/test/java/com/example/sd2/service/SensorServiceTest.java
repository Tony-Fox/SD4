package com.example.sd2.service;

import com.example.sd2.dtos.SensorDTO;
import com.example.sd2.entity.Device;
import com.example.sd2.entity.Sensor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class SensorServiceTest {

	@BeforeEach
	void setUp() {

	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void save() {

	}

	@Test
	void findAll() {

	}

	@Test
	void findById() {

	}

	@Test
	void toDTO() {
		SensorService sensorService = new SensorService();
		Device device = Mockito.mock(Device.class);
		when(device.getDeviceId()).thenReturn(1L);
		Sensor testSensor = new Sensor(
				"burger",
				"good",
				device);
		assertEquals("burger", sensorService.toDTO(testSensor).getName());
	}

	@Test
	void toDTOs() {
		SensorService sensorService = new SensorService();
		List<Sensor> sensors = new ArrayList<>();
		Device device = Mockito.mock(Device.class);
		when(device.getDeviceId()).thenReturn(1L);
		Sensor testSensor = new Sensor(
				"burger",
				"good",
				device);
		sensors.add(testSensor);
		sensors.add(testSensor);

		assertEquals(sensorService.toDTO(testSensor).getName(), sensorService.toDTOs(sensors).get(0).getName());
		assertEquals(sensorService.toDTOs(sensors).size(), 2);
}

	@Test
	void toProduct() {
		DeviceService service = Mockito.mock(DeviceService.class);
		Device device = Mockito.mock(Device.class);
		when(service.findById(1L)).thenReturn(device);


		SensorService sensorService = new SensorService(service);


		when(device.getDeviceId()).thenReturn(1L);
		SensorDTO testSensorDTO = new SensorDTO(
				1L,
				"burger",
				"good",
				1L);
		assertEquals("burger", sensorService.toSensor(testSensorDTO).getName());

	}
}