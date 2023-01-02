package tn.uma.isamm.spring.tp1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.uma.isamm.spring.tp1.entities.Categorie;
import tn.uma.isamm.spring.tp1.entities.Produit;

public interface CategorieDAO extends JpaRepository<Categorie, Long>{
	public List<Categorie> findByNomCateg(String nomCateg);
}
