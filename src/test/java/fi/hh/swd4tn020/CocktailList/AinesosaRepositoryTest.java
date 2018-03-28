package fi.hh.swd4tn020.CocktailList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd4tn020.CocktailList.domain.Ainesosa;
import fi.hh.swd4tn020.CocktailList.domain.AinesosaRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AinesosaRepositoryTest {
	
	@Autowired
	private AinesosaRepository ainesosaRepository;
	
	@Test
		public void findByAinesosaNimi() {
			List<Ainesosa> ainesosat = ainesosaRepository.findByAinesosaNimi("Tonic");
			assertThat(ainesosat).hasSize(1);
	}
	
	@Test
		public void createAinesosa() {
			Ainesosa ainesosa = new Ainesosa("KoeAinesosa");
			ainesosaRepository.save(ainesosa);
			Ainesosa ainesosaTesti = ainesosaRepository.findByAinesosaNimi("KoeAinesosa").get(0);
			assertThat(ainesosaTesti.getAinesosaId()).isNotNull();
	}
	
	@Test
		public void deleteAinesosa() {
			Ainesosa ainesosa = new Ainesosa("KoeAinesosa");
			ainesosaRepository.save(ainesosa);
			Ainesosa ainesosaTesti = ainesosaRepository.findByAinesosaNimi("KoeAinesosa").get(0);
			assertThat(ainesosaTesti.getAinesosaId()).isNotNull();
			ainesosaRepository.delete(ainesosa);
			List<Ainesosa> ainesosaTestLista = ainesosaRepository.findByAinesosaNimi("KoeAinesosa");
			assertThat(ainesosaTestLista).hasSize(0);
	}
	

}
