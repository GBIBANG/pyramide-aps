
package gar.org.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Grave;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface GraveRepository extends JpaRepository<Grave, Long>{
	
	List<Grave> findByOrderByGidDesc();
	
	@Query("SELECT SUM(g.gcas) from Grave g where g.gmois = ?1")
	Integer getSUM(int mmois);

	
	@Query("SELECT COUNT(g.gid) from Grave g where g.gdateb BETWEEN ?1 AND ?2")
	Integer getCOUNTRecherche(LocalDate date, LocalDate dateb);
	
	@Query("SELECT AVG(g.gcas) from Grave g")
	long getAVGDagrave();
	
	
	@Query("SELECT MAX(g.gcas) from Grave g")
	Integer getMAXDagrave();
	
	@Query("SELECT MIN(g.gcas) from Grave g")
	Integer getMINDagrave();

}
