package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AinesosaRepository  extends CrudRepository<Ainesosa, Long> {
	List<Ainesosa> findByAinesosaNimi(String ainesosaNimi);
}
