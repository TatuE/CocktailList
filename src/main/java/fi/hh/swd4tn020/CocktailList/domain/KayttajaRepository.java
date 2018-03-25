package fi.hh.swd4tn020.CocktailList.domain;

import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {
	Kayttaja findByKayttajaNimi(String kayttajaNimi);
}
