package com.douglas.carvalho.dribbblejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.carvalho.dribbblejava.domain.ResponseWrapper;
import com.douglas.carvalho.dribbblejava.domain.Result;
import com.douglas.carvalho.dribbblejava.domain.Screenshot;
import com.douglas.carvalho.dribbblejava.service.DribbbleJavaService;

@RestController
@RequestMapping("/dribbble")
public class DribbbleJavaController {
	
	@Autowired
	private DribbbleJavaService dribbbleJavaService;
	
	@RequestMapping(value="/popular", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper getPopularShots(@RequestParam("page") Integer page){
		List<Screenshot> shots = dribbbleJavaService.getPopularScreenshots(page);
		return new ResponseWrapper(shots);
	}

	@RequestMapping(value="/favorites", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper getFavoritesShots(@RequestParam("favoriteFilter") Integer favoriteFilter){
		List<Screenshot> shots = dribbbleJavaService.getFavoritesScreenshots(favoriteFilter);
		return new ResponseWrapper(shots);
	}
	
	@RequestMapping(value="/addToFavorites", method=RequestMethod.POST)
	public Result addToFavorites(@RequestBody Screenshot screenShot) {
		Result result = dribbbleJavaService.addToFavorites(screenShot);
		return result;
	}
	
	@RequestMapping(value="/removeFromFavorites/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> removeFromFavorites(@PathVariable(value = "id") Long productId) {
		dribbbleJavaService.removeFromFavorites(productId);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
