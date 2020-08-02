package com.learning.springboot.movieinfoservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient // this annotation is not mandatory. Having a clinet jar in the client classpath does all the magic.
public class MovieInfoServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MovieInfoServiceApplication.class, args);
	}
	
	@Bean
	//@LoadBalanced // to discover the service which are registered in eureka server we use this annotation.
	public RestTemplate getRestTemplate() {
		return  new RestTemplate();
	}


}
