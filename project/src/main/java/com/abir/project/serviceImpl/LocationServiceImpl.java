package com.abir.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.project.modal.Location;
import com.abir.project.repository.LocationRepository;
import com.abir.project.service.LocationService;

@Service("locationService")
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	LocationRepository locationRepository;

	@Override
	public Location save(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

}
