package demo.microservice.carinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SbCarInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbCarInfoServiceApplication.class, args);
	}

}
