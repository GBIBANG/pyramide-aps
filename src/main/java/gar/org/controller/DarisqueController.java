package gar.org.controller;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gar.org.entites.Damortel;
import gar.org.entites.Darisque;
import gar.org.repository.RisqueRepository;


@RestController
@RequestMapping("/pba")
@CrossOrigin(origins = "*")
public class DarisqueController {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private RisqueRepository rr;
	
	@GetMapping("/darisques")
	public Darisque getDarisque() {
		
		int m1 = 1;
		int m2 = 2;
		int m3 = 3;
		int m4 = 4;
		int m5 = 5;
		int m6 = 6;
		int m7 = 7;
		int m8 = 8;
		int m9 = 9;
		int m10 = 10;
		int m11 = 11;
		int m12 = 12;
		
		Integer janvier;
		Integer fevrier;
		Integer mars;
		Integer avril;
		Integer mai;
		Integer juin;
		Integer juillet;
		Integer aout;
		Integer septembre;
		Integer octobre;
		Integer novembre;
		Integer decembre;
		Integer somme;
		Integer sommeb;
		Integer sommec;
		Integer sommed;
		Integer sommee;
		Integer sommef;
		Integer total;
		
		Integer max;
		Integer min;
		long nbre;
		long moy;
		
		
		/* ------------------------------------------------\*
		   				Calcul du Nombre de Cas
		\*------------------------------------------------ */
		
			nbre = rr.count();
		
		/* <!------  |    FIN Calcul du Nombre de Cas |   ---------> */
			
			
			
		/* ------------------------------------------------\*
		      			Calcul de la Valeur MAX
		\*------------------------------------------------ */
			
			Integer vmax = rr.getMAXDarisque();
			
			if(vmax==null) {
				
				max = 0;
			}
			else {
				
				max = vmax;
			}
			
		/* <!------  |    FIN Calcul de la Valeur MAX |   ---------> */
			
			
			
			
		/* ------------------------------------------------\*
		      			Calcul de la Valeur MIN
		\*------------------------------------------------ */
			
			Integer vmin = rr.getMINDarisque();
			
			if(vmin==null) {
				
				min = 0;
			}
			else {
				
				min = vmin;
			}
			
			
			
		/* <!------  |    FIN Calcul de la Valeur MIN |   ---------> */
			
			
			
		/* ------------------------------------------------\*
  						Calcul de la Valeur MOY
		\*------------------------------------------------ */
			
			moy = 0;
			
			moy = rr.getAVGDarisque();
			
		/* <!------  |    FIN Calcul de la Valeur MOY |   ---------> */
		
		
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Janvier
		\*------------------------------------------------ */
			
			Integer vjanvier = rr.getSUM(m1);
		
			if(vjanvier==null) {
				
				janvier = 0;
			}
			else {
				
				janvier = vjanvier;
			}
			
		/* <!------  |    FIN Calcul de la somme du mois de Janvier |   ---------> */
			
		
		
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Février
		\*------------------------------------------------ */
			
			Integer vfevrier = rr.getSUM(m2);
			
			if(vfevrier==null) {
				
				fevrier = 0;
			}
			else {
				
				fevrier = vfevrier;
			}
			
		/* <!------  |  FIN  Calcul de la somme du mois de Février |   ---------> */
			
			
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Mars
		\*------------------------------------------------ */
			
			Integer vmars = rr.getSUM(m3);
			
			if(vmars==null) {
				
				mars = 0;
			}
			else {
				
				mars = vmars;
			}
			
		/* <!------  |   FIN Calcul de la somme du mois de Mars |   ---------> */
			
			
			
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Avril
		\*------------------------------------------------ */
		
			Integer vavril = rr.getSUM(m4);
			
			if(vavril==null) {
				
				avril = 0;
			}
			else {
				
				avril = vavril;
			}
		
		/* <!------  |   FIN Calcul de la somme du mois de Avril |   ---------> */
		
		
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Mai
		\*------------------------------------------------ */
	
			Integer vmai = rr.getSUM(m5);
			
			if(vmai==null) {
				
				mai = 0;
			}
			else {
				
				mai = vmai;
			}
	
		/* <!------  |   FIN Calcul de la somme du mois de Mai |   ---------> */
			
			
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Juin
		\*------------------------------------------------ */
	
			Integer vjuin = rr.getSUM(m6);
			
			if(vjuin==null) {
				
				juin = 0;
			}
			else {
				
				juin = vjuin;
			}
	
		/* <!------  |   FIN Calcul de la somme du mois de Juin |   ---------> */
			
			
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Juillet
	    \*------------------------------------------------ */
	
			Integer vjuillet = rr.getSUM(m7);
			
			if(vjuillet==null) {
				
				juillet = 0;
			}
			else {
				
				juillet = vjuillet;
			}
	
		/* <!------  |   FIN Calcul de la somme du mois de Juillet |   ---------> */
			
			
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Aout
    	\*------------------------------------------------ */

			Integer vaout = rr.getSUM(m8);
			
			if(vaout==null) {
				
				aout = 0;
			}
			else {
				
				aout = vaout;
			}

		/* <!------  |   FIN Calcul de la somme du mois de Aout |   ---------> */
			
			
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Septembre
    	\*------------------------------------------------ */

			Integer vseptembre = rr.getSUM(m9);
			
			if(vseptembre==null) {
				
				septembre = 0;
			}
			else {
				
				septembre = vseptembre;
			}

		/* <!------  |   FIN Calcul de la somme du mois de Septembre |   ---------> */
			
			
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Octobre
		\*------------------------------------------------ */

			Integer voctobre = rr.getSUM(m10);
			
			if(voctobre==null) {
				
				octobre = 0;
			}
			else {
				
				octobre = voctobre;
			}

		/* <!------  |   FIN Calcul de la somme du mois de Octobre |   ---------> */
			
			
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Novembre
		\*------------------------------------------------ */

			Integer vnovembre = rr.getSUM(m11);
			
			if(vnovembre==null) {
				
				novembre = 0;
			}
			else {
				
				novembre = vnovembre;
			}

		/* <!------  |   FIN Calcul de la somme du mois de Novembre |   ---------> */
			
			
			
			
		/* ------------------------------------------------\*
				Calcul de la somme du mois de Decembre
		\*------------------------------------------------ */

			Integer vdecembre = rr.getSUM(m12);
			
			if(vdecembre==null) {
				
				decembre = 0;
			}
			else {
				
				decembre = vdecembre;
			}


		/* <!------  |   FIN Calcul de la somme du mois de Decembre |   ---------> */
			
			
		somme = janvier + fevrier + mars;
		sommeb = avril + mai + juin;
		sommec = juillet + aout + septembre;
		sommed = octobre + novembre + decembre;
		
		sommee = somme + sommeb;
		sommef = sommec + sommed;
		
		total = sommee + sommef;
	
	
	
		
		return new Darisque(janvier, fevrier, mars, avril, mai, juin, juillet, aout, septembre, octobre, novembre,
				decembre, somme, sommeb, sommec, sommed, sommee, sommef, total,  nbre, max, min, moy);
	}


}
