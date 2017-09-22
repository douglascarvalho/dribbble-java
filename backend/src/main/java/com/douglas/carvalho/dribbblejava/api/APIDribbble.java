package com.douglas.carvalho.dribbblejava.api;

import java.util.List;

import com.douglas.carvalho.dribbblejava.domain.Screenshot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIDribbble {
    
	@GET("shots")
    Call<List<Screenshot>> getPopular(
    		@Query("page") Integer page, 
    		@Query("per_page") Integer quantityPerPage, 
    		@Query("access_token") String accessToken
    		);

}
