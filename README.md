# springboot-microservice-demo

> Eureka Server

> Eureka Client

> RestTemplate (is going to be deprecated & replaced by Web Client)

> Fault Tolerance:

  > Set request timeout
  
    HttpComponentsClientHttpRequestFactory
    SimpleClientHttpRequestFactory
  
  > Circuit breaker:
    
    Circuit breaker parameter / When does it trip ?
      Last n requests for deciding (Example: 5 requests)
      How many of last n requests are failing? (Example: 3 requests)
      Request failure timeout. After how much time, mark request as failed? (Example: 5 Seconds)

    Resumimg circuit:
   
      How long to wait, before re-trying connection? (Example: 10 Seconds)
