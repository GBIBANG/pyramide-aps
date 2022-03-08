package gar.org.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Mortel;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface MortelRepository extends JpaRepository<Mortel, Long>{
	
	List<Mortel> findByOrderByMidDesc();
	
	@Query("SELECT SUM(m.mcas) from Mortel m where m.mmois = ?1")
	Integer getSUM(int mmois);
	
	@Query("SELECT COUNT(m.mid) from Mortel m where m.mdateb BETWEEN ?1 AND ?2")
	Integer getCOUNTRecherche(LocalDate date, LocalDate dateb);
	
	@Query("SELECT AVG(m.mcas) from Mortel m")
	long getAVGDamortel();
	
	
	@Query("SELECT MAX(m.mcas) from Mortel m")
	Integer getMAXDamortel();
	
	@Query("SELECT MIN(m.mcas) from Mortel m")
	Integer getMINDamortel();
    
    

}
