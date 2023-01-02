package tn.uma.isamm.spring.tp1.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@IdClass(PK_PROD_CMD.class)
@Entity
public class LigneCommande implements Serializable{
	
	private int qte;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_PRODUIT")
	@JsonBackReference
	private Produit produit;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_COMMANDE")
	private Commande commande;

	public LigneCommande() {
		// TODO Auto-generated constructor stub
	}

	public LigneCommande(int qte, Produit produit, Commande commande) {
		super();
		this.qte = qte;
		this.produit = produit;
		this.commande = commande;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
