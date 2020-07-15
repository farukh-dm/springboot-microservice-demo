package demo.microservice.config.client.home;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class DbConnectionForTest {
	
	public String test() {
		return "Test String";
	}

}
