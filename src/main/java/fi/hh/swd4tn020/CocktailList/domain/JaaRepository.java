package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JaaRepository  extends CrudRepository<Jaa, Long> {
	
	List<Jaa> findByJaaMalli(String jaaMalli);
}
