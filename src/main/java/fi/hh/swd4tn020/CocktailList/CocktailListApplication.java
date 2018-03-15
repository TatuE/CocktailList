package fi.hh.swd4tn020.CocktailList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.hh.swd4tn020.CocktailList.domain.Cocktail;
import fi.hh.swd4tn020.CocktailList.domain.CocktailRepository;
import fi.hh.swd4tn020.CocktailList.domain.Jaa;
import fi.hh.swd4tn020.CocktailList.domain.JaaRepository;
import fi.hh.swd4tn020.CocktailList.domain.Lasi;
import fi.hh.swd4tn020.CocktailList.domain.LasiRepository;

@SpringBootApplication
public class CocktailListApplication {
	private static final Logger log = LoggerFactory.getLogger(CocktailListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CocktailListApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner CocktailDemo(CocktailRepository cocktailRepository, JaaRepository jaaRepository, LasiRepository lasiRepository) {
		return (args) -> {
			log.info("save a couple of new cocktail demos");
			lasiRepository.save(new Lasi("Grogi"));
			lasiRepository.save(new Lasi("Rocks"));
			
			jaaRepository.save(new Jaa("Pala"));
			jaaRepository.save(new Jaa("Murska"));
			
			
			cocktailRepository.save(new Cocktail("KossuKola", 10.00, 1, jaaRepository.findByJaaMalli("Murska").get(0), lasiRepository.findByLasiMalli("Rocks").get(0)));
			//bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5",0.0, categoryRepository.findByName("Drama").get(0)));	
			
			/*
			String adminPassword= "salasanaAdmin";
			String userPassword= "salasana";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String adminPwd = passwordEncoder.encode(adminPassword);
			String userPwd = passwordEncoder.encode(userPassword);
			
			//user = salasana, admin = salasanaAdmin
			User userUser = new User("user", userPwd,"user@bookstore", "USER");
			User userAdmin = new User("admin", adminPwd,"admin@bookstore", "ADMIN");
			userRepository.save(userUser);
			userRepository.save(userAdmin);
			*/
			log.info("fetch all cocktails");
			for (Cocktail cocktail : cocktailRepository.findAll()) {
				log.info(cocktail.toString());
			}

		};
		
	}
	
}
