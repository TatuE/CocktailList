package fi.hh.swd4tn020.CocktailList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import fi.hh.swd4tn020.CocktailList.domain.Cocktail;
import fi.hh.swd4tn020.CocktailList.domain.CocktailRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CocktailRepositoryTest {
	
	@Autowired
	private CocktailRepository cocktailRepository;
	
	@Test
		public void findByNimi() {
			List<Cocktail> cocktails = cocktailRepository.findByNimi("Napue tonic");
			assertThat(cocktails).hasSize(1);
			assertThat(cocktails.get(0).getHinta()==10);	
		}
	
	@Test
		public void createNewCocktail() {
			Cocktail cocktail = new Cocktail("koeCocktail",10,1);
			cocktailRepository.save(cocktail);
			Cocktail cocktailTesti = cocktailRepository.findByNimi("koeCocktail").get(0);
			assertThat(cocktailTesti.getCocktailId()).isNotNull();
		}
	
	@Test
		public void deleteCocktail() {
			Cocktail cocktail = new Cocktail("koeCocktail",10,1);
			cocktailRepository.save(cocktail);
			Cocktail cocktailTesti = cocktailRepository.findByNimi("koeCocktail").get(0);
			assertThat(cocktailTesti.getCocktailId()).isNotNull();
			cocktailRepository.delete(cocktail);
			List<Cocktail> cocktailTestiLista = cocktailRepository.findByNimi("koeCocktail");
			assertThat(cocktailTestiLista).hasSize(0);
		}

}
