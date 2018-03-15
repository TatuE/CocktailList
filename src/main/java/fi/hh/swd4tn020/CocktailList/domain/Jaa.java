package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jaa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long jaaId;
	private String jaaMalli;
	
	@OneToMany
	private List<Cocktail> cocktails;	
	
	public Jaa() {
		super();		
	}

	public Jaa(String jaaMalli) {
		super();
		this.jaaMalli = jaaMalli;
	}

	public long getJaaId() {
		return jaaId;
	}

	public void setJaaId(long jaaId) {
		this.jaaId = jaaId;
	}

	public String getJaaMalli() {
		return jaaMalli;
	}

	public void setJaaMalli(String jaaMalli) {
		this.jaaMalli = jaaMalli;
	}

	public List<Cocktail> getCocktails() {
		return cocktails;
	}

	public void setCocktails(List<Cocktail> cocktails) {
		this.cocktails = cocktails;
	}

	@Override
	public String toString() {
		return "Jaa [jaaId=" + jaaId + ", jaaMalli=" + jaaMalli + "]";
	}
}
