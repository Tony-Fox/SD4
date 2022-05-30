package com.example.sd2.dtos;


public class DeviceDTO {


	private Long deviceId;

	private String name;

	private String location;

	public Long getDeviceId() {
		return deviceId;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public DeviceDTO(Long deviceId, String name, String location) {
		this.deviceId = deviceId;
		this.name = name;
		this.location = location;
	}

	public DeviceDTO() {
	}

}
