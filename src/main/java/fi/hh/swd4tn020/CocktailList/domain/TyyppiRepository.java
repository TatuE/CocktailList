package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TyyppiRepository  extends CrudRepository<Tyyppi, Long> {
	List<Tyyppi> findByTyyppi(String tyyppi);
	List<Tyyppi> findByYksikkoLuokka(String yksikkoLuokka);
}
