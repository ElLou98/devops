package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull private Long idFacture;
	@NonNull private float montantRemise;
	@NonNull private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateCreationFacture;
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModificationFacture;
	private Boolean archivee;
	@OneToMany(mappedBy = "facture")
	private Set<DetailFacture> detailsFacture;
    @ManyToOne
    @JsonIgnore
    private Fournisseur fournisseur;
    @OneToMany(mappedBy="facture")
    @JsonIgnore
    private Set<Reglement> reglements;
	public Facture( @NonNull float montantRemise, @NonNull float montantFacture) {
		super();
	
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
	}
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public float getMontantRemise() {
		return montantRemise;
	}
	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}
	public float getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(float montantFacture) {
		this.montantFacture = montantFacture;
	}
	
	


	
}
