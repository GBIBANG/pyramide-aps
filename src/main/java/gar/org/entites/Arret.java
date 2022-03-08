package gar.org.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arrets")
public class Arret {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long aid;
	private String aobject;
	private String adate;
    private String adatetime;
    private LocalDate adateb;
    private String ausercree;
    private int acas;
	private int amois;
	public Arret() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Arret(String aobject, String adate, String adatetime, LocalDate adateb, String ausercree, int acas,
			int amois) {
		super();
		this.aobject = aobject;
		this.adate = adate;
		this.adatetime = adatetime;
		this.adateb = adateb;
		this.ausercree = ausercree;
		this.acas = acas;
		this.amois = amois;
	}
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getAobject() {
		return aobject;
	}
	public void setAobject(String aobject) {
		this.aobject = aobject;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public String getAdatetime() {
		return adatetime;
	}
	public void setAdatetime(String adatetime) {
		this.adatetime = adatetime;
	}
	public LocalDate getAdateb() {
		return adateb;
	}
	public void setAdateb(LocalDate adateb) {
		this.adateb = adateb;
	}
	public String getAusercree() {
		return ausercree;
	}
	public void setAusercree(String ausercree) {
		this.ausercree = ausercree;
	}
	public int getAcas() {
		return acas;
	}
	public void setAcas(int acas) {
		this.acas = acas;
	}
	public int getAmois() {
		return amois;
	}
	public void setAmois(int amois) {
		this.amois = amois;
	}
	
	
    

}
