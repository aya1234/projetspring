package tn.uma.isamm.spring.tp1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.uma.isamm.spring.tp1.entities.Categorie;


public interface CategorieDAO extends JpaRepository<Categorie, Long>{
	
	Optional<Categorie> findByNomCateg(String nomCateg);
}
