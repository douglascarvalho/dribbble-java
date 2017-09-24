package com.douglas.carvalho.dribbblejava;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.douglas.carvalho.dribbblejava.domain.Result;
import com.douglas.carvalho.dribbblejava.domain.ResultStatus;
import com.douglas.carvalho.dribbblejava.domain.Screenshot;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RemoveFromFavoriteIntegrationTest {
    
	@Autowired
    private TestRestTemplate restTemplate;
	

	@Test
    public void addToFavorite() {
		
    	Screenshot shot = new Screenshot();
    	shot.setId(Long.valueOf(123));
    	shot.setTitle("test title");

        ResponseEntity<Result> responseEntity =
            restTemplate.postForEntity("/dribbble/addToFavorites", shot, Result.class);
        
        Result result = responseEntity.getBody();
        
        //Garante que a imagem foi inserida
        assertThat(result.getResultStatus(), is(ResultStatus.SUCCESS));

        ResponseEntity<Result> responseEntity2 =
                restTemplate.postForEntity("/dribbble/addToFavorites", shot, Result.class);
        
        result = responseEntity2.getBody();
        
        //Garante que a imagem esta no banco de dados
        assertThat(result.getResultStatus(), is(ResultStatus.WARNING));

        
        restTemplate.delete("/dribbble/removeFromFavorites/123");

        ResponseEntity<Result> responseEntity3 =
                restTemplate.postForEntity("/dribbble/addToFavorites", shot, Result.class);
        
        result = responseEntity3.getBody();
        
        //Garante que a imagem tinha sido removida, pois foi inserida novamente
        assertThat(result.getResultStatus(), is(ResultStatus.SUCCESS));

	}
    

}
