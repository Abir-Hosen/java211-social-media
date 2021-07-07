package com.abir.project.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.abir.project.modal.Location;
import com.abir.project.service.LocationService;

@Component
public class ApplicationRunnerProject implements ApplicationRunner {
	
	@Autowired
	LocationService locationService;

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(ApplicationRunnerProject.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {

		logger.info("Application started with application-runner arguments: {} \n"
				+ "- Author: Abir Hosen Ashik");
		
		if(isInstalled()==true) {
			System.out.println("System already up to date!");
		}else if(isInstalled()==false){
			System.out.println("System is way to up to date...");
			initLocation();
			System.out.println("System is ready to use!");
		}
	}
	
	
	private Boolean isInstalled() {
		
		if(locationService.findAll().isEmpty()) {
			return false;
		}
		return true;
	}
	
	private void initLocation() {
		
		locationService.save(new Location(1, "Sylhet"));
		locationService.save(new Location(2, "Bandarban"));
		locationService.save(new Location(3, "Khulna"));
		
	}

}

