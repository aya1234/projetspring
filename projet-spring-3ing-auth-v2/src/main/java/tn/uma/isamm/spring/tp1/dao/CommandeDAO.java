package tn.uma.isamm.spring.tp1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.uma.isamm.spring.tp1.entities.Commande;

public interface CommandeDAO extends JpaRepository<Commande, Long>{

}
