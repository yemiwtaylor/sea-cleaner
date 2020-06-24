package com.marshmallow.yemitechnicalchallenge;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YemiTechnicalChallengeApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(YemiTechnicalChallengeApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(YemiTechnicalChallengeApplication.class, args);
		InetAddress localHost = InetAddress.getLocalHost();
		LOGGER.info("Marshmallow Yemi-Tech-Challenge Application server started at {}/{}", localHost.getHostAddress(), localHost.getHostName());
	}
}
