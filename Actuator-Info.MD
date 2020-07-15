> Actuator

	some properties:
	
	  management.endpoints.web.base-path=/actuator
		management.endpoints.web.exposure.include=hystrix.stream,health,info,app-features,app-rest-end-point
		management.endpoints.web.exposure.exclude=beans,metrics
		#management.endpoints.web.exposure.include=*

		#management.endpoint.health.enabled=true
		management.endpoints.enabled-by-default=true

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
		
	Security:
	
	  Depenency: spring-boot-starter-security
		By Default, all endpoints are secured, except: /health & /info
		
		spring.security.user.name=lorem
		spring.security.user.password=ipsum
		
		
		

