package gar.org.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pusers")
public class Puser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long puid;
	private String pusername;
    private String ppassword;
    
    
	public Puser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Puser(String pusername, String ppassword) {
		super();
		this.pusername = pusername;
		this.ppassword = ppassword;
	}


	public Long getPuid() {
		return puid;
	}


	public void setPuid(Long puid) {
		this.puid = puid;
	}


	public String getPusername() {
		return pusername;
	}


	public void setPusername(String pusername) {
		this.pusername = pusername;
	}


	public String getPpassword() {
		return ppassword;
	}


	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}
	
	

}


