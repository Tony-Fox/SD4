package com.example.sd2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sensor")
public class Sensor {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sensorId;

	@Column
	private String name;

	@Column
	private String description;

	@ManyToOne
	@JoinColumn
	private Device device;

	@OneToMany(mappedBy = "sensor")
	private List<SensorReading> sensorReadings;

	public Long getSensorId() {
		return sensorId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Device getDevice() {
		return device;
	}

	public Sensor(String name, String description, Device device) {
		this.name = name;
		this.description = description;
		this.device = device;
	}

	public Sensor() {
	}
}
