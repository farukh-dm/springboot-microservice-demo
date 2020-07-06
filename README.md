# springboot-microservice-demo

> Eureka Server

> Eureka Client

> RestTemplate (is going to be deprecated & replaced by Web Client)

> Fault Tolerance:

  > Set request timeout
  
    HttpComponentsClientHttpRequestFactory
    SimpleClientHttpRequestFactory
  
  > Circuit breaker:
    
    Fail fast / Circuit breaker parameter / When does it trip ?
      Last n requests for deciding (Example: 5 requests)
      How many of last n requests are failing? (Example: 3 requests)
      Request failure timeout. After how much time, mark request as failed? (Example: 5 Seconds)

    Resuming circuit / Automatic recovery:
   
      How long to wait, before re-trying connection? (Example: 10 Seconds)
      
    Fallback: Things to do when the circuit is broken & someone makes a request for the broken service.
      
      1. Respond with error
      2. Respond with some default response (Recommended)
      3. Cache previous responses & use them, if applicable.
      
    Circuit Breaker Pattern:
      When to break circuit | What to do when circuit breaks | When to resume requests
    
  > Hystrix:
  
    Open Source library created by Netflix.
    Implement circuit breaker pattern.
    Provide your configuration & use it with springboot.
    Dependency: spring-cloud-starter-netflix-hystrix
    Add @EnableCircuitBreaker to application class
    Add @HystrixCommand to methods that need circuit breaker
    ```
    @HystrixCommand(fallbackMethod = "carsFallback")
	  public List<CarInfoDto> cars() {
    ...
    }
    
    public List<CarInfoDto> carsFallback() {
    ..
    }
    ```
    
    
    Configure Hystrix behavior / provide parameters for deciding to break circuit.
    
    
