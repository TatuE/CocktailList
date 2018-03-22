package fi.hh.swd4tn020.CocktailList;




import java.util.ArrayList;
import java.util.List;

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
			
			tyyppiRepository.save(new Tyyppi("CL"));
			tyyppiRepository.save(new Tyyppi("Vodka"));
			tyyppiRepository.save(new Tyyppi("Likööri"));
			tyyppiRepository.save(new Tyyppi("Mixeri"));
			
			ainesosaRepository.save(new Ainesosa("Koskenkorva", tyyppiRepository.findByTyyppi("Vodka").get(0)));	
			ainesosaRepository.save(new Ainesosa("Banaani", tyyppiRepository.findByTyyppi("Likööri").get(0)));
			ainesosaRepository.save(new Ainesosa("Cola", tyyppiRepository.findByTyyppi("Mixeri").get(0)));
			
			lasiRepository.save(new Lasi("Grogi"));
			lasiRepository.save(new Lasi("Rocks"));
			
			jaaRepository.save(new Jaa("Pala"));
			jaaRepository.save(new Jaa("Murska"));
			
			List<Aines> ainekset = new ArrayList<Aines>();
			
			Aines aines1 = new Aines(4,tyyppiRepository.findByTyyppi("CL").get(0),ainesosaRepository.findByAinesosa("Banaani").get(0));
			Aines aines2 = new Aines(12, tyyppiRepository.findByTyyppi("CL").get(0),ainesosaRepository.findByAinesosa("Cola").get(0));
			
			Cocktail cocktail1 = new Cocktail("Banaani-Kola",10.00,1,jaaRepository.findByJaaMalli("Murska").get(0), lasiRepository.findByLasiMalli("Rocks").get(0));
			cocktailRepository.save(cocktail1);
			aines1.setCocktail(cocktailRepository.findByNimi(cocktail1.getNimi()).get(0));
			ainesRepository.save(aines1);
			aines2.setCocktail(cocktailRepository.findByNimi(cocktail1.getNimi()).get(0));
			ainesRepository.save(aines2);
			
			Cocktail cocktail2 = cocktailRepository.findByNimi("Banaani-Kola").get(0);
			
			for(Aines aines: ainesRepository.findAll()) {
				if(aines.getCocktail().getNimi().equals(cocktail2.getNimi())&&aines.getCocktail().getKaytossa()!=0) {
					ainekset.add(aines);
				}				
			}
			cocktail2.setAinekset(ainekset);
			
			cocktailRepository.save(cocktail2);
			
			cocktailRepository.save(new Cocktail("KossuKola", 10.00, 1, jaaRepository.findByJaaMalli("Murska").get(0), lasiRepository.findByLasiMalli("Rocks").get(0)));			
												
			ainesRepository.save(new Aines(2,tyyppiRepository.findByTyyppi("CL").get(0), ainesosaRepository.findByAinesosa("Koskenkorva").get(0), cocktailRepository.findByNimi("KossuKola").get(0)));
			ainesRepository.save(new Aines(2,tyyppiRepository.findByTyyppi("CL").get(0), ainesosaRepository.findByAinesosa("Banaani").get(0), cocktailRepository.findByNimi("KossuKola").get(0)));
			ainesRepository.save(new Aines(12,tyyppiRepository.findByTyyppi("CL").get(0), ainesosaRepository.findByAinesosa("Cola").get(0), cocktailRepository.findByNimi("KossuKola").get(0)));
					
			
			
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
			
			for (Cocktail cocktail : cocktailRepository.findByNimi("Banaani-Kola")) {
				List<Aines> ainesosat = cocktail.getAinekset();
				Aines aines = ainesosat.get(0);
				log.info(aines.toString());
			}

		};
		
	}
	
}
