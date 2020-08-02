package com.learning.springboot.ratingdataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.ratingdataservice.model.Rating;
import com.learning.springboot.ratingdataservice.model.UserRating;
import com.learning.springboot.ratingdataservice.service.RatingService;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {
	
	@Autowired
	private RatingService service;
	
	@RequestMapping("/{movieId}")
	public Rating getRatingByMovieId(@PathVariable(name="movieId") String movieId) {
		System.out.println(movieId);
		return service.getRatingByMovieId(movieId);
	}
	

	@RequestMapping("/users/{userId}")
	public UserRating getRatingByUserId(@PathVariable(name="userId") String userId) {
		System.out.println("Ratings based on User Id "+userId);
		try {
			Thread.sleep(2000); // if you change this value more than the time 
			//which we specify in hystrix command property then fallback method will be invoked.
		}catch(Exception e) {}
		return service.getRatingByUserId(userId);
	}

}
