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
import gar.org.entites.Sagrave;
import gar.org.repository.SagraveRepository;

@RestController
@RequestMapping("/pba")
@CrossOrigin(origins = "*")
public class SagraveController {
	
	@Autowired
	private SagraveRepository sgr;
	
	@Autowired
	private EntityManager em;
	
	
	/* ------------------------------------------------------------\*
						Liste des Sans Gravite
	\*------------------------------------------------------------ */
	
		@GetMapping("/sagraves")
		public List <Sagrave> getSagraviteList() {	
			
			List <Sagrave> sagravites = null;
			return sagravites = sgr.findByOrderBySgidDesc();
		}
	
	/* <!------  |    FIN Liste des Sans Gravite |   ---------> */
		
		
	/* ------------------------------------------------------------\*
					Ajout D'un Incident Sans Gravite
	\*------------------------------------------------------------ */
		
		@PostMapping("/sagraves")
	    public Sagrave AjouterSagrave(@RequestBody Sagrave sagrave) {
			
			LocalDateTime myObj = LocalDateTime.now();
			LocalDate myObjc = LocalDate.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter myFormatObjb = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formattedDate = myObj.format(myFormatObj);
			String formattedDateTime = myObj.format(myFormatObjb);
			
			String rb_object = sagrave.getSgobject();
			int rb_cas = sagrave.getSgcas();
			String rb_usercree = "BIBANG Garcin";
			int rb_mois = myObjc.getMonthValue();
			
			Sagrave mySagrave = new Sagrave();
			
			mySagrave.setSgcas(rb_cas);
			mySagrave.setSgdate(formattedDate);
			mySagrave.setSgdateb(myObjc);
			mySagrave.setSgdatetime(formattedDateTime);
			mySagrave.setSgobject(rb_object);
			mySagrave.setSgusercree(rb_usercree);
			mySagrave.setSgmois(rb_mois);
			
			sgr.save(mySagrave);
			
			return mySagrave;
		
		}
	
		
	/* <!------  |    FIN Ajout D'un Incident Sans Gravite |   ---------> */
		
		
	
	/* -----------------------------------------------------------\*
				Modification D'un Incident Sans Gravite
	\*------------------------------------------------------------ */
		
		@PutMapping("/sagraves/{sgid}")
		public Sagrave modifSagrave(@RequestBody Sagrave sagrave, @PathVariable Long sgid) {
		
			String rb_object = sagrave.getSgobject();
			int rb_cas = sagrave.getSgcas();
			
			Sagrave mySagrave = sgr.findById(sgid).orElse(null);
			
			mySagrave.setSgcas(rb_cas);
			mySagrave.setSgobject(rb_object);
			
			sgr.save(mySagrave);
		
			return mySagrave;   
		}
		
	/* <!------  |    FIN Modification D'un Incident Sans Gravite |   ---------> */
		
		
		
	/* ------------------------------------------------------------\*
					Suppression D'un Incident Sans Gravite 
	\*------------------------------------------------------------ */
		
		@DeleteMapping("/sagraves/{sgid}")
		public Map<String, Boolean> deleteSagrave(@PathVariable Long sgid){
			
			Sagrave mySagrave = sgr.findById(sgid).orElse(null);

			sgr.delete(mySagrave);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
			
		}
		
	/* <!------  |    FIN Suppression D'un Incident Sans Gravite |   ---------> */

}
