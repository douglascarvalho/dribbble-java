package com.douglas.carvalho.dribbblejava.repository;

import org.springframework.stereotype.Repository;

import com.douglas.carvalho.dribbblejava.domain.Screenshot;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ScreenshotRepository extends CrudRepository<Screenshot, Long>  {}
