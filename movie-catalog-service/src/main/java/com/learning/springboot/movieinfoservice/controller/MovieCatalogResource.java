package com.learning.springboot.movieinfoservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.learning.springboot.movieinfoservice.model.CatalogItem;
import com.learning.springboot.movieinfoservice.model.Movie;
import com.learning.springboot.movieinfoservice.model.UserRating;
import com.learning.springboot.movieinfoservice.service.CatalogItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;



@RestController
@RequestMapping("/catalog")

public class MovieCatalogResource {
	
	@Autowired
	private CatalogItemService service;
	@Autowired
	private RestTemplate template;
	@Autowired
	private WebClient.Builder builder;
	@Value("${property.value}")
	private String testProperty;

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping("/{userId}")
	/*@HystrixCommand(fallbackMethod="getCatalogFallback",commandProperties= {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")})*/
	public UserRating getCatalog(@PathVariable(name="userId") String userId){	
		System.out.println(testProperty);
		// Get all the movie Id's from ratings . Which is hard coded for now as below 
		// Iterate ratingList and then invoke rest api call using template's getForobject() 
		//method which takes two arguments. 1st argument is the url and the second argument is the class which the response is marshalled 
		//For all the movie id's we retrieved get the movie details 
		// Put all of them together.
		
		//UserRating userRating = template.getForObject("http://localhost:8083/ratingdatas]rvice/ratingsdata/users/"+userId, UserRating.class);
		  UserRating userRatings = builder.build(). get().
		  uri("http://rating-data-service/ratingdataservice/ratingsdata/users/"+userId).accept(org.springframework.http.MediaType.APPLICATION_JSON).
		  retrieve(). bodyToMono(UserRating.class). block();
		
		return userRatings;
		/*.getRatingList().stream().map(rating -> {
			System.out.println("Rest Template Call for getting the details for the movie with Movie Id "+rating.getMovieId());			Movie movie = template.getForObject("http://movie-info-service/moviesinfoservice/movieService/"+rating.getMovieId(), Movie.class);
			// Since the Rest template is getting depricated the alternate approach to accomplish aforementioned call is using WebClient as below. 
			// WebClient builder is autowired as rest template to maintain the single instance of it. 
			// Movie movie = builder.build().get().uri("http://localhost:8082/moviesinfoservice/movieService/"+"").retrieve().bodyToMono(Movie.class).block();
			// get method is used for get call and post ()is for post calls uri() represents which URL to hit bodyToMono() to represents which class to be casted to.
			
			return new CatalogItem( movie.getMovieName(),"Description", rating.getRating());
		}
				).collect(Collectors.toList());
		//service.getAllCatalogs(userId);
		//return service.getAllCatalogs(userId);*/
	}
	
	public List<CatalogItem> getCatalogFallback(@PathVariable(name="userId") String userId){	
		List<CatalogItem> errorCatalogInstanceList = new ArrayList<>();
		errorCatalogInstanceList.add(new CatalogItem("No Movie Name Found","This is from fallback method",0));
		return errorCatalogInstanceList;
	}
	

}

