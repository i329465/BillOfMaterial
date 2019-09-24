package com.sap.billofmaterial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class BillOfMaterialApplication extends SpringBootServletInitializer {
//public class BillOfMaterialApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillOfMaterialApplication.class, args);
    }
}