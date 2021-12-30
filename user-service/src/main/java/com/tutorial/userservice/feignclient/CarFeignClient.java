package com.tutorial.userservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutorial.userservice.model.Car;

@FeignClient(name = "car-service", url = "http://localhost:8002")
//@RequestMapping("/car")
public interface CarFeignClient {
	
	//@PostMapping()
	@RequestMapping(value = "/car", method = RequestMethod.POST)
	Car save(@RequestBody Car car);	
	
	@RequestMapping(value = "/car/byuser/{userId}", method = RequestMethod.GET)
	List<Car> getCars(@PathVariable("userId") int userId);

}
