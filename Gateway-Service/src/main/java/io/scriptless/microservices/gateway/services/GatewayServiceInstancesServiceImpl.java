package io.scriptless.microservices.gateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Scriptless on 23.02.2021
 */
@Service
public class GatewayServiceInstancesServiceImpl implements GatewayServiceInstancesService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public List<ServiceInstance> instances() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = new ArrayList<>();
        services.forEach(s -> instances.addAll(discoveryClient.getInstances(s)));
        return instances;
    }

    @Override
    public Map<String, List<String>> simpleInstances() {
        Map<String, List<String>> simpleInstances = new HashMap<>();
        discoveryClient.getServices().forEach(s -> {
            List<String> services = new ArrayList<>();
            discoveryClient.getInstances(s).forEach(i -> services.add(i.getInstanceId()));
            simpleInstances.put(s, services);
        });
        return simpleInstances;
    }

}
