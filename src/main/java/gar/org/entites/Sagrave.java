package gar.org.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sagraves")
public class Sagrave {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sgid;
	private String sgobject;
	private String sgdate;
    private String sgdatetime;
    private LocalDate sgdateb;
    private String sgusercree;
    private int sgcas;
    private int sgmois;
	public Sagrave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getSgid() {
		return sgid;
	}
	public void setSgid(Long sgid) {
		this.sgid = sgid;
	}
	public String getSgobject() {
		return sgobject;
	}
	public void setSgobject(String sgobject) {
		this.sgobject = sgobject;
	}
	public String getSgdate() {
		return sgdate;
	}
	public void setSgdate(String sgdate) {
		this.sgdate = sgdate;
	}
	public String getSgdatetime() {
		return sgdatetime;
	}
	public void setSgdatetime(String sgdatetime) {
		this.sgdatetime = sgdatetime;
	}
	public LocalDate getSgdateb() {
		return sgdateb;
	}
	public void setSgdateb(LocalDate sgdateb) {
		this.sgdateb = sgdateb;
	}
	public String getSgusercree() {
		return sgusercree;
	}
	public void setSgusercree(String sgusercree) {
		this.sgusercree = sgusercree;
	}
	public int getSgcas() {
		return sgcas;
	}
	public void setSgcas(int sgcas) {
		this.sgcas = sgcas;
	}
	public int getSgmois() {
		return sgmois;
	}
	public void setSgmois(int sgmois) {
		this.sgmois = sgmois;
	}
    
    
    
    

}
