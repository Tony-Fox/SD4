package com.example.sd2.service;

import com.example.sd2.dtos.SensorDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class EmailServiceTest {



	@Test
	void sendMail() {
		EmailService emailService = new EmailService();
		SensorDTO sensorDTO = Mockito.mock(SensorDTO.class);
		when(sensorDTO.toString()).thenReturn("burger");
		emailService.sendMail(sensorDTO, "tonivulpe@yahoo.com");
	}
}