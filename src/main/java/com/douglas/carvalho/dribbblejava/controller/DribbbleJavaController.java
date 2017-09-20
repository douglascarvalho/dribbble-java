package com.douglas.carvalho.dribbblejava.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.carvalho.dribbblejava.api.APIDribbbleService;
import com.douglas.carvalho.dribbblejava.domain.Card;

import retrofit2.Call;

@RestController
@RequestMapping("/dribbble")
public class DribbbleJavaController {
	
	@Autowired
	private APIDribbbleService apiDribbbleService;
	
	@RequestMapping(method=RequestMethod.GET, value="/popular")
	public List<Card> getPopular(){
		Call<List<Card>> popular = apiDribbbleService.getPopular();
		List<Card> body = null;
		try {
			body = popular.execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}
	
	
}
