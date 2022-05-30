package com.example.sd2.dtos;


public class SensorDTO {

	private Long sensorId;

	private String name;

	private String description;

	private Long deviceId;

	public SensorDTO(Long sensorId, String name, String description, Long deviceId) {
		this.sensorId = sensorId;
		this.name = name;
		this.description = description;
		this.deviceId = deviceId;
	}

	public SensorDTO() {
	}

	public Long getSensorId() {
		return sensorId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Long getDeviceId() { return deviceId; }

	@Override
	public String toString() {
		return name;
	}

}
