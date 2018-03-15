package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tyyppi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tyyppiId;
	private String tyyppi;
	
	@OneToMany
	private List<Ainesosa> ainesosat;
	
	@OneToMany
	private List<Aines> ainekset;

	public Tyyppi() {
		super();
		
	}

	public Tyyppi(String tyyppi) {
		super();
		this.tyyppi = tyyppi;
		
	}

	public long getTyyppiId() {
		return tyyppiId;
	}

	public void setTyyppiId(long tyyppiId) {
		this.tyyppiId = tyyppiId;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public List<Ainesosa> getAinesosat() {
		return ainesosat;
	}

	public void setAinesosat(List<Ainesosa> ainesosat) {
		this.ainesosat = ainesosat;
	}	

	public List<Aines> getAinekset() {
		return ainekset;
	}

	public void setAinekset(List<Aines> ainekset) {
		this.ainekset = ainekset;
	}

	@Override
	public String toString() {
		return "Tyyppi [tyyppiId=" + tyyppiId + ", tyyppi=" + tyyppi + "]";
	}
	
	
	
	
	

}
