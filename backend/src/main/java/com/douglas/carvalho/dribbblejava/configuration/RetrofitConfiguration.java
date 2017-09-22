package com.douglas.carvalho.dribbblejava.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douglas.carvalho.dribbblejava.api.APIDribbble;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfiguration {

	@Bean
	public Retrofit retrofit() {
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		
		return new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl("https://api.dribbble.com/v1/")
				.client(httpClient.build())
				.build();
	}

	@Bean
	public APIDribbble dribbleService(Retrofit retrofit) {
		return retrofit.create(APIDribbble.class);
	}
	
}
