package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AinesRepository  extends CrudRepository<Aines, Long>{
	List<Aines> findByAinesId(long ainesId);	

}
