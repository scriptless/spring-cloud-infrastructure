package io.scriptless.microservices.servicefactory.controller;

import io.scriptless.microservices.servicefactory.services.ServiceFactoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Scriptless on 19.02.2021
 */
@RestController
@RequestMapping("/factory")
public class ServiceFactoryController {

    @Autowired
    private ServiceFactoryServiceImpl serviceFactoryService;

    @GetMapping("/create")
    public String createService() {
        return serviceFactoryService.spawnService();
    }

}
