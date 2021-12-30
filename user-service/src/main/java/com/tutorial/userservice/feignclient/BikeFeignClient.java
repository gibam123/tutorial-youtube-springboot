package com.tutorial.userservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutorial.userservice.model.Bike;

@FeignClient(name = "bike-service", url = "http://localhost:8003")
public interface BikeFeignClient {

	@RequestMapping(value = "/bike", method = RequestMethod.POST)
	Bike save(@RequestBody Bike bike);
	
	@RequestMapping(value = "/bike/byuser/{userId}", method = RequestMethod.GET)
	List<Bike> getBikes(@PathVariable("userId") int userId);
	
}
