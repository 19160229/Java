package edu.njnu.his;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DrugServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugServerApplication.class, args);
    }

}
