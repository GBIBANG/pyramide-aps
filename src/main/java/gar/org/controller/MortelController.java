package gar.org.controller;

import java.math.BigInteger;
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

import gar.org.entites.Mortel;
import gar.org.entites.Puser;
import gar.org.entites.Recherche;
import gar.org.repository.MortelRepository;
import org.springframework.data.domain.Sort;


@RestController
@RequestMapping("/pba")
@CrossOrigin(origins = "*")
public class MortelController {
	
	@Autowired
	private MortelRepository mr;
	
	@Autowired
	private EntityManager em;
	
	/* ------------------------------------------------------------\*
						Liste des Mortels 
	\*------------------------------------------------------------ */
	
		@GetMapping("/mortels")
		public List <Mortel> getMortelsALL() {	
			
			List <Mortel> mortels = null;
			return mortels = mr.findByOrderByMidDesc();
		}
		
	/* <!------  |    FIN Liste des Mortels |   ---------> */
		
		
	
	/* -------------------------------------------------------------\*
				      Recherche List Incidents Mortels
	\*------------------------------------------------------------- */

		@PostMapping("/mortels/recherche/date")
		public List <Mortel> getMorteblsRecherche(@RequestBody Recherche rmortel) {	
			
			LocalDate date = rmortel.getMdebut();
			LocalDate dateb = rmortel.getMfin();
			
			List <Mortel> mortels = null;
			
			return mortels = em
				.createNativeQuery("select * from mortels WHERE mortels.mdateb BETWEEN ?1 AND ?2", Mortel.class)
		         .setParameter(1, date)
		      	 .setParameter(2, dateb)
		          .getResultList(); 
		}
		
		

	/* <!------  |    FIN Recherche List Incidents Mortels  |   ---------> */
		
		
	
	/* ------------------------------------------------------\*
				Calcul du Nombre de Cas de la Recherche
	\*------------------------------------------------------- */	
		
		@PostMapping("/mortels/recherche")
		public long getCodebarReq(@RequestBody Recherche rmortel) {	
		
			LocalDate date = rmortel.getMdebut();
			LocalDate dateb = rmortel.getMfin();
			 
			long nbre = mr.getCOUNTRecherche(date, dateb);
			
			return nbre;
			  
			
		}
		
	/* <!------  |    FIN Calcul du Nombre de Cas de la Recherche |   ---------> */	
	
		
		
		
		
	/* ------------------------------------------------------------\*
							Ajout D'un Mortel
	\*------------------------------------------------------------ */
	
		@PostMapping("/mortels")
	    public Mortel MortelAdd(@RequestBody Mortel mortel) {
			
			LocalDateTime myObj = LocalDateTime.now();
			LocalDate myObjc = LocalDate.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter myFormatObjb = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formattedDate = myObj.format(myFormatObj);
			String formattedDateTime = myObj.format(myFormatObjb);
			
			String rb_mobject = mortel.getMobject();
			int rb_mcas = mortel.getMcas();
			String rb_usercree = "BIBANG Garcin";
			int rb_mois = myObjc.getMonthValue();
			
			Mortel mymortel = new Mortel();
			
			mymortel.setMcas(rb_mcas);
			mymortel.setMdate(formattedDate);
			mymortel.setMdateb(myObjc);
			mymortel.setMdatetime(formattedDateTime);
			mymortel.setMobject(rb_mobject);
			mymortel.setMusercree(rb_usercree);
			mymortel.setMmois(rb_mois);
			mr.save(mymortel);
			
			return mymortel;
		
		}
		
		
	/* <!------  |    FIN Ajout D'un Mortel |   ---------> */
		
		
		
	/* ------------------------------------------------------------\*
						Modification D'un Mortel
	\*------------------------------------------------------------ */
		
		@PutMapping("/mortels/{mid}")
		public Mortel modifMortel(@RequestBody Mortel mortel, @PathVariable Long mid) {
		
			String rb_object = mortel.getMobject();
			int rb_cas = mortel.getMcas();
			
			Mortel myMortel = mr.findById(mid).orElse(null);
			
			String formattedDate = myMortel.getMdate();
			LocalDate myObjc = myMortel.getMdateb();
			String formattedDateTime = myMortel.getMdatetime();
			String mortel_user_cree = myMortel.getMusercree();
			
			myMortel.setMcas(rb_cas);
			myMortel.setMdate(formattedDate);
			myMortel.setMdateb(myObjc);
			myMortel.setMdatetime(formattedDateTime);
			myMortel.setMobject(rb_object);
			myMortel.setMusercree(mortel_user_cree);
			
			mr.save(myMortel);
		
			return myMortel;   
		}
		
		
	 /* <!------  |    FIN Modification D'un Mortel |   ---------> */
		
		
		
	/* ------------------------------------------------------------\*
						Suppression D'un Mortel
	\*------------------------------------------------------------ */
		
		@DeleteMapping("/mortels/{mid}")
		public Map<String, Boolean> deleteMortel(@PathVariable Long mid){
			
			Mortel myMortel = mr.findById(mid).orElse(null);

			mr.delete(myMortel);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
			
			
		}
		
	/* <!------  |    FIN Suppression D'un Mortel  |   ---------> */
		
		
	

}
