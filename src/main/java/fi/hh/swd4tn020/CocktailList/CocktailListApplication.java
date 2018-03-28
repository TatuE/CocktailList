package fi.hh.swd4tn020.CocktailList;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.hh.swd4tn020.CocktailList.domain.Aines;
import fi.hh.swd4tn020.CocktailList.domain.AinesRepository;
import fi.hh.swd4tn020.CocktailList.domain.Ainesosa;
import fi.hh.swd4tn020.CocktailList.domain.AinesosaRepository;
import fi.hh.swd4tn020.CocktailList.domain.Cocktail;
import fi.hh.swd4tn020.CocktailList.domain.CocktailRepository;
import fi.hh.swd4tn020.CocktailList.domain.Jaa;
import fi.hh.swd4tn020.CocktailList.domain.JaaRepository;
import fi.hh.swd4tn020.CocktailList.domain.Kayttaja;
import fi.hh.swd4tn020.CocktailList.domain.KayttajaRepository;
import fi.hh.swd4tn020.CocktailList.domain.Lasi;
import fi.hh.swd4tn020.CocktailList.domain.LasiRepository;
import fi.hh.swd4tn020.CocktailList.domain.Tyyppi;
import fi.hh.swd4tn020.CocktailList.domain.TyyppiRepository;

@SpringBootApplication
public class CocktailListApplication {
	private static final Logger log = LoggerFactory.getLogger(CocktailListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CocktailListApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner CocktailDemo(CocktailRepository cocktailRepository, JaaRepository jaaRepository, LasiRepository lasiRepository, TyyppiRepository tyyppiRepository,
			AinesosaRepository ainesosaRepository, AinesRepository ainesRepository, KayttajaRepository kayttajaRepository ) {
		return (args) -> {
			log.info("save a couple of new cocktail demos");
			
			tyyppiRepository.save(new Tyyppi("ml", "mittayksikko"));
			tyyppiRepository.save(new Tyyppi("cl", "mittayksikko"));
			tyyppiRepository.save(new Tyyppi("dl", "mittayksikko"));
			tyyppiRepository.save(new Tyyppi("l", "mittayksikko"));
			
			tyyppiRepository.save(new Tyyppi("g", "mittayksikko"));
			tyyppiRepository.save(new Tyyppi("kg", "mittayksikko"));			
			tyyppiRepository.save(new Tyyppi("ripaus", "mittayksikko"));
			tyyppiRepository.save(new Tyyppi("tippa", "mittayksikko"));
			
			tyyppiRepository.save(new Tyyppi("kpl", "mittayksikko"));
			
			tyyppiRepository.save(new Tyyppi("Koriste", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Mauste", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Marja", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Hedelmä", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Yrtti", "ainesosa"));
			
			tyyppiRepository.save(new Tyyppi("Viina", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Vodka", "ainesosa"));			
			tyyppiRepository.save(new Tyyppi("Gin", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Tequila", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Rommi", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Brandy", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Konjakki", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Whisky", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Whiskey", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Bourbon", "ainesosa"));			
			tyyppiRepository.save(new Tyyppi("Calvados", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Sake", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Likööri", "ainesosa"));
			
			tyyppiRepository.save(new Tyyppi("Punaviini", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Valkoviini", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Kuohuviini", "ainesosa"));
			
			tyyppiRepository.save(new Tyyppi("Olut", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Siideri", "ainesosa"));		
			
			tyyppiRepository.save(new Tyyppi("Mixeri", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Mehu", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Tee", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Kahvi", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Siirappi", "ainesosa"));
			
			lasiRepository.save(new Lasi("Grogi"));
			lasiRepository.save(new Lasi("Rocks"));
			lasiRepository.save(new Lasi("High ball"));
			lasiRepository.save(new Lasi("Cocktail"));
			lasiRepository.save(new Lasi("Tuoppi"));
			lasiRepository.save(new Lasi("Kahvikuppi"));
			lasiRepository.save(new Lasi("Viinilasi"));
			lasiRepository.save(new Lasi("Kuohuviinilasi"));
			lasiRepository.save(new Lasi("Aromilasi"));
			lasiRepository.save(new Lasi("Shottilasi"));
			
			jaaRepository.save(new Jaa("Pala"));
			jaaRepository.save(new Jaa("Murska"));
			jaaRepository.save(new Jaa("Ei jäitä"));			
			
			ainesosaRepository.save(new Ainesosa("Napue", tyyppiRepository.findByTyyppi("Gin").get(0)));	
			ainesosaRepository.save(new Ainesosa("Tonic", tyyppiRepository.findByTyyppi("Mixeri").get(0)));
			ainesosaRepository.save(new Ainesosa("Karpalo", tyyppiRepository.findByTyyppi("Marja").get(0)));
			ainesosaRepository.save(new Ainesosa("Rosmariini oksa", tyyppiRepository.findByTyyppi("Yrtti").get(0)));
			
			ainesosaRepository.save(new Ainesosa("Havanna Club anejo", tyyppiRepository.findByTyyppi("Rommi").get(0)));
			ainesosaRepository.save(new Ainesosa("Sitruuna", tyyppiRepository.findByTyyppi("Mehu").get(0)));
			ainesosaRepository.save(new Ainesosa("Sokeri", tyyppiRepository.findByTyyppi("Siirappi").get(0)));
			
			
					
			cocktailRepository.save(new Cocktail("Napue tonic",15,1,jaaRepository.findByJaaMalli("Pala").get(0), lasiRepository.findByLasiMalli("Rocks").get(0)));
			
			ainesRepository.save(new Aines(4,1,tyyppiRepository.findByTyyppi("cl").get(0),ainesosaRepository.findByAinesosaNimi("Napue").get(0), cocktailRepository.findByNimi("Napue tonic").get(0)));
			ainesRepository.save(new Aines(12,1, tyyppiRepository.findByTyyppi("cl").get(0),ainesosaRepository.findByAinesosaNimi("Tonic").get(0), cocktailRepository.findByNimi("Napue tonic").get(0)));			
			ainesRepository.save(new Aines(5,1,tyyppiRepository.findByTyyppi("kpl").get(0),ainesosaRepository.findByAinesosaNimi("Karpalo").get(0), cocktailRepository.findByNimi("Napue tonic").get(0)));
			ainesRepository.save(new Aines(1,1, tyyppiRepository.findByTyyppi("kpl").get(0),ainesosaRepository.findByAinesosaNimi("Rosmariini oksa").get(0), cocktailRepository.findByNimi("Napue tonic").get(0)));	
			
			cocktailRepository.save(new Cocktail("Daiquiri", 15, 1, jaaRepository.findByJaaMalli("Ei jäitä").get(0), lasiRepository.findByLasiMalli("Cocktail").get(0)));			
												
			ainesRepository.save(new Aines(4,1,tyyppiRepository.findByTyyppi("cl").get(0), ainesosaRepository.findByAinesosaNimi("Havanna Club anejo").get(0), cocktailRepository.findByNimi("Daiquiri").get(0)));
			ainesRepository.save(new Aines(3,1,tyyppiRepository.findByTyyppi("cl").get(0), ainesosaRepository.findByAinesosaNimi("Sitruuna").get(0), cocktailRepository.findByNimi("Daiquiri").get(0)));
			ainesRepository.save(new Aines(1,1,tyyppiRepository.findByTyyppi("cl").get(0), ainesosaRepository.findByAinesosaNimi("Sokeri").get(0), cocktailRepository.findByNimi("Daiquiri").get(0)));
			
			String adminPassword= "salasana";			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String adminPwd = passwordEncoder.encode(adminPassword);			
			
			//admin = salasana
			
			Kayttaja kayttajaAdmin = new Kayttaja("admin", adminPwd, "ADMIN");			
			kayttajaRepository.save(kayttajaAdmin);			

		};
		
	}
	
}
