package fi.hh.swd4tn020.CocktailList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd4tn020.CocktailList.domain.Tyyppi;
import fi.hh.swd4tn020.CocktailList.domain.TyyppiRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TyyppiRepositoryTest {
	
	@Autowired
	private TyyppiRepository tyyppiRepository;
	
	@Test
		public void findByTyyppi() {
		List<Tyyppi> tyypit = tyyppiRepository.findByTyyppi("Koriste");
		assertThat(tyypit).hasSize(1);
		assertThat(tyypit.get(0).getYksikkoLuokka().equals("ainesosa"));		
	}
	
	@Test
		public void createTyyppi() {
		Tyyppi tyyppi = new Tyyppi("koeTyyppi", "koeLuokka");
		tyyppiRepository.save(tyyppi);
		Tyyppi tyyppiTest = tyyppiRepository.findByTyyppi("koeTyyppi").get(0);
		assertThat(tyyppiTest.getTyyppiId()).isNotNull();
	}
	
	@Test
		public void deleteTyyppi() {
		Tyyppi tyyppi = new Tyyppi("koeTyyppi", "koeLuokka");
		tyyppiRepository.save(tyyppi);
		Tyyppi tyyppiTest = tyyppiRepository.findByTyyppi("koeTyyppi").get(0);
		assertThat(tyyppiTest.getTyyppiId()).isNotNull();
		tyyppiRepository.delete(tyyppi);
		List<Tyyppi> tyyppiTestiLista = tyyppiRepository.findByTyyppi("koeTyyppi");
		assertThat(tyyppiTestiLista).hasSize(0);
	}

}
