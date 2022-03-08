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

import gar.org.entites.Grave;
import gar.org.entites.Mortel;
import gar.org.repository.GraveRepository;


@RestController
@RequestMapping("/pba")
@CrossOrigin(origins = "*")
public class GraveController {
	
	@Autowired
	private GraveRepository gr;
	
	@Autowired
	private EntityManager em;
	
	
	/* ------------------------------------------------------------\*
						Liste des Graves
	\*------------------------------------------------------------ */
	
		@GetMapping("/graves")
		public List <Grave> getGravesList() {	
			
			List <Grave> graves = null;
			return graves = gr.findByOrderByGidDesc();
		}
	
	/* <!------  |    FIN Liste des Graves |   ---------> */
		
		
		
	/* ------------------------------------------------------------\*
					  Ajout D'un Incident Grave
	\*------------------------------------------------------------ */
		
		@PostMapping("/graves")
	    public Grave AjouterGrave(@RequestBody Grave grave) {
			
			LocalDateTime myObj = LocalDateTime.now();
			LocalDate myObjc = LocalDate.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter myFormatObjb = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formattedDate = myObj.format(myFormatObj);
			String formattedDateTime = myObj.format(myFormatObjb);
			
			String rb_gobject = grave.getGobject();
			int rb_gcas = grave.getGcas();
			String rb_usercree = "BIBANG Garcin";
			int rb_mois = myObjc.getMonthValue();
			
			Grave myGrave = new Grave();
			
			myGrave.setGcas(rb_gcas);
			myGrave.setGdate(formattedDate);
			myGrave.setGdateb(myObjc);
			myGrave.setGdatetime(formattedDateTime);
			myGrave.setGobject(rb_gobject);
			myGrave.setGusercree(rb_usercree);
			myGrave.setGmois(rb_mois);
			
			gr.save(myGrave);
			
			return myGrave;
		
		}
		
		
	/* <!------  |    FIN Ajout D'un Incident Grave |   ---------> */
		
		
	
	/* -----------------------------------------------------------\*
					Modification D'un Incident Grave
	\*------------------------------------------------------------ */
		
		@PutMapping("/graves/{gid}")
		public Grave modifGrave(@RequestBody Grave grave, @PathVariable Long gid) {
		
			String rb_object = grave.getGobject();
			int rb_cas = grave.getGcas();
			
			Grave myGrave = gr.findById(gid).orElse(null);
			
			myGrave.setGcas(rb_cas);
			myGrave.setGobject(rb_object);
			
			gr.save(myGrave);
		
			return myGrave;   
		}
		
		
	/* <!------  |    FIN Modification D'un Incident Grave |   ---------> */
		
		
	/* ------------------------------------------------------------\*
				Suppression D'un Incident Grave
	\*------------------------------------------------------------ */
		
		@DeleteMapping("/graves/{gid}")
		public Map<String, Boolean> deleteGrave(@PathVariable Long gid){
			
			Grave myGrave = gr.findById(gid).orElse(null);

			gr.delete(myGrave);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
			
			
		}
		
		
	/* <!------  |    FIN Suppression D'un Incident Grave |   ---------> */

}
