package demo.microservice.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SbServiceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbServiceConfigServerApplication.class, args);
	}

}
