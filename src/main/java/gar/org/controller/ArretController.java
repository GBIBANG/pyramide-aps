package gar.org.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gar.org.entites.Arret;
import gar.org.entites.Grave;
import gar.org.repository.ArretRepository;

@RestController
@RequestMapping("/pba")
@CrossOrigin(origins = "*")
public class ArretController {
	
	@Autowired
	private ArretRepository ar;
	
	@Autowired
	private EntityManager em;
	
	/* ------------------------------------------------------------\*
							Liste des Arrets
	\*------------------------------------------------------------ */
	
		@GetMapping("/arrets")
		public List <Arret> getArretsList() {	
			
			List <Arret> arrets = null;
			return arrets = ar.findByOrderByAidDesc();
		}
	
	/* <!------  |    FIN Liste des Arrets |   ---------> */
		
		
	/* ------------------------------------------------------------\*
		  					Ajout D'un Incident Arret
	\*------------------------------------------------------------ */
	

		@PostMapping("/arrets")
	    public Arret AjouterArret(@RequestBody Arret arret) {
			
			LocalDateTime myObj = LocalDateTime.now();
			LocalDate myObjc = LocalDate.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter myFormatObjb = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formattedDate = myObj.format(myFormatObj);
			String formattedDateTime = myObj.format(myFormatObjb);
			
			String rb_aobject = arret.getAobject();
			int rb_acas = arret.getAcas();
			String rb_usercree = "BIBANG Garcin";
			int rb_mois = myObjc.getMonthValue();
			
			Arret myArret = new Arret();
			
			myArret.setAcas(rb_acas);
			myArret.setAdate(formattedDate);
			myArret.setAdateb(myObjc);
			myArret.setAdatetime(formattedDateTime);
			myArret.setAobject(rb_aobject);
			myArret.setAusercree(rb_usercree);
			myArret.setAmois(rb_mois);
			
			ar.save(myArret);
			
			return myArret;
		
		}
	
		
	/* <!------  |    FIN Ajout D'un Incident Arret |   ---------> */
		
		
		
	/* -----------------------------------------------------------\*
					Modification D'un Incident Arret
	\*------------------------------------------------------------ */
		
		@PutMapping("/arrets/{aid}")
		public Arret modifArret(@RequestBody Arret arret, @PathVariable Long aid) {
		
			String rb_object = arret.getAobject();
			int rb_cas = arret.getAcas();
			
			Arret myArret = ar.findById(aid).orElse(null);
			
			myArret.setAcas(rb_cas);
			myArret.setAobject(rb_object);
			
			ar.save(myArret);
		
			return myArret;   
		}
		
	/* <!------  |    FIN Modification D'un Incident Arret |   ---------> */
		
		
		
	/* ------------------------------------------------------------\*
				Suppression D'un Incident Arret
	\*------------------------------------------------------------ */
		
		@DeleteMapping("/arrets/{aid}")
		public Map<String, Boolean> deleteArret(@PathVariable Long aid){
			
			Arret myArret = ar.findById(aid).orElse(null);

			ar.delete(myArret);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
			
			
		}
		
		
	/* <!------  |    FIN Suppression D'un Incident Arret |   ---------> */
	
}
