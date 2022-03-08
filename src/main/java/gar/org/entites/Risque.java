package gar.org.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="risques")
public class Risque {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rid;
	private String robject;
	private String rdate;
    private String rdatetime;
    private LocalDate rdateb;
    private String rusercree;
    private int rcas;
	private int rmois;
	public Risque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Risque(String robject, String rdate, String rdatetime, LocalDate rdateb, String rusercree, int rcas,
			int rmois) {
		super();
		this.robject = robject;
		this.rdate = rdate;
		this.rdatetime = rdatetime;
		this.rdateb = rdateb;
		this.rusercree = rusercree;
		this.rcas = rcas;
		this.rmois = rmois;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getRobject() {
		return robject;
	}
	public void setRobject(String robject) {
		this.robject = robject;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getRdatetime() {
		return rdatetime;
	}
	public void setRdatetime(String rdatetime) {
		this.rdatetime = rdatetime;
	}
	public LocalDate getRdateb() {
		return rdateb;
	}
	public void setRdateb(LocalDate rdateb) {
		this.rdateb = rdateb;
	}
	public String getRusercree() {
		return rusercree;
	}
	public void setRusercree(String rusercree) {
		this.rusercree = rusercree;
	}
	public int getRcas() {
		return rcas;
	}
	public void setRcas(int rcas) {
		this.rcas = rcas;
	}
	public int getRmois() {
		return rmois;
	}
	public void setRmois(int rmois) {
		this.rmois = rmois;
	}
	
	
    

}
