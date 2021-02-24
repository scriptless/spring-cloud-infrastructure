package io.scriptless.microservices.servicefactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceFactoryApplication {

	static Logger logger = LoggerFactory.getLogger(ServiceFactoryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceFactoryApplication.class, args);
		logger.debug("Starting application...");
	}

}
