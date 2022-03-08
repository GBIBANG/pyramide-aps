package gar.org.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gar.org.entites.Sagrave;

@RestController
@RequestMapping("/pba")
@CrossOrigin(origins = "*")
public class Date {
	
	@GetMapping("/dates/annee")
	public int getAnnee() {	
		
		LocalDate current_date = LocalDate.now();
		int current_Year = current_date.getYear();
		
		return current_Year;
	}
	
	@GetMapping("/dates/day")
	public int getDay() {	
		
		LocalDate current_date = LocalDate.now();
		int current_Year = current_date.getMonthValue();
		
		return current_Year;
	}


}
