
package gar.org.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Arret;
import gar.org.entites.Grave;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface ArretRepository extends JpaRepository<Arret, Long>{
	
	List<Arret> findByOrderByAidDesc();
	
	@Query("SELECT SUM(a.acas) from Arret a where a.amois = ?1")
	Integer getSUM(int mmois);

	
	@Query("SELECT COUNT(a.aid) from Arret a where a.adateb BETWEEN ?1 AND ?2")
	long getCOUNTRecherche(LocalDate date, LocalDate dateb);
	
	
	
	
	@Query("SELECT AVG(a.acas) from Arret a")
	long getAVGDaarret();
	
	
	@Query("SELECT MAX(a.acas) from Arret a")
	Integer getMAXDaarret();
	
	@Query("SELECT MIN(a.acas) from Arret a")
	Integer getMINDaarret();

}
