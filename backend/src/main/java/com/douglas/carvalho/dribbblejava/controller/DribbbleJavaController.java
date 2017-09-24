package com.douglas.carvalho.dribbblejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public @ResponseBody ResponseWrapper getPopularShots(){
		List<Screenshot> shots = dribbbleJavaService.getPopularScreenshots();
		return new ResponseWrapper(shots);
	}

	@RequestMapping(value="/favorites", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseWrapper getFavoritesShots(){
		List<Screenshot> shots = dribbbleJavaService.getFavoritesScreenshots();
		return new ResponseWrapper(shots);
	}
	
	@RequestMapping(value="/addToFavorites", method=RequestMethod.POST)
	public Result addToCart(@RequestBody Screenshot screenShot) {
		Result result = dribbbleJavaService.addToFavorites(screenShot);
		return result;
	}
	
	
	
}
