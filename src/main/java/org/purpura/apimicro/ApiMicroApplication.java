package org.purpura.apimicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiMicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiMicroApplication.class, args);
    }

}
