package io.scriptless.microservices.gateway.services;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.Map;

/**
 * Created by Scriptless on 23.02.2021
 */
public interface GatewayServiceInstancesService {
    List<ServiceInstance> instances();
    Map<String, List<String>> simpleInstances();
}
