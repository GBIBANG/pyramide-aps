package gar.org.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Risque;
import gar.org.entites.Sagrave;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface SagraveRepository extends JpaRepository<Sagrave, Long>{
	
	List<Sagrave> findByOrderBySgidDesc();
	
	@Query("SELECT SUM(sg.sgcas) from Sagrave sg where sg.sgmois = ?1")
	Integer getSUM(int mmois);
	
	@Query("SELECT COUNT(sg.sgid) from Sagrave sg where sg.sgdateb BETWEEN ?1 AND ?2")
	Integer getCOUNTRecherche(LocalDate date, LocalDate dateb);
	
	@Query("SELECT AVG(sg.sgcas) from Sagrave sg")
	long getAVGDasagrave();
	
	
	@Query("SELECT MAX(sg.sgcas) from Sagrave sg")
	Integer getMAXDasagrave();
	
	@Query("SELECT MIN(sg.sgcas) from Sagrave sg")
	Integer getMINDasagrave();

}
