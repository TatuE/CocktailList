package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LasiRepository  extends CrudRepository<Lasi, Long> {
	
	List<Lasi> findByLasiMalli(String lasiMalli);
}
