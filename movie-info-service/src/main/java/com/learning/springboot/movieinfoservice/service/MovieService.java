package com.learning.springboot.movieinfoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.springboot.movieinfoservice.model.Movie;
import com.learning.springboot.movieinfoservice.model.MovieSearch;

@Service
public class MovieService {
	
	@Value("${x-rapidapi-host}")
	private String rapidKey;
	@Value("${x-rapidapi-key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate template;
	
	public Movie getMovie(String movieId) {
		
		
		  HttpHeaders headers = new HttpHeaders(); 
		  headers.add("x-rapidapi-host", rapidKey);
		  headers.add("x-rapidapi-key", apiKey); 
		  HttpEntity<String> entity =  new HttpEntity<String>("parameters", headers); 
		  ResponseEntity<MovieSearch> respEntity = template.exchange("https://movie-database-imdb-alternative.p.rapidapi.com/?page=1&r=json&s=Avengers%20Endgame",
		  HttpMethod.GET, entity, MovieSearch.class);
		  System.out.println(respEntity.getBody().getResponse());
		  System.out.println("Check if the control comes here ");
		  
		  return new Movie(movieId , "Baahubali Description");
		    		
	}

}
