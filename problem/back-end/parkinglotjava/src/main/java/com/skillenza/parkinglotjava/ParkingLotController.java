package com.skillenza.parkinglotjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ParkingLotController {
	@Autowired
	private ParkingLotRepository parkingLotRepository;
    // your code goes here
	
	@GetMapping("/parkings")
	public List<ParkingLot> getParkings() {
		
		return parkingLotRepository.findAll();
		
		
	}
	
	@PostMapping("/parkings")
	public ParkingLot saveData(@RequestBody final ParkingLot parkingLot){
		
		parkingLotRepository.save(parkingLot);
		return parkingLot;
		
	}
	
}

