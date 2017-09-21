package com.douglas.carvalho.dribbblejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.carvalho.dribbblejava.domain.Screenshot;
import com.douglas.carvalho.dribbblejava.service.DribbbleJavaService;

@RestController
@RequestMapping("/dribbble")
public class DribbbleJavaController {
	
	@Autowired
	private DribbbleJavaService dribbbleJavaService;
	
	@RequestMapping(method=RequestMethod.GET, value="/popular")
	public List<Screenshot> getPopular(){
		List<Screenshot> shots = dribbbleJavaService.getPopularShots();
		return shots;
	}
	
	
}
