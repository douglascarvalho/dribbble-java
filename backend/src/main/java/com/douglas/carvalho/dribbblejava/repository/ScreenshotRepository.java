package com.douglas.carvalho.dribbblejava.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.douglas.carvalho.dribbblejava.domain.Screenshot;

@Repository
public interface ScreenshotRepository extends CrudRepository<Screenshot, Long>  {
	
    @Query("SELECT t FROM com.douglas.carvalho.dribbblejava.domain.Screenshot t order by t.createdAt desc") 
    List<Screenshot> findByInsertDate();

    @Query("SELECT t FROM com.douglas.carvalho.dribbblejava.domain.Screenshot t where t.createdAt > :dateLimit") 
    List<Screenshot> findRecentlyAdded(@Param("dateLimit") Date dateLimit);

}
