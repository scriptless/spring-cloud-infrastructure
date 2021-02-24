package io.scriptless.microservices.gateway;

import io.scriptless.microservices.gateway.views.GatewayServiceInstancesViewImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Scriptless on 23.02.2021
 */
@RestController
@Configuration
public class GatewayServiceController {

    @Autowired
    GatewayServiceInstancesViewImpl instancesView;

    @GetMapping(path = "/instancesFull")
    public String instances() {
        return instancesView.instances().toPrettyString();
    }

    @GetMapping(path = "/instances")
    public String simpleInstances() {
        return instancesView.simpleInstances().toPrettyString();
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/factory/**")
                        .uri("lb://SERVICE-FACTORY"))
                .route(r -> r.path("/service/**")
                        .uri("lb://DYNAMIC-SERVICE"))
                .build();
    }
}
