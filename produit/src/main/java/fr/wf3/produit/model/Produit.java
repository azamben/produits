package fr.wf3.produit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id_produit")
	 private Long id;
	 
	 @Column(name="nom_produit")
	 private String nom;
	 
	 @Column(name="fiche_produit")
	 private String fiche;
	 
	 @Column(name="qte_produit")
	 private int quantite;
	 
	
	 
	 public Produit () {
		 
	 }
	 
	public Produit(String nom, String fiche, int quantite) {
		super();
		this.nom = nom;
		this.fiche = fiche;
		this.quantite = quantite;
	}

	public Produit(Long id, String nom, String fiche, int quantite) {
		super();
		this.id = id;
		this.nom = nom;
		this.fiche = fiche;
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getFiche() {
		return fiche;
	}

	public void setFiche(String fiche) {
		this.fiche = fiche;
	}

}
