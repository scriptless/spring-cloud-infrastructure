package io.scriptless.microservices.gateway.views;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by Scriptless on 23.02.2021
 */
public interface GatewayServiceInstancesView {
    JsonNode instances();
    JsonNode simpleInstances();
}
