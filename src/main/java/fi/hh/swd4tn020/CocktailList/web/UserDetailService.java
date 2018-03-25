package fi.hh.swd4tn020.CocktailList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.hh.swd4tn020.CocktailList.domain.Kayttaja;
import fi.hh.swd4tn020.CocktailList.domain.KayttajaRepository;

@Service
public class UserDetailService implements UserDetailsService {
	private final KayttajaRepository repository;
	
	@Autowired
	public UserDetailService(KayttajaRepository repository){		
		this.repository = repository;		
	}
	
	@Override
	public UserDetails loadUserByUsername(String kayttajaNimi) throws UsernameNotFoundException{
		Kayttaja nykyinenKayttaja = repository.findByKayttajaNimi(kayttajaNimi);
		UserDetails kayttaja  = new org.springframework.security.core.userdetails.User(kayttajaNimi, nykyinenKayttaja.getSalasana(),
				AuthorityUtils.createAuthorityList(nykyinenKayttaja.getRooli()));
		return kayttaja;				
	}
	
}
