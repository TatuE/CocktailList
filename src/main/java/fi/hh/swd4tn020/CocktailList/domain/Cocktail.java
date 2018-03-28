package fi.hh.swd4tn020.CocktailList.domain;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cocktail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private long cocktailId;
	
	@NotEmpty(message="Nimi ei saa olla tyhjä!")	
	private String nimi;
	
	@Min(value=(long) 0.0, message="Hinta ei saa olla negatiivinen")	
	private double hinta;
	
	@NotNull
	private int kaytossa;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "jaaId")
	private Jaa jaa;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "lasiId")
	private Lasi lasi;
	
	@OneToMany
	private List<Aines> ainekset;

	public Cocktail() {
		super();
		this.kaytossa=0;	
	}
	
	public Cocktail(String nimi, double hinta, int kaytossa) {
		super();		
		this.nimi = nimi;
		this.hinta = hinta;
		this.kaytossa = kaytossa;		
	}

	public Cocktail(String nimi, double hinta, int kaytossa, Jaa jaa, Lasi lasi) {
		super();		
		this.nimi = nimi;
		this.hinta = hinta;
		this.kaytossa = kaytossa;
		this.jaa = jaa;
		this.lasi = lasi;		
	}

	public long getCocktailId() {
		return cocktailId;
	}

	public void setCocktailId(long cocktailId) {
		this.cocktailId = cocktailId;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public int isKaytossa() {
		return kaytossa;
	}	

	public void setKaytossa(int kaytossa) {
		this.kaytossa = kaytossa;
	}

	public Jaa getJaa() {
		return jaa;
	}

	public void setJaa(Jaa jaa) {
		this.jaa = jaa;
	}

	public Lasi getLasi() {
		return lasi;
	}

	public void setLasi(Lasi lasi) {
		this.lasi = lasi;
	}
	
	public int getKaytossa() {
		return kaytossa;
	}

	public List<Aines> getAinekset() {
		return ainekset;
	}

	public void setAinekset(List<Aines> ainekset) {
		this.ainekset = ainekset;
	}
	
	public void lisaaAines(Aines aines) {
		this.ainekset.add(aines);
	}

	@Override
	public String toString() {
		return "Cocktail [cocktailId=" + cocktailId + ", nimi=" + nimi + ", hinta=" + hinta + ", kaytossa=" + kaytossa
				+ ", jaa=" + this.getJaa() + ", lasi=" + this.getLasi() + "]";
	}
}