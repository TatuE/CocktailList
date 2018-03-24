package fi.hh.swd4tn020.CocktailList.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.swd4tn020.CocktailList.domain.Aines;
import fi.hh.swd4tn020.CocktailList.domain.AinesRepository;
import fi.hh.swd4tn020.CocktailList.domain.Ainesosa;
import fi.hh.swd4tn020.CocktailList.domain.AinesosaRepository;
import fi.hh.swd4tn020.CocktailList.domain.Cocktail;
import fi.hh.swd4tn020.CocktailList.domain.CocktailRepository;
import fi.hh.swd4tn020.CocktailList.domain.JaaRepository;
import fi.hh.swd4tn020.CocktailList.domain.LasiRepository;
import fi.hh.swd4tn020.CocktailList.domain.TyyppiRepository;

@Controller
public class CocktailController {
	
	@Autowired
	private TyyppiRepository tyyppiRepository;
	
	@Autowired
	private AinesosaRepository ainesosaRepository;
	
	@Autowired
	private AinesRepository ainesRepository;
	
	@Autowired
	private JaaRepository jaaRepository;
	
	@Autowired
	private LasiRepository lasiRepository;
	
	@Autowired
	private CocktailRepository cocktailRepository;
	
	@RequestMapping(value="/cocktaillista", method=RequestMethod.GET)
	public String cocktaillista(Model model) {
		model.addAttribute("cocktailit", cocktailRepository.findByKaytossa(1));
		return "cocktaillista";
	}
	
	@RequestMapping(value="/cocktailit/{id}", method=RequestMethod.GET)
	public String cocktailit(@PathVariable("id") Long cocktailId ,Model model) {
		model.addAttribute("cocktail", cocktailRepository.findByCocktailId(cocktailId).get(0));
		List <Aines> ainekset = new ArrayList<>();
		for(Aines aines: ainesRepository.findByCocktail(cocktailRepository.findByCocktailId(cocktailId).get(0))) {
			if(aines.getKaytossa()==1) {
				ainekset.add(aines);
			}
		}
		model.addAttribute("aines", ainekset);		
		return "cocktailit";
	}
	
	@RequestMapping(value="/lisaacocktail")
	public String lisaacocktail(Model model) {		
		model.addAttribute("cocktail", new Cocktail());
		model.addAttribute("jaa", jaaRepository.findAll());
		model.addAttribute("lasi", lasiRepository.findAll());		
		return "lisaacocktail";
	}
	
	@RequestMapping(value="/lisaacocktail", method=RequestMethod.POST)
	public String lisaacocktail(Cocktail cocktail, Model model) {
			cocktail.setKaytossa(1);
			cocktailRepository.save(cocktail);
			Cocktail haku = cocktailRepository.findByNimi(cocktail.getNimi()).get(0);
			long id = haku.getCocktailId();
			return "redirect:/cocktailit/"+id+"";		
	}
	
	@RequestMapping(value="/lisaaraakaaine/{id}", method=RequestMethod.GET)
	public String lisaaRaakaaine(@PathVariable("id") Long cocktailId, Model model) {					
			model.addAttribute("cocktail",cocktailRepository.findOne(cocktailId));
			model.addAttribute("aines", new Aines());
			model.addAttribute("tyyppi", tyyppiRepository.findByYksikkoLuokka("mittayksikko"));			
			model.addAttribute("ainesosa", ainesosaRepository.findAll());			
			return "lisaaraakaaine";				
	}
	
	@RequestMapping(value="/lisaaraakaaine/lisaaraakaaine", method=RequestMethod.POST)
	public String tallennaRaakaaine(Aines aines) {
		aines.setKaytossa(1);
		long id = aines.getCocktail().getCocktailId();
		ainesRepository.save(aines);		
		return "redirect:/cocktailit/"+id+"";
	}
	
	@RequestMapping(value="/lisaa-ainesosa")
	public String lisaaAinesosa(Model model) {
		model.addAttribute("ainesosa", new Ainesosa());
		model.addAttribute("tyyppi", tyyppiRepository.findByYksikkoLuokka("ainesosa"));			
		return "lisaa-ainesosa";
	}
	
	@RequestMapping(value="/lisaa-ainesosa", method=RequestMethod.POST)
	public String tallennaAinesosa(Ainesosa ainesosa) {
		ainesosaRepository.save(ainesosa);	
		return "redirect:/cocktaillista";
	}
	
	@RequestMapping(value="/poistacocktail/{id}", method=RequestMethod.GET)
	public String poistacocktail(@PathVariable("id") Long cocktailId) {
		Cocktail cocktail = cocktailRepository.findOne(cocktailId);
		cocktail.setKaytossa(0);
		for(Aines aines: ainesRepository.findByCocktail(cocktail)) {
			aines.setKaytossa(0);
			ainesRepository.save(aines);
		}
		cocktailRepository.save(cocktail);		
		return "redirect:/cocktaillista";
	}
	
	@RequestMapping(value="/muutacocktail/{id}", method=RequestMethod.GET)
	public String muutaCocktail(@PathVariable("id") Long cocktailId, Model model) {
		model.addAttribute("cocktail", cocktailRepository.findOne(cocktailId));
		model.addAttribute("jaa", jaaRepository.findAll());
		model.addAttribute("lasi", lasiRepository.findAll());		
		return "muutacocktail";
	}
	
	@RequestMapping(value="/muutacocktail/muutacocktail", method=RequestMethod.POST)
	public String muutaCocktail(Cocktail cocktail) {
		cocktailRepository.save(cocktail);
		return "redirect:/cocktailit/"+cocktail.getCocktailId()+"";
	}
	
	@RequestMapping(value="/poistaraakaaine/{id}", method=RequestMethod.GET)
	public String poistaAines(@PathVariable("id") Long ainesId) {
		Aines aines = ainesRepository.findOne(ainesId);
		long id = aines.getCocktail().getCocktailId();
		aines.setKaytossa(0);
		ainesRepository.save(aines);
		return "redirect:/cocktailit/"+id+"";		
	}
	
	@RequestMapping(value="/muutaraakaaine/{id}", method=RequestMethod.GET)
	public String muutaAines(@PathVariable("id") Long ainesId, Model model) {
		Aines aines = ainesRepository.findOne(ainesId);
		model.addAttribute("cocktail", cocktailRepository.findOne(aines.getCocktail().getCocktailId()));
		model.addAttribute(aines);
		model.addAttribute("tyyppi", tyyppiRepository.findByYksikkoLuokka("mittayksikko"));			
		model.addAttribute("ainesosa", ainesosaRepository.findAll());		
		return "muutaraakaaine";
	}
	
	@RequestMapping(value="/muutaraakaaine/muutaraakaaine", method=RequestMethod.POST)
	public String muutaAines(Aines aines) {
		long id = aines.getCocktail().getCocktailId();
		ainesRepository.save(aines);
		return "redirect:/cocktailit/"+id+"";
		
	}
}
