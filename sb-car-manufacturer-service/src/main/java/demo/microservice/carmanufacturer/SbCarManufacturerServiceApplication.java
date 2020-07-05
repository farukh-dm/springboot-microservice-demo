package demo.microservice.carmanufacturer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SbCarManufacturerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbCarManufacturerServiceApplication.class, args);
	}

}
