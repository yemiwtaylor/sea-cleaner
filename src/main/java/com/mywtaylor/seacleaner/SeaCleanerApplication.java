package com.mywtaylor.seacleaner;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeaCleanerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SeaCleanerApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(SeaCleanerApplication.class, args);
		InetAddress localHost = InetAddress.getLocalHost();
		LOGGER.info("Sea Cleaner Application server started at {}/{}", localHost.getHostAddress(), localHost.getHostName());
	}
}
