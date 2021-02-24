package io.scriptless.microservices.dynamicservice.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Scriptless on 19.02.2021
 */
@RestController
@RequestMapping("/service")
public class DynamicServiceController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    EurekaClient eurekaClient;

    @GetMapping()
    public String service() {
        return "Hi! Dynamic service Instance-ID: " + eurekaClient.getApplicationInfoManager().getInfo().getInstanceId();
    }

    @GetMapping("/stop")
    public String stopService() {
        new Thread(() -> SpringApplication.exit(context, () -> 0)).start();
        return "Stopped dynamic service with Instance-ID: " + eurekaClient.getApplicationInfoManager().getInfo().getInstanceId();
    }

}
