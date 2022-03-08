
package gar.org.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mortels")
public class Mortel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mid;
	private String mobject;
	private String mdate;
    private String mdatetime;
    private LocalDate mdateb;
    private String musercree;
    private int mcas;
    private int mmois;
    
    
	public Mortel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Mortel(String mobject, String mdate, String mdatetime, LocalDate mdateb, String musercree, int mcas,
			int mmois) {
		super();
		this.mobject = mobject;
		this.mdate = mdate;
		this.mdatetime = mdatetime;
		this.mdateb = mdateb;
		this.musercree = musercree;
		this.mcas = mcas;
		this.mmois = mmois;
	}


	public Long getMid() {
		return mid;
	}


	public void setMid(Long mid) {
		this.mid = mid;
	}


	public String getMobject() {
		return mobject;
	}


	public void setMobject(String mobject) {
		this.mobject = mobject;
	}


	public String getMdate() {
		return mdate;
	}


	public void setMdate(String mdate) {
		this.mdate = mdate;
	}


	public String getMdatetime() {
		return mdatetime;
	}


	public void setMdatetime(String mdatetime) {
		this.mdatetime = mdatetime;
	}


	public LocalDate getMdateb() {
		return mdateb;
	}


	public void setMdateb(LocalDate mdateb) {
		this.mdateb = mdateb;
	}


	public String getMusercree() {
		return musercree;
	}


	public void setMusercree(String musercree) {
		this.musercree = musercree;
	}


	public int getMcas() {
		return mcas;
	}


	public void setMcas(int mcas) {
		this.mcas = mcas;
	}


	public int getMmois() {
		return mmois;
	}


	public void setMmois(int mmois) {
		this.mmois = mmois;
	}
	
	
    
    
	
    
    
    
    

}
