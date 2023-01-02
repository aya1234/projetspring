package tn.uma.isamm.spring.tp1.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMMANDES")
public class Commande{
	@Id
	@Column(name="NUM_CMD")
	@GeneratedValue
	private long numCommande;
	@Column(name="DATE_CMD")
	private Date dateCommande;
	@Column(name="ADR_LIVRAISON")
	private String adresseLivraison;
	
	//Relation bidirectionnelle Commande --> Client
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CLIENT" , nullable = true)
	private Client client;
	
	@OneToMany(mappedBy="commande")
	private Set<LigneCommande> lignes = new HashSet<LigneCommande>();

	public Commande() {
		// TODO Auto-generated constructor stub
	}

	public Commande(Date dateCommande, String adresseLivraison) {
		super();
		this.dateCommande = dateCommande;
		this.adresseLivraison = adresseLivraison;
	}	
	
	public Commande(Date dateCommande, String adresseLivraison, Client client) {
		super();
		this.dateCommande = dateCommande;
		this.adresseLivraison = adresseLivraison;
		this.client = client;
	}	

	public long getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(long numCommande) {
		this.numCommande = numCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(Set<LigneCommande> lignes) {
		this.lignes = lignes;
	}
	
	
	
	
}
