package io.scriptless.microservices.servicefactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Scriptless on 24.02.2021
 */
@Service
public class ServiceFactoryServiceImpl implements ServiceFactoryService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public String spawnService() {
        final Resource dynamicServiceResource = resourceLoader.getResource("classpath:services/dynamicservice.jar");
        final Resource dynamicServiceProperties = resourceLoader.getResource("classpath:services/dynamicservice.properties");

        try {
            System.out.println("# Starting new dynamic service at " + dynamicServiceResource.getFile().getPath());

            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-jar",
                    dynamicServiceResource.getFile().getPath(),
                    "--spring.config.location=" + dynamicServiceProperties.getFile().getPath());
            Process p = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

            new Thread(() -> {
                try {
                    String s = "";
                    while((s = in.readLine()) != null) System.out.println(s);
                    int status = p.waitFor();
                    System.out.println("Exited with status: " + status);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            return "Spawned new dynamic service";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Failed spawning new dynamic service";
    }

}
