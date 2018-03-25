package fi.hh.swd4tn020.CocktailList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Aines {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ainesId;
	
	@Min(value=(long) 0.0, message="Määrä ei saa olla negatiivinen")
	private double maara;
	private int kaytossa;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "tyyppiId")
	private Tyyppi tyyppi;	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ainesosaId")
	private Ainesosa ainesosa;	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cocktailId")
	private Cocktail cocktail;

	public Aines(){
		super();
		this.kaytossa=0;
		
	}		
	
	public Aines(double maara, Tyyppi tyyppi, Ainesosa ainesosa) {
		super();		
		this.maara = maara;
		this.tyyppi = tyyppi;
		this.ainesosa = ainesosa;
		this.kaytossa=0;
	}
	
	public Aines(double maara, Tyyppi tyyppi, Ainesosa ainesosa, Cocktail cocktail) {
		super();
		this.maara = maara;
		this.tyyppi = tyyppi;
		this.ainesosa = ainesosa;
		this.cocktail = cocktail;
		this.kaytossa=0;
	}	

	public Aines(double maara, int kaytossa, Tyyppi tyyppi, Ainesosa ainesosa, Cocktail cocktail) {
		super();		
		this.maara = maara;
		this.kaytossa = kaytossa;
		this.tyyppi = tyyppi;
		this.ainesosa = ainesosa;
		this.cocktail = cocktail;
		this.kaytossa= kaytossa;
	}

	public long getAinesId() {
		return ainesId;
	}

	public void setAinesId(long ainesId) {
		this.ainesId = ainesId;
	}

	public double getMaara() {
		return maara;
	}

	public void setMaara(double maara) {
		this.maara = maara;
	}	

	public int getKaytossa() {
		return kaytossa;
	}

	public void setKaytossa(int kaytossa) {
		this.kaytossa = kaytossa;
	}

	public Tyyppi getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(Tyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}

	public Ainesosa getAinesosa() {
		return ainesosa;
	}

	public void setAinesosa(Ainesosa ainesosa) {
		this.ainesosa = ainesosa;
	}	

	public Cocktail getCocktail() {
		return cocktail;
	}

	public void setCocktail(Cocktail cocktail) {
		this.cocktail = cocktail;
	}

	@Override
	public String toString() {
		if(this.getCocktail()!=null) {
			return "Aines [ainesId=" + ainesId + ", maara=" + maara +", kaytossa="+kaytossa+ ", tyyppi=" + this.getTyyppi() + ", ainesosa=" + this.getAinesosa() +", cocktail="+this.getCocktail()+"]";
		}else {
			return "Aines [ainesId=" + ainesId + ", maara=" + maara +", kaytossa="+kaytossa+ ", tyyppi=" + this.getTyyppi() + ", ainesosa=" + this.getAinesosa() +"]";
		}		
	}
	
	
	
	
	

}
