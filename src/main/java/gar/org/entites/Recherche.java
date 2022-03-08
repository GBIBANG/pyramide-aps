package gar.org.entites;

import java.time.LocalDate;

public class Recherche {
	
	LocalDate mdebut;
	LocalDate mfin;
	
	public Recherche(LocalDate mdebut, LocalDate mfin) {
		super();
		this.mdebut = mdebut;
		this.mfin = mfin;
	}
	public LocalDate getMdebut() {
		return mdebut;
	}
	public void setMdebut(LocalDate mdebut) {
		this.mdebut = mdebut;
	}
	public LocalDate getMfin() {
		return mfin;
	}
	public void setMfin(LocalDate mfin) {
		this.mfin = mfin;
	}
	
	

}
