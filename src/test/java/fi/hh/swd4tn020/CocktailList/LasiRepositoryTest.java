package fi.hh.swd4tn020.CocktailList;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd4tn020.CocktailList.domain.Lasi;
import fi.hh.swd4tn020.CocktailList.domain.LasiRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LasiRepositoryTest {
	
	@Autowired
	private LasiRepository lasiRepository;
	
	@Test
		public void findByLasiMalli() {
			List<Lasi> lasit = lasiRepository.findByLasiMalli("Grogi");
			assertThat(lasit).hasSize(1);			
	}
	
	@Test
		public void createLasi() {
			Lasi lasi = new Lasi("koeLasi");
			lasiRepository.save(lasi);
			Lasi lasiTest = lasiRepository.findByLasiMalli("koeLasi").get(0);
			assertThat(lasiTest.getLasiId()).isNotNull();
	}
	
	@Test
		public void deleteLasi() {
			Lasi lasi = new Lasi("koeLasi");
			lasiRepository.save(lasi);
			Lasi lasiTest = lasiRepository.findByLasiMalli("koeLasi").get(0);
			assertThat(lasiTest.getLasiId()).isNotNull();
			lasiRepository.delete(lasi);
			List<Lasi> lasiTestLista = lasiRepository.findByLasiMalli("koeLasi");
			assertThat(lasiTestLista).hasSize(0);
	}
			
			

}
