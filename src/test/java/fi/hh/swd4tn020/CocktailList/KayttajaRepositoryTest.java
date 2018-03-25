package fi.hh.swd4tn020.CocktailList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd4tn020.CocktailList.domain.Kayttaja;
import fi.hh.swd4tn020.CocktailList.domain.KayttajaRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KayttajaRepositoryTest {
	
	@Autowired
	private KayttajaRepository kayttajaRepository;
	
	@Test
		public void findByNimi() {
			Kayttaja kayttaja = kayttajaRepository.findByKayttajaNimi("admin");
			assertThat(kayttaja).isNotNull();
	}
	
	@Test
		public void createKayttaja(){
			Kayttaja kayttaja = new Kayttaja("koe", "koesalasana", "koerooli");
			kayttajaRepository.save(kayttaja);
			Kayttaja kayttajaTesti = kayttajaRepository.findByKayttajaNimi("koe");
			assertThat(kayttajaTesti.getKayttajaId()).isNotNull();
	}
	
	@Test
		public void delelteKayttaja() {
			Kayttaja kayttaja = new Kayttaja("koe", "koesalasana", "koerooli");
			kayttajaRepository.save(kayttaja);
			Kayttaja kayttajaTesti = kayttajaRepository.findByKayttajaNimi("koe");
			assertThat(kayttajaTesti.getKayttajaId()).isNotNull();
			kayttajaRepository.delete(kayttaja);
			Kayttaja kayttajatesti = kayttajaRepository.findByKayttajaNimi("koe");
			assertThat(kayttajatesti).isNull();
			
	}

}
