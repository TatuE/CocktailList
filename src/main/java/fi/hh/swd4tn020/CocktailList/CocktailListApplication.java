package fi.hh.swd4tn020.CocktailList;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd4tn020.CocktailList.domain.Aines;
import fi.hh.swd4tn020.CocktailList.domain.AinesRepository;
import fi.hh.swd4tn020.CocktailList.domain.Ainesosa;
import fi.hh.swd4tn020.CocktailList.domain.AinesosaRepository;
import fi.hh.swd4tn020.CocktailList.domain.Cocktail;
import fi.hh.swd4tn020.CocktailList.domain.CocktailRepository;
import fi.hh.swd4tn020.CocktailList.domain.Jaa;
import fi.hh.swd4tn020.CocktailList.domain.JaaRepository;
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
			AinesosaRepository ainesosaRepository, AinesRepository ainesRepository) {
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
			
			tyyppiRepository.save(new Tyyppi("Limonaadi", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Mehu", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Tee", "ainesosa"));
			tyyppiRepository.save(new Tyyppi("Kahvi", "ainesosa"));
			
			lasiRepository.save(new Lasi("Grogi"));
			lasiRepository.save(new Lasi("Rocks"));
			lasiRepository.save(new Lasi("High ball"));
			lasiRepository.save(new Lasi("cocktail"));
			lasiRepository.save(new Lasi("Tuoppi"));
			lasiRepository.save(new Lasi("Kahvikuppi"));
			lasiRepository.save(new Lasi("Viinilasi"));
			lasiRepository.save(new Lasi("Kuohuviinilasi"));
			lasiRepository.save(new Lasi("Aromilasi"));
			lasiRepository.save(new Lasi("Shottilasi"));
			
			jaaRepository.save(new Jaa("Pala"));
			jaaRepository.save(new Jaa("Murska"));
			jaaRepository.save(new Jaa("Ei jäitä"));
			
			
			
			
			ainesosaRepository.save(new Ainesosa("Koskenkorva", tyyppiRepository.findByTyyppi("Vodka").get(0)));	
			ainesosaRepository.save(new Ainesosa("Banaani", tyyppiRepository.findByTyyppi("Likööri").get(0)));
			ainesosaRepository.save(new Ainesosa("Coca cola", tyyppiRepository.findByTyyppi("Limonaadi").get(0)));
			ainesosaRepository.save(new Ainesosa("Sprite", tyyppiRepository.findByTyyppi("Limonaadi").get(0)));
			ainesosaRepository.save(new Ainesosa("Jaffa", tyyppiRepository.findByTyyppi("Limonaadi").get(0)));
			ainesosaRepository.save(new Ainesosa("Karpalo mehu", tyyppiRepository.findByTyyppi("Mehu").get(0)));
			ainesosaRepository.save(new Ainesosa("Ginger ale", tyyppiRepository.findByTyyppi("Limonaadi").get(0)));
			
			
					
			cocktailRepository.save(new Cocktail("Banaani-Kola",10.00,1,jaaRepository.findByJaaMalli("Murska").get(0), lasiRepository.findByLasiMalli("Rocks").get(0)));
			
			ainesRepository.save(new Aines(4,1,tyyppiRepository.findByTyyppi("cl").get(0),ainesosaRepository.findByAinesosaNimi("Banaani").get(0), cocktailRepository.findByNimi("Banaani-Kola").get(0)));
			ainesRepository.save(new Aines(12,1, tyyppiRepository.findByTyyppi("cl").get(0),ainesosaRepository.findByAinesosaNimi("Coca cola").get(0), cocktailRepository.findByNimi("Banaani-Kola").get(0)));			
			/*	
			
			cocktailRepository.save(new Cocktail("KossuKola", 10.00, 1, jaaRepository.findByJaaMalli("Murska").get(0), lasiRepository.findByLasiMalli("Rocks").get(0)));			
												
			ainesRepository.save(new Aines(2,1,tyyppiRepository.findByTyyppi("cl").get(0), ainesosaRepository.findByAinesosaNimi("Koskenkorva").get(0), cocktailRepository.findByNimi("KossuKola",1).get(0)));
			ainesRepository.save(new Aines(2,1,tyyppiRepository.findByTyyppi("cl").get(0), ainesosaRepository.findByAinesosaNimi("Banaani").get(0), cocktailRepository.findByNimi("KossuKola",1).get(0)));
			ainesRepository.save(new Aines(12,1,tyyppiRepository.findByTyyppi("cl").get(0), ainesosaRepository.findByAinesosaNimi("Coca cola").get(0), cocktailRepository.findByNimi("KossuKola",1).get(0)));
					
			
			/*
			log.info("fetch all cocktails");
			for (Cocktail cocktail : cocktailRepository.findAll()) {
				log.info(cocktail.toString());
			}
			
			for(Aines aines: ainesRepository.findAll()) {
				log.info(aines.toString());
			}
			
			for(Aines aines: ainesRepository.findAll()) {
				if(aines.getCocktail().getNimi().equals("KossuKola")&&aines.getCocktail().getKaytossa()!=0) {
					log.info(aines.toString());
				}				
			}
			
			for(Ainesosa ainesosa: ainesosaRepository.findAll()) {				
					log.info(ainesosa.toString());								
			}
			*/	

		};
		
	}
	
}
