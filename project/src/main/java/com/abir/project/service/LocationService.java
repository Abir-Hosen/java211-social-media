package com.abir.project.service;

import java.util.List;

import com.abir.project.modal.Location;

public interface LocationService {
	
	public Location save(Location location);
	public List<Location> findAll();

}
