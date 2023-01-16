package fr.wf3.produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.wf3.produit.model.Produit;
import fr.wf3.produit.service.ProduitService;


// question: @Controller @RestController avec html, Optional et .get() avec le Model, afficher un message si la donnée elle n'estpas 
// "redirect:/api/produits"; écrire url complet

@Controller
@RequestMapping("/api")
public class ProduitController {
	@Autowired
	 ProduitService produitService;
	
	// READ : LIRE LA LIST DES  PRODUITS 
	
		//@RequestMapping(value="/produits", method=RequestMethod.GET)
		@GetMapping("/produits")
		public String  readProduits(Model model, @RequestParam(name="page",defaultValue="0")int page) {
			Page <Produit> pageProduits = produitService.getProduits(page);
		  model.addAttribute("produits", pageProduits.getContent() );
			model.addAttribute("pages", new int [pageProduits.getTotalPages()]);
		  model.addAttribute("currentPage", page);
		  
			return "produits";
		}
	
	// CREATE: UN PRODUIT 
	@GetMapping("/produits/new")
	public String createProduitForm(Model model) {
		Produit produit = new Produit();
		model.addAttribute("produit", produit);
		
		return "create_produit";
	}
	
	// ENVOYER A LA BASE DE DONNEES
	@PostMapping("/produits")
	public String saveProduit(@ModelAttribute("produit") Produit produit) {
		produitService.saveProduit(produit);
		return "redirect:/api/produits";
	}
	/*
	public Produit createProduit(@RequestBody Produit p) {
	 return produitService.createProduit(p);
	}
	*/
	
	
	// READ LIRE UN SEUL  PRODUIT
	
	/*@GetMapping("/produit/{id}")
		public Optional <Produit>readOneProduit(@PathVariable(value = "id")Long id) {
		  return produitService.getOneProduit(id);
		 
		}
		*/
	// FAIRE ATTETION AVEC MEME URL  
	// ATTENTION AUX RESSOURCES DES DONNEES SUR LA BASE DONNEES MEME CHAMPS ET ECRITURE .
	@GetMapping("/produit/{id}")
	public String readOneProduit(@PathVariable  Long id, Model model) {
	  model.addAttribute("produit", produitService.getOneProduit(id));
	  return "produit";
	 
	}
	
	// post avec le buttun submit ou un lien  en clik

	
	// UPDATE METTRE A JOUR PRODUIT
	/*
	@RequestMapping(value="/produit/{id}", method=RequestMethod.PUT)
	 public Produit updateProduit(@PathVariable(value = "id") Long id, 
	@RequestBody Produit produitDetails) {
	 return produitService.updateProduit(id, produitDetails);
	}
	*/
	//METHODE UPDATE
		//1)  chercher un element par  son id à partir de formulaire
		@GetMapping("/produits/edit/{id}")
		public String editProduitrForm(@PathVariable Long id, Model model) {
			model.addAttribute("produit", produitService.getOneProduit(id));
			return "edit_produit";
		}
		//2) ENRIGISTRER ELEMENT MIS A JOUR
		@PostMapping("/produits/{id}")
		public String updateTeacher(@PathVariable Long id,
				@ModelAttribute("produit") Produit produit,
				Model model) {
			Produit existProduit = produitService.getOneProduit(id);
			existProduit.setId(id);
			existProduit.setNom(produit.getNom());
			existProduit.setFiche(produit.getFiche());
			existProduit.setQuantite(produit.getQuantite());
			// SAUVGARDER L'OBJET ENSEIGNANT MIS A JOUR
			produitService.updateProduit(existProduit);
			
			return "redirect:/api/produits";
			
		}
	
	
	
	
	
	// DELETE :SUPPRIMER UN PRODUIT 
		@GetMapping("/produits/{id}")
		public String supprimeProduit(@PathVariable Long id ) {
			produitService.deleteProduit(id);
			return "redirect:/api/produits";
		}
	
		
		/*
	@RequestMapping(value="/produits/{id}", method=RequestMethod.DELETE)
	public void deleteProduits(@PathVariable(value = "id") Long id) {
	produitService.deleteProduit(id);
	}
*/
		
	


}
