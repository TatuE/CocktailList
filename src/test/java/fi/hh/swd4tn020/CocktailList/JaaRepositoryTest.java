package fi.hh.swd4tn020.CocktailList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd4tn020.CocktailList.domain.Jaa;
import fi.hh.swd4tn020.CocktailList.domain.JaaRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JaaRepositoryTest {
	
	@Autowired
	private JaaRepository jaaRepository;
	
	@Test
		public void findByJaaMalli() {
			List<Jaa> jaat = jaaRepository.findByJaaMalli("Murska");
			assertThat(jaat).hasSize(1);
		}
	
	@Test
		public void createJaa() {
			Jaa jaa = new Jaa("koePala");
			jaaRepository.save(jaa);
			Jaa jaaTesti = jaaRepository.findByJaaMalli("koePala").get(0);
			assertThat(jaaTesti.getJaaId()).isNotNull();
		}
	
	@Test
		public void deleteJaa() {
		Jaa jaa = new Jaa("koePala");
		jaaRepository.save(jaa);
		Jaa jaaTesti = jaaRepository.findByJaaMalli("koePala").get(0);
		assertThat(jaaTesti.getJaaId()).isNotNull();
		jaaRepository.delete(jaa);
		List<Jaa> jaaTestiLista = jaaRepository.findByJaaMalli("koePala");
		assertThat(jaaTestiLista).hasSize(0);		
		}

}
