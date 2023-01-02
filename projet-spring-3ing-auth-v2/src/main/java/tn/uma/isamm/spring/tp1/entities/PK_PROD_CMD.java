package tn.uma.isamm.spring.tp1.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;


public class PK_PROD_CMD implements Serializable{
	
	private Produit produit;
	private Commande commande;

	public PK_PROD_CMD() {
		// TODO Auto-generated constructor stub
	}

	public PK_PROD_CMD(Produit produit, Commande commande) {
		super();
		this.produit = produit;
		this.commande = commande;
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
