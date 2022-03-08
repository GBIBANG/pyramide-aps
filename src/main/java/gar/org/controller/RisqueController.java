
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
import gar.org.entites.Risque;
import gar.org.repository.RisqueRepository;


@RestController
@RequestMapping("/pba")
@CrossOrigin(origins = "*")
public class RisqueController {
	
	@Autowired
	private RisqueRepository rr;
	
	@Autowired
	private EntityManager em;
	
	
	/* ------------------------------------------------------------\*
							Liste des Risques
	\*------------------------------------------------------------ */
	
		@GetMapping("/risques")
		public List <Risque> getRisquesList() {	
			
			List <Risque> risques = null;
			return risques = rr.findByOrderByRidDesc();
		}
		
	/* <!------  |    FIN Liste des Risques |   ---------> */
		
		
	
	/* ------------------------------------------------------------\*
						Ajout D'un Incident Risque
	\*------------------------------------------------------------ */
		
		@PostMapping("/risques")
	    public Risque AjouterRisque(@RequestBody Risque risque) {
			
			LocalDateTime myObj = LocalDateTime.now();
			LocalDate myObjc = LocalDate.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter myFormatObjb = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formattedDate = myObj.format(myFormatObj);
			String formattedDateTime = myObj.format(myFormatObjb);
			
			String rb_object = risque.getRobject();
			int rb_acas = risque.getRcas();
			String rb_usercree = "BIBANG Garcin";
			int rb_mois = myObjc.getMonthValue();
			
			Risque myRisque = new Risque();
			
			myRisque.setRcas(rb_acas);
			myRisque.setRdate(formattedDate);
			myRisque.setRdateb(myObjc);
			myRisque.setRdatetime(formattedDateTime);
			myRisque.setRobject(rb_object);
			myRisque.setRusercree(rb_usercree);
			myRisque.setRmois(rb_mois);
			
			rr.save(myRisque);
			
			return myRisque;
		
		}
	
		
	/* <!------  |    FIN Ajout D'un Incident Risque |   ---------> */
		
		
		
	/* -----------------------------------------------------------\*
					Modification D'un Incident Risque
	\*------------------------------------------------------------ */
		
		@PutMapping("/risques/{rid}")
		public Risque modifRisque(@RequestBody Risque risque, @PathVariable Long rid) {
		
			String rb_object = risque.getRobject();
			int rb_cas = risque.getRcas();
			
			Risque myRisque = rr.findById(rid).orElse(null);
			
			myRisque.setRcas(rb_cas);
			myRisque.setRobject(rb_object);
			
			rr.save(myRisque);
		
			return myRisque;   
		}
		
	/* <!------  |    FIN Modification D'un Incident Risque |   ---------> */
		
		
	/* ------------------------------------------------------------\*
						Suppression D'un Incident Risque
	\*------------------------------------------------------------ */
		
		@DeleteMapping("/risques/{rid}")
		public Map<String, Boolean> deleteRisque(@PathVariable Long rid){
			
			Risque myRisque = rr.findById(rid).orElse(null);

			rr.delete(myRisque);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
			
			
		}
	
	/* <!------  |    FIN Suppression D'un Incident Risque |   ---------> */
		
		
	
}
