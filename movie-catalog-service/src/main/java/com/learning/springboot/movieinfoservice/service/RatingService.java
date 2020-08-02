package com.learning.springboot.movieinfoservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.springboot.movieinfoservice.model.Rating;
import com.learning.springboot.movieinfoservice.model.UserRating;

@Service
public class RatingService {
	
	

	public Rating getRatingByMovieId(String movieId) {
		return new Rating(movieId,5);
	}
	
	public UserRating getRatingsByUserId(String userId){
		UserRating userRating = new UserRating();
		List<Rating> ratingsList = Arrays.asList(
				new Rating("1234", 5),
				new Rating("5678", 3), 
				new Rating("91011",4)
		);
		//userRating.setUserId(userId);
		
		userRating.setRatingList(ratingsList);
		return userRating;
	}

}
