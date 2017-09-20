package com.douglas.carvalho.dribbblejava.api;

import java.util.List;

import com.douglas.carvalho.dribbblejava.domain.Card;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIDribbbleService {
    
	@GET("https://api.dribbble.com/v1/shots?sort=views?page=1&access_token=3938be32608d6bf9619843f558904afb43c3701fcd39cf911687841b6fad14bc")
    Call<List<Card>> getPopular();

}
