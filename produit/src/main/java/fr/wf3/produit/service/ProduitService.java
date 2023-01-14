package fr.wf3.produit.service;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import fr.wf3.produit.model.Produit;
import fr.wf3.produit.repository.ProduitRepository;
@Service
public class ProduitService {
	@Autowired
	ProduitRepository produitRepository;
	
	// CRUD
	// CREATE 
	public Produit createProduit(Produit p) {
	 return produitRepository.save(p);
	}
	// chercher une page 
	/*
	public Page <Produit> findByFicheConatins(String mc,Pageable pageable){
		return produitRepository.findAll(PageRequest.of(page, 4));
	}
	*/
	// READ LISTE DES PRODUITS
	public Page<Produit> getProduits( @RequestParam(name="page",defaultValue="0")int page) {
	 return produitRepository.findAll(PageRequest.of(page, 4));
	}
	// READ UN PRODUIT
		public Produit getOneProduit(Long id) {
		 return produitRepository.findById(id).get();
		
		 
		}

	// DELETE
	public void deleteProduit(Long id) {
	produitRepository.deleteById(id);
	}
	// UPDATE
	public Produit updateProduit ( Produit p) {
	
	 
	 return produitRepository.save(p); 
	}
	/*
	// UPDATE
		public Produit updateProduit (Long empId, Produit produitDetails) {
		Produit p = produitRepository.findById(empId).get();
		 p.setNom(produitDetails.getNom());
		 p.setFiche(produitDetails.getFiche());
		 p.setQuantite(produitDetails.getQuantite());
		 
		 return produitRepository.save(p); 
		}
		*/
	
	// save
	public  Produit saveProduit(Produit p) {
		return produitRepository.save(p);
	}
	public ProduitService(ProduitRepository produitRepository) {
		super();
		this.produitRepository = produitRepository;
	}
	public ProduitRepository getProduitRepository() {
		return produitRepository;
	}
	public void setProduitRepository(ProduitRepository produitRepository) {
		this.produitRepository = produitRepository;
	}
	
}
