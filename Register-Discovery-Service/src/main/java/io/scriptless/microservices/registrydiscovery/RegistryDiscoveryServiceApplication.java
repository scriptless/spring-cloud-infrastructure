package io.scriptless.microservices.registrydiscovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistryDiscoveryServiceApplication {

	static Logger logger = LoggerFactory.getLogger(RegistryDiscoveryServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RegistryDiscoveryServiceApplication.class, args);
		logger.debug("Starting application...");
	}

}
