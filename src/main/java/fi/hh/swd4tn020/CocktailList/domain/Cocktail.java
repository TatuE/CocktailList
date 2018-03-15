package fi.hh.swd4tn020.CocktailList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cocktail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cocktailId;
	private String nimi;
	private double hinta;
	private int kaytossa;
	
	@ManyToOne
	private Jaa jaa;
	
	@ManyToOne
	private Lasi lasi;

	public Cocktail() {
		super();
	
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

	@Override
	public String toString() {
		return "Cocktail [cocktailId=" + cocktailId + ", nimi=" + nimi + ", hinta=" + hinta + ", kaytossa=" + kaytossa
				+ ", jaa=" + this.getJaa() + ", lasi=" + this.getLasi() + "]";
	}
	
	
	
	
	

}
