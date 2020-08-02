package com.learning.springboot.movieinfoservice.model;

import java.util.List;

public class UserRating {
	
	//private String userId;

	private List<Rating> ratingList;
	
	

	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRating(List<Rating> ratingList) {
		super();
	//this.userId = userId;
		this.ratingList = ratingList;
	}

	/**
	 * @return the userId
	 */
	/*
	 * public String getUserId() { return userId; }
	 */

	/**
	 * @param userId the userId to set
	 */
	/*
	 * public void setUserId(String userId) { this.userId = userId; }
	 */

	/**
	 * @return the ratingList
	 */
	public List<Rating> getRatingList() {
		return ratingList;
	}

	/**
	 * @param ratingList the ratingList to set
	 */
	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}
	
	

}
