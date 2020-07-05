package demo.microservice.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SbDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbDiscoveryServerApplication.class, args);
	}

}
