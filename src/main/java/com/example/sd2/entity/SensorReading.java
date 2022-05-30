package com.example.sd2.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class SensorReading {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sensorReadingId;

	@Column
	private Long reading;

	@Column
	private Date time;

	@ManyToOne
	@JoinColumn
	private Sensor sensor;

	public SensorReading(Long sensorReadingId, Long reading, Date time, Sensor sensor) {
		this.sensorReadingId = sensorReadingId;
		this.reading = reading;
		this.time = time;
		this.sensor = sensor;
	}

	public SensorReading(Long reading, Date time, Sensor sensor) {
		this.reading = reading;
		this.time = time;
		this.sensor = sensor;
	}

	public SensorReading() {
	}

	public Long getSensorReadingId() {
		return sensorReadingId;
	}

	public Date getTime() {
		return time;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public Long getReading() {
		return reading;
	}
}
