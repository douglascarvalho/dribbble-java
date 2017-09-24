package com.douglas.carvalho.dribbblejava.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.carvalho.dribbblejava.api.APIDribbble;
import com.douglas.carvalho.dribbblejava.domain.Result;
import com.douglas.carvalho.dribbblejava.domain.ResultStatus;
import com.douglas.carvalho.dribbblejava.domain.Screenshot;
import com.douglas.carvalho.dribbblejava.repository.ScreenshotRepository;

import retrofit2.Call;

@Service
public class DribbbleJavaService {

	private static final Integer SCREENSHOTS_PER_PAGE_QUANTITY = 18;
	private static final String DRIBBBLE_ACCESS_TOKEN = "3938be32608d6bf9619843f558904afb43c3701fcd39cf911687841b6fad14bc";
	private static final Integer FAVORITE_FILTER_INSERT_DATE = 1;
	private static final Integer FAVORITE_FILTER_RECENTLY_ADDED = 2;
	
	@Autowired
	private APIDribbble apiDribbble;
	
	@Autowired
	private ScreenshotRepository screenshotRepository;
	
	public List<Screenshot> getPopularScreenshots() {
		try {
			Call<List<Screenshot>> popular = apiDribbble.getPopular(1, SCREENSHOTS_PER_PAGE_QUANTITY, DRIBBBLE_ACCESS_TOKEN);
			List<Screenshot> body = popular.execute().body();
			
			return body;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Screenshot> getFavoritesScreenshots(Integer favoriteFilter){
		if (FAVORITE_FILTER_INSERT_DATE.equals(favoriteFilter)){
			return (List<Screenshot>) screenshotRepository.findByInsertDate();
		} else if (FAVORITE_FILTER_RECENTLY_ADDED.equals(favoriteFilter)) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MINUTE, -2);

			return (List<Screenshot>) screenshotRepository.findRecentlyAdded(new Date(cal.getTimeInMillis()));
		} else {
			return (List<Screenshot>) screenshotRepository.findAll();
		}
	}
	
	public Result addToFavorites(Screenshot screenshot){
		if (screenshotRepository.findOne(screenshot.getId()) == null){
			screenshotRepository.save(screenshot);
			return new Result("Imagem salva com sucesso na sua galeria de imagens", ResultStatus.SUCCESS);
		} else {
			return new Result("Imagem já está salva na sua galeria de favoritos", ResultStatus.WARNING);
		}
	}

	public void removeFromFavorites(Long productId) {
		screenshotRepository.delete(productId);
	}

}
