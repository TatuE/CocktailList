package fi.hh.swd4tn020.CocktailList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd4tn020.CocktailList.domain.Aines;
import fi.hh.swd4tn020.CocktailList.domain.AinesRepository;
import fi.hh.swd4tn020.CocktailList.domain.AinesosaRepository;
import fi.hh.swd4tn020.CocktailList.domain.CocktailRepository;
import fi.hh.swd4tn020.CocktailList.domain.TyyppiRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AinesRepositoryTest {
	@Autowired
	private AinesRepository ainesRepository;
	@Autowired
	private CocktailRepository cocktailRepository;
	@Autowired
	private TyyppiRepository tyyppiRepository;
	@Autowired
	private AinesosaRepository ainesosaRepository;
	
	@Test
		public void findByKaytossa() {
			Aines aines = ainesRepository.findByKaytossa(1).get(0);
			assertThat(aines).isNotNull();
	}
	
	@Test
		public  void createAines() {
			Aines aines = new Aines(2,1,tyyppiRepository.findByTyyppi("cl").get(0), ainesosaRepository.findByAinesosaNimi("Koskenkorva").get(0), cocktailRepository.findByNimi("KossuKola").get(0));
			ainesRepository.save(aines);
			List<Aines> ainesTesti = ainesRepository.findByCocktail(cocktailRepository.findByNimi("KossuKola").get(0));
			assertThat(ainesTesti.get(1).getAinesId()).isNotNull();
	}
	
	@Test
		public void deleteAines() {
			Aines aines = new Aines(2,1,tyyppiRepository.findByTyyppi("cl").get(0), ainesosaRepository.findByAinesosaNimi("Koskenkorva").get(0), cocktailRepository.findByNimi("KossuKola").get(0));
			ainesRepository.save(aines);
			List<Aines> ainesTesti = ainesRepository.findByCocktail(cocktailRepository.findByNimi("KossuKola").get(0));
			assertThat(ainesTesti.get(1).getAinesId()).isNotNull();
			long ainesID = ainesTesti.get(1).getAinesId();
			ainesRepository.delete(aines);
			List<Aines> ainesTestiLista = ainesRepository.findByAinesId(ainesID);
			assertThat(ainesTestiLista).hasSize(0);		
	}

}
