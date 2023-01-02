package tn.uma.isamm.spring.tp1.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Categorie {
	@Id
	private Long codeCateg;
	private String nomCateg;
	
	@OneToMany(mappedBy="categorie", cascade={CascadeType.PERSIST})
	@JsonBackReference
	private Set<Produit> produits = new HashSet<Produit>();
	
	@PreRemove
	private void preRemove() {
		produits.forEach( child -> child.setCategorie(null));
	}
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(Long codeCateg, String nomCateg) {
		super();
		this.codeCateg = codeCateg;
		this.nomCateg = nomCateg;
	}



	public Categorie(Long codeCateg, String nomCateg, Set<Produit> produits) {
		super();
		this.codeCateg = codeCateg;
		this.nomCateg = nomCateg;
		this.produits = produits;
	}

	public Long getCodeCateg() {
		return codeCateg;
	}

	public void setCodeCateg(Long codeCateg) {
		this.codeCateg = codeCateg;
	}

	public String getNomCateg() {
		return nomCateg;
	}

	public void setNomCateg(String nomCateg) {
		this.nomCateg = nomCateg;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
}
