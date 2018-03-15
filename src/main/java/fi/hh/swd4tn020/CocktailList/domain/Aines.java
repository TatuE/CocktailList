package fi.hh.swd4tn020.CocktailList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Aines {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ainesId;
	private double maara;
	
	@ManyToOne
	private Tyyppi tyyppi;
	
	@ManyToOne
	private Ainesosa ainesosa;

	public Aines() {
		super();		
	}

	public Aines(double maara, Tyyppi tyyppi, Ainesosa ainesosa) {
		super();
		this.maara = maara;
		this.tyyppi = tyyppi;
		this.ainesosa = ainesosa;
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

	@Override
	public String toString() {
		return "Aines [ainesId=" + ainesId + ", maara=" + maara + ", tyyppi=" + this.getTyyppi() + ", ainesosa=" + this.getAinesosa() + "]";
	}
	
	
	
	
	

}
