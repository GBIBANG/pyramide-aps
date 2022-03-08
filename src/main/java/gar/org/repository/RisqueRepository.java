
package gar.org.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Grave;
import gar.org.entites.Risque;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface RisqueRepository extends JpaRepository<Risque, Long>{
	
	List<Risque> findByOrderByRidDesc();
	
	@Query("SELECT SUM(r.rcas) from Risque r where r.rmois = ?1")
	Integer getSUM(int mmois);
	
	@Query("SELECT COUNT(r.rid) from Risque r where r.rdateb BETWEEN ?1 AND ?2")
	Integer getCOUNTRecherche(LocalDate date, LocalDate dateb);
	
	@Query("SELECT AVG(r.rcas) from Risque r")
	long getAVGDarisque();
	
	
	@Query("SELECT MAX(r.rcas) from Risque r")
	Integer getMAXDarisque();

	@Query("SELECT MIN(r.rcas) from Risque r")
	Integer getMINDarisque();

}
