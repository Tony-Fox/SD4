package com.example.sd2.dtos;

import com.example.sd2.entity.Device;
import com.example.sd2.entity.Sensor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class SensorReadingDTO {

	private Long sensorReadingId;

	private String time;

	private Long sensorId;

	private Long reading;

	public SensorReadingDTO(Long sensorReadingId, String time, Long sensorId, Long reading) {
		this.sensorReadingId = sensorReadingId;
		this.time = time;
		this.sensorId = sensorId;
		this.reading = reading;
	}

	public Long getSensorReadingId() {
		return sensorReadingId;
	}

	public String getTime() {
		return time;
	}

	public Long getSensorId() {
		return sensorId;
	}

	public Long getReading() {
		return reading;
	}
}
