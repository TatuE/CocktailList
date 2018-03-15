package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lasi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long lasiId;
	private String lasiMalli;
	
	@OneToMany
	private List<Cocktail> cocktails;	
	
	
	public Lasi() {
		super();		
	}

	public Lasi(String lasiMalli) {
		super();
		this.lasiMalli = lasiMalli;
	}

	public long getLasiId() {
		return lasiId;
	}


	public void setLasiId(long lasiId) {
		this.lasiId = lasiId;
	}


	public String getLasiMalli() {
		return lasiMalli;
	}


	public void setLasiMalli(String lasiMalli) {
		this.lasiMalli = lasiMalli;
	}

	public List<Cocktail> getCocktails() {
		return cocktails;
	}

	public void setCocktails(List<Cocktail> cocktails) {
		this.cocktails = cocktails;
	}

	@Override
	public String toString() {
		return "Lasi [lasiId=" + lasiId + ", lasiMalli=" + lasiMalli + "]";
	}

}
