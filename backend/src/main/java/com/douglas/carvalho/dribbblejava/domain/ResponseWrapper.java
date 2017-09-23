package com.douglas.carvalho.dribbblejava.domain;

import java.util.List;

public class ResponseWrapper {
	
	private List<Screenshot> screenShots;
	
	public ResponseWrapper(List<Screenshot> screenShots) {
		this.screenShots = screenShots;
	}
	
	public List<Screenshot> getScreenShots() {
		return screenShots;
	}

	public void setScreenShots(List<Screenshot> screenShots) {
		this.screenShots = screenShots;
	}
}
