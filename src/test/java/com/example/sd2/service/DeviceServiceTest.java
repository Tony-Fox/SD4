package com.example.sd2.service;

import com.example.sd2.dtos.DeviceDTO;
import com.example.sd2.entity.Device;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeviceServiceTest {


	@Test
	void toDTO() {
		DeviceService deviceService = new DeviceService();
		Device testDevice = new Device(
				"KFC",
				"Cluj"
		);
		assertEquals("KFC", deviceService.toDTO(testDevice).getName());
	}

	@Test
	void toDTOs() {
		List<Device> devices = new ArrayList<>();
		DeviceService deviceService = new DeviceService();
		Device testDevice = new Device(
				"KFC",
				"Cluj"
		);
		assertEquals("KFC", deviceService.toDTO(testDevice).getName());

		devices.add(testDevice);
		devices.add(testDevice);

		assertEquals(deviceService.toDTO(testDevice).getName(), deviceService.toDTOs(devices).get(0).getName());
		assertEquals(deviceService.toDTOs(devices).size(), 2);

	}

	@Test
	void toRestaurant() {
		DeviceService deviceService = new DeviceService();
		DeviceDTO testDeviceDTO = new DeviceDTO(
				1L,
				"KFC",
				"Cluj"
		);
		assertEquals("KFC", deviceService.toDevice(testDeviceDTO).getName());

	}
}