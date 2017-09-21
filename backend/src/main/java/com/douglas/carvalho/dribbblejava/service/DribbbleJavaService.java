package com.douglas.carvalho.dribbblejava.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.carvalho.dribbblejava.api.APIDribbble;
import com.douglas.carvalho.dribbblejava.domain.Screenshot;

import retrofit2.Call;

@Service
public class DribbbleJavaService {

	@Autowired
	private APIDribbble apiDribbble;
	
	public List<Screenshot> getPopularShots() {
		try {
			Call<List<Screenshot>> popular = apiDribbble.getPopular();
			List<Screenshot> body = popular.execute().body();
			
			return body;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
}
