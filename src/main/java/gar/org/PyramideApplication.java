package gar.org;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import gar.org.entites.Arret;
import gar.org.entites.Grave;
import gar.org.entites.Mortel;
import gar.org.entites.Risque;
import gar.org.entites.Sagrave;
import gar.org.repository.ArretRepository;

@SpringBootApplication
public class PyramideApplication implements CommandLineRunner {
	
	@Autowired
	RepositoryRestConfiguration config;
	
	@Autowired
	private ArretRepository ar;

	public static void main(String[] args) {
		SpringApplication.run(PyramideApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		config.exposeIdsFor(Mortel.class, Grave.class, Sagrave.class, Risque.class, Arret.class);
		config.setReturnBodyOnCreate(true);
		config.setReturnBodyOnUpdate(true);
		
		

		
		
		
		
		
	}

}
