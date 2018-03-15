package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ainesosa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ainesosaId;
	private String ainesosa;
	
	@ManyToOne
	private Tyyppi tyyppi;
	
	@OneToMany
	private List<Aines> ainekset;

	public Ainesosa() {
		super();
	}

	public Ainesosa(String ainesosa, Tyyppi tyyppi) {
		super();
		this.ainesosa = ainesosa;
		this.tyyppi = tyyppi;
	}

	public long getAinesosaId() {
		return ainesosaId;
	}

	public void setAinesosaId(long ainesosaId) {
		this.ainesosaId = ainesosaId;
	}

	public String getAinesosa() {
		return ainesosa;
	}

	public void setAinesosa(String ainesosa) {
		this.ainesosa = ainesosa;
	}

	public Tyyppi getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(Tyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}

	public List<Aines> getAinekset() {
		return ainekset;
	}

	public void setAinekset(List<Aines> ainekset) {
		this.ainekset = ainekset;
	}

	@Override
	public String toString() {
		return "Ainesosa [ainesosaId=" + ainesosaId + ", ainesosa=" + ainesosa + ", tyyppi=" + this.getTyyppi() + "]";
	}
	
	
	
	
	
	
	
	

}
