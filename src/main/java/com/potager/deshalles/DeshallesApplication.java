package com.potager.deshalles;

import com.potager.deshalles.error.FirebaseException;
import com.potager.deshalles.error.JacksonUtilityException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class DeshallesApplication {


    public static void main(String[] args) throws IOException, FirebaseException, JacksonUtilityException {

        SpringApplication.run(DeshallesApplication.class, args);
    }
}
