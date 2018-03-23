package fi.hh.swd4tn020.CocktailList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.swd4tn020.CocktailList.domain.Aines;
import fi.hh.swd4tn020.CocktailList.domain.AinesRepository;
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
		model.addAttribute("cocktailit", cocktailRepository.findAll());
		return "cocktaillista";
	}
	
	@RequestMapping(value="/cocktailit/{id}", method=RequestMethod.GET)
	public String cocktailit(@PathVariable("id") Long cocktailId ,Model model) {
		model.addAttribute("cocktaili", cocktailRepository.findOne(cocktailId));
		model.addAttribute("aines", ainesRepository.findByCocktail(cocktailRepository.findOne(cocktailId)));
		model.addAttribute("aines1", ainesRepository.findAll());
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
				
			cocktailRepository.save(cocktail);			
			return "redirect:/cocktaillista";		
	}
	
	@RequestMapping(value="/lisaaraakaaine")
	public String lisaaRaakaaine(Model model) {					
			model.addAttribute("cocktail",cocktailRepository.findAll());
			model.addAttribute("aines", new Aines());
			model.addAttribute("tyyppi", tyyppiRepository.findAll());
			model.addAttribute("ainesosa", ainesosaRepository.findAll());			
			return "lisaaraakaaine";	
				
	}
	
	@RequestMapping(value="/lisaaraakaaine", method=RequestMethod.POST)
	public String tallennaRaakaaine(Aines aines) {
		long id = aines.getCocktail().getCocktailId();
		ainesRepository.save(aines);		
		return "redirect:/cocktailit/"+id+"";
	}

}
