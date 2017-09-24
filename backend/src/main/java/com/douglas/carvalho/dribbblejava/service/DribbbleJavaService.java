package com.douglas.carvalho.dribbblejava.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.carvalho.dribbblejava.api.APIDribbble;
import com.douglas.carvalho.dribbblejava.domain.Screenshot;
import com.douglas.carvalho.dribbblejava.domain.Result;
import com.douglas.carvalho.dribbblejava.domain.ResultStatus;
import com.douglas.carvalho.dribbblejava.repository.ScreenshotRepository;

import retrofit2.Call;

@Service
public class DribbbleJavaService {

	private final Integer quantityScreenshotsPerPage = 18;
	private final String accessToken = "3938be32608d6bf9619843f558904afb43c3701fcd39cf911687841b6fad14bc";
	
	@Autowired
	private APIDribbble apiDribbble;
	
	@Autowired
	private ScreenshotRepository screenshotRepository;
	
	public List<Screenshot> getPopularScreenshots() {
		try {
			Call<List<Screenshot>> popular = apiDribbble.getPopular(1, quantityScreenshotsPerPage, accessToken);
			List<Screenshot> body = popular.execute().body();
			
			return body;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Screenshot> getFavoritesScreenshots(){
		return (List<Screenshot>) screenshotRepository.findAll();
	}
	
	public Result addToFavorites(Screenshot screenshot){
		if (screenshotRepository.findOne(screenshot.getId()) == null){
			screenshotRepository.save(screenshot);
			return new Result("Imagem salva com sucesso na sua galeria de imagens", ResultStatus.SUCCESS);
		} else {
			return new Result("Imagem já está salva na sua galeria de favoritos", ResultStatus.WARNING);
		}
	}

}
