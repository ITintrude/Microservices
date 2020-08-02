package com.learning.springboot.movieinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient // this annotation is not mandatory. Having a clinet jar in the client classpath does all the magic.
@EnableCircuitBreaker
public class MovieCatalogServiceApplication {
	
	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClientBuilder(){
		return  WebClient.builder();
	}
	
	@Bean
	@LoadBalanced // to discover the service which are registered in eureka server we use this annotation.
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = 
				new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setReadTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}
}
