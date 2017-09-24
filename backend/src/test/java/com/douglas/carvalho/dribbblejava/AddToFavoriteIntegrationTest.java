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
public class AddToFavoriteIntegrationTest {
    
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
        
        assertThat(result.getResultStatus(), is(ResultStatus.SUCCESS));
        assertThat(result.getMessage(), is("Imagem salva com sucesso na sua galeria de imagens"));        
    }
    

}
