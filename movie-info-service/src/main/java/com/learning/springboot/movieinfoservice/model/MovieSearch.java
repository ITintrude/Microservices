package com.learning.springboot.movieinfoservice.model;

import java.util.ArrayList;
import java.util.List;

public class MovieSearch {
		 List < MovieDetails > Search = new ArrayList < MovieDetails > ();
		 private String totalResults;
		 private String Response;
		
		
		 // Getter Methods 
		
		 public String getTotalResults() {
		  return totalResults;
		 }
		
		 public String getResponse() {
		  return Response;
		 }
		
		 // Setter Methods 
		
		 public void setTotalResults(String totalResults) {
		  this.totalResults = totalResults;
		 }
		
		 public void setResponse(String Response) {
		  this.Response = Response;
		 }
}