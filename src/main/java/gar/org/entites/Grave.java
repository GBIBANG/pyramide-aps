package gar.org.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="graves")
public class Grave {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long gid;
	private String gobject;
	private String gdate;
    private String gdatetime;
    private LocalDate gdateb;
    private String gusercree;
    private int gcas;
    private int gmois;
	public Grave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grave(String gobject, String gdate, String gdatetime, LocalDate gdateb, String gusercree, int gcas,
			int gmois) {
		super();
		this.gobject = gobject;
		this.gdate = gdate;
		this.gdatetime = gdatetime;
		this.gdateb = gdateb;
		this.gusercree = gusercree;
		this.gcas = gcas;
		this.gmois = gmois;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getGobject() {
		return gobject;
	}
	public void setGobject(String gobject) {
		this.gobject = gobject;
	}
	public String getGdate() {
		return gdate;
	}
	public void setGdate(String gdate) {
		this.gdate = gdate;
	}
	public String getGdatetime() {
		return gdatetime;
	}
	public void setGdatetime(String gdatetime) {
		this.gdatetime = gdatetime;
	}
	public LocalDate getGdateb() {
		return gdateb;
	}
	public void setGdateb(LocalDate gdateb) {
		this.gdateb = gdateb;
	}
	public String getGusercree() {
		return gusercree;
	}
	public void setGusercree(String gusercree) {
		this.gusercree = gusercree;
	}
	public int getGcas() {
		return gcas;
	}
	public void setGcas(int gcas) {
		this.gcas = gcas;
	}
	public int getGmois() {
		return gmois;
	}
	public void setGmois(int gmois) {
		this.gmois = gmois;
	}
    
    
    
	
	
    
    

}
