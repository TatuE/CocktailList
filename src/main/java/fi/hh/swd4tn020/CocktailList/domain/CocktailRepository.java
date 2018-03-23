package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CocktailRepository  extends CrudRepository<Cocktail, Long> {
	
	List<Cocktail> findByNimi(String nimi);
	List<Cocktail> findByKaytossa(int kaytossa);
	List<Cocktail> findByCocktailId(long cocktailId);
}
