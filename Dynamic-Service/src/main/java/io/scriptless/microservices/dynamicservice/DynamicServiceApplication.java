package io.scriptless.microservices.dynamicservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DynamicServiceApplication {

	static Logger logger = LoggerFactory.getLogger(DynamicServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DynamicServiceApplication.class, args);
		logger.debug("Starting application...");
	}

}
