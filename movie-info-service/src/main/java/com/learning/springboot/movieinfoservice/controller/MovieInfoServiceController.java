package com.learning.springboot.movieinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learning.springboot.movieinfoservice.model.Movie;
import com.learning.springboot.movieinfoservice.service.MovieService;

@RestController
@RequestMapping("/movieService")
public class MovieInfoServiceController {
	
	@Autowired
	private MovieService service;
	
	
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable(name="movieId") String movieId) {
		return service.getMovie(movieId);
	}

}
