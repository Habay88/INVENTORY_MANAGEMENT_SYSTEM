package com.sid.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sid.model.Location;
import com.sid.service.LocationService;

import java.util.List;

@RestController
public class LocationController {


	@Autowired
	private LocationService locationService;

	@GetMapping("/locations")
	public List<Location> getAll(){
		return locationService.findAll();
	}

	//The Get Location By Id
	@GetMapping("/location/{id}")
	public Location getLocation(@PathVariable Integer id){
		return locationService.findById(id);
	}

	@PutMapping("/location/{id}")
	public Location editLocation(@RequestBody Location location, @PathVariable String id){
		return locationService.save(location);
	}

	@PostMapping("/locations")
	public Location addLocation(@RequestBody Location location){
		return locationService.save(location);
	}

	@DeleteMapping("/location/{id}")
	public  void delete(@PathVariable Integer id){
		locationService.deleteById(id);
	}
}
