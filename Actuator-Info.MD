> Actuator

    Actuator Custom End Points:
  
    https://www.baeldung.com/spring-boot-actuators
  
    @Component
    @Endpoint(id = "app-features", enableByDefault = true)
    // Create an Actuator endpoint to query, enable, and disable feature flags in our application
    public class FeaturesEndPoint {
      ...
      ...
    }
  
    => {host}/{context-root}/actuator/app-features
  
  
    Actuator Custom End Points using Rest Controller:
    
    @Component
    @RestControllerEndpoint(id = "app-rest-end-point", enableByDefault = true)
    // Create an Actuator endpoint.

    public class RestControllerEndPoint {
	
      @GetMapping("/demo")
      public ResponseEntity<String> read(){
        return new ResponseEntity<>("My RestControllerEndPoint Demo", HttpStatus.OK);
      }
    }
    
    Custom Health Indicator:
    
    You can implements HealthIndicator & override health() method acocdingly.
    
