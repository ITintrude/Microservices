package com.learning.springboot.ratingdataservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.springboot.ratingdataservice.model.Rating;
import com.learning.springboot.ratingdataservice.model.UserRating;

@Service
public class RatingService {
	
	
	public Rating getRatingByMovieId(String movieId) {
		return new Rating(movieId,5);
	}
	
	public UserRating getRatingByUserId(String userId) {
		UserRating rating = new UserRating();
		List<Rating> ratingsList = Arrays.asList(
				new Rating("1234", 5),
				new Rating("5678", 3), 
				new Rating("91011",4)
		);
		rating.setRatingList(ratingsList);
		return rating;
	}

}
