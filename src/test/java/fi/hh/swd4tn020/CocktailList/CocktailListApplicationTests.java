package fi.hh.swd4tn020.CocktailList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd4tn020.CocktailList.web.CocktailController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CocktailListApplicationTests {
	
	@Autowired
	private CocktailController cocktailController;
	@Test
	public void contextLoads() throws Exception {
		assertThat(cocktailController).isNotNull();
	}
}