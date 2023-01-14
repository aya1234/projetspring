package tn.uma.isamm.spring.tp1.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import tn.uma.isamm.spring.tp1.entities.AppRole;
import tn.uma.isamm.spring.tp1.entities.AppUser;
import tn.uma.isamm.spring.tp1.entities.Categorie;
import tn.uma.isamm.spring.tp1.entities.Produit;

public interface MetierVentes {
	public List<Produit> getProduits();
	public List<Categorie> getCategories();
	public Categorie getCategoriesByDes(String nom);
	public void saveProduit(Produit p);
	public void saveCategorie(Categorie c);
	public Produit getProduitById(long id);
	public Categorie getCategorieById(long id);
	public Page<Produit> getProduitsPageable(int page, int size);
	public Categorie updateCategorie(Categorie c,long idcat);
	public void deleteProduit(Long id);
	public void deleteCategorie(Long id);
	public AppUser saveAppUser(AppUser appUser);
	public AppRole saveAppRole(AppRole appRole);
	public void addRoleToUser(String login, String nomRole);
	public AppUser getUserByLogin(String login);
	public List<AppUser> getAppUsers();
	public List <Produit> getProduitByCateg(Categorie categorie);
	public List <Produit> findAllByPrixProduit();
	public List <Produit> findAllByDesigProduitAsc();

	
	
	//Page<Produit> getProduitsPageableByDesignation(int page, int size, String mc);
	

	

}
