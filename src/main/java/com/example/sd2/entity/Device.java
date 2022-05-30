package com.example.sd2.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device")
public class Device {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deviceId;

	@Column
	private String name;

	@Column
	private String location;

	@OneToMany(mappedBy = "device")
	private List<Sensor> sensors;



	public Long getDeviceId() {
		return deviceId;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public List<Sensor> getProducts() {
		return sensors;
	}

	public Device(String name, String location) {
		this.name = name;
		this.location = location;
	}


	public Device() {
	}



}
