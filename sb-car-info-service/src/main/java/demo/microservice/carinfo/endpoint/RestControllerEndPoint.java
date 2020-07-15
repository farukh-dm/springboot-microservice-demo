package demo.microservice.carinfo.endpoint;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@RestControllerEndpoint(id = "app-rest-end-point", enableByDefault = true)
// Create an Actuator endpoint.

public class RestControllerEndPoint {
	
	@GetMapping("/demo")
    public ResponseEntity<String> read(){
        return new ResponseEntity<>("My RestControllerEndPoint Demo", HttpStatus.OK);
    }

}
