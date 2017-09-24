package com.douglas.carvalho.dribbblejava.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.douglas.carvalho.dribbblejava.domain.Screenshot;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ScreenshotRepositoryTests {
    
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ScreenshotRepository repository;

    @Test
    public void testInsert(){
    	Screenshot shot = new Screenshot();
    	shot.setId(Long.valueOf(123));
    	shot.setTitle("test title");
    	
        this.entityManager.persist(shot);
        List<Screenshot> screenshots = (List<Screenshot>) this.repository.findAll();
        
        assertThat(screenshots.size(), is(1));
        
        Screenshot screenshot = screenshots.get(0);
        assertThat(screenshot.getTitle(), is("test title"));
        assertThat(screenshot.getId(), is(Long.valueOf(123)));
    }
    
}
