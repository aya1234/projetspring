package tn.uma.isamm.spring.tp1.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.uma.isamm.spring.tp1.entities.Categorie;
import tn.uma.isamm.spring.tp1.entities.Produit;

public interface ProduitDAO extends JpaRepository<Produit, Long> {
	public List<Produit> findByDesigProduitContaining(String mc);
	List<Produit> findByCategorie(Categorie categorie);
	List<Produit> findAllByOrderByPrixProduitDesc();
	List<Produit> findAllByOrderByDesigProduitAsc();
	
}
