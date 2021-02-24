package io.scriptless.microservices.gateway.views;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.scriptless.microservices.gateway.services.GatewayServiceInstancesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Scriptless on 23.02.2021
 */
@Component
public class GatewayServiceInstancesViewImpl implements GatewayServiceInstancesView {

    @Autowired
    GatewayServiceInstancesServiceImpl instancesService;

    @Override
    public JsonNode instances() {
        List<ServiceInstance> instances = instancesService.instances();
        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);

        ArrayNode array = om.valueToTree(instances);
        ObjectNode object = om.createObjectNode();
        object.put("count", instances.size());
        object.putArray("instances").addAll(array);

        return object;
    }

    @Override
    public JsonNode simpleInstances() {
        Map<String, List<String>> instances = instancesService.simpleInstances();
        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);

        ArrayNode main = om.createArrayNode();

        instances.forEach((serviceName, serviceList) -> {
            ObjectNode object = main.addObject();
            ObjectNode service = object.put("service", serviceName);
            service.put("count", serviceList.size());
            ArrayNode array = om.valueToTree(serviceList);
            service.putArray("instances").addAll(array);
        });

        return main;
    }

}
