package com.learning.springboot.movieinfoservice.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.springboot.movieinfoservice.model.CatalogItem;

@Service
public class CatalogItemService {
	
	public List<CatalogItem> getAllCatalogs(String userId){
		HashMap<String,List<CatalogItem>> myMap = new HashMap<String,List<CatalogItem>>(){{
		    this.put("Srikanth", Collections.singletonList(new CatalogItem("Transformers" , "Tranformers Description", 4)
		    		));
		}};
		
		return myMap.get(userId);
	}

}
