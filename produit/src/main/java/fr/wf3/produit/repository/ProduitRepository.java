package fr.wf3.produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.wf3.produit.model.Produit;
//interface de type produit avec type Long de son ID cle primaire
//pas obligation de annotation repository, exp SimpleRespo
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
}