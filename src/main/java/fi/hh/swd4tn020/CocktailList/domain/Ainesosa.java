package fi.hh.swd4tn020.CocktailList.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ainesosa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ainesosaId;
	
	@NotEmpty(message="Ainesosan nimi ei saa olla tyhjä!")
	private String ainesosaNimi;	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "tyyppiId")
	private Tyyppi tyyppi;
	
	@OneToMany
	private List<Aines> ainekset;

	public Ainesosa() {
		super();
	}

	public Ainesosa(String ainesosaNimi) {
		super();
		this.ainesosaNimi = ainesosaNimi;
	}

	public Ainesosa(String ainesosaNimi, Tyyppi tyyppi) {
		super();
		this.ainesosaNimi = ainesosaNimi;
		this.tyyppi = tyyppi;
	}

	public long getAinesosaId() {
		return ainesosaId;
	}

	public void setAinesosaId(long ainesosaId) {
		this.ainesosaId = ainesosaId;
	}

	public String getAinesosaNimi() {
		return ainesosaNimi;
	}

	public void setAinesosaNimi(String ainesosaNimi) {
		this.ainesosaNimi = ainesosaNimi;
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
		return "Ainesosa [ainesosaId=" + ainesosaId + ", ainesosaNimi=" + ainesosaNimi + ", tyyppi=" + this.getTyyppi() + "]";
	}
	
	
	
	
	
	
	
	

}
