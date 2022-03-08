package gar.org.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gar.org.entites.Puser;
import gar.org.repository.PuserRepository;

@RestController
@RequestMapping("/pmd")
@CrossOrigin(origins = "*")
public class PuserController {
	
	@Autowired
	private PuserRepository pur;
	
	@Autowired
	private EntityManager em;
	
	@PostMapping("/auth")
    public Puser PuserAuth(@RequestBody Puser puser) {
		
		String rb_username = puser.getPusername();
		String rb_password = puser.getPpassword();
		
		Puser mypuser = pur.findByPusernameAndPpassword(rb_username, rb_password);
		
		if(mypuser ==null) {
			
			throw new RuntimeException("Identification Incorrecte");
		}
		
		else {
			
			return mypuser;
		}
	
	}
	
	

}
