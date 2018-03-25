package fi.hh.swd4tn020.CocktailList.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kayttaja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="kayttajaId",nullable=false,updatable=false)
	private long kayttajaId;
	
	@Column(name="kayttajaNimi", nullable=false, unique=true)
	private String kayttajaNimi;
	
	@Column(name="salasana", nullable=false)
	private String salasana;
		
	@Column(name="rooli", nullable=false)
	private String rooli;

	public Kayttaja() {
		super();
		
	}

	public Kayttaja(String kayttajaNimi, String salasana, String rooli) {
		super();
		this.kayttajaNimi = kayttajaNimi;
		this.salasana = salasana;		
		this.rooli = rooli;
	}

	public long getKayttajaId() {
		return kayttajaId;
	}

	public void setKayttajaId(long kayttajaId) {
		this.kayttajaId = kayttajaId;
	}

	public String getKayttajaNimi() {
		return kayttajaNimi;
	}

	public void setKayttajaNimi(String kayttajaNimi) {
		this.kayttajaNimi = kayttajaNimi;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}	

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}	
}
