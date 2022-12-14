package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SecteurActivite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSecteurActivite;
	private String codeSecteurActivite;
	private String libelleSecteurActivite;
	@ManyToMany(mappedBy="secteurActivites")
	@JsonIgnore
	private Set<Fournisseur> fournisseurs;
	
	public SecteurActivite(String codeSecteurActivite,String libelleSecteurActivite ) {
		super();
		this.codeSecteurActivite = codeSecteurActivite;
		this.libelleSecteurActivite = libelleSecteurActivite;
		
	}
	
	public SecteurActivite(long id, String codeSecteurActivite,String libelleSecteurActivite ) {
		super();
		this.idSecteurActivite = id;
		this.codeSecteurActivite = codeSecteurActivite;
		this.libelleSecteurActivite = libelleSecteurActivite;
		
	}
	
	
	public SecteurActivite() {

	}
	

	
	public Long getidSecteurActivite()

	{
		return this.idSecteurActivite;
	}
	
	public String getlibelleSecteurActivite()

	{
		return this.libelleSecteurActivite;
	}
}