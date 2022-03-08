

package gar.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Puser;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface PuserRepository extends JpaRepository<Puser, Long>{
	
	public Puser findByPusernameAndPpassword(String username, String password);

}
