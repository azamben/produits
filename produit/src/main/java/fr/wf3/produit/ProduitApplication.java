package fr.wf3.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.wf3.produit.model.Produit;
import fr.wf3.produit.repository.ProduitRepository;



@SpringBootApplication
public class ProduitApplication implements CommandLineRunner {
@Autowired
	private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProduitApplication.class, args);
		
		
		
	}
	@Override
	public void run(String... args) throws Exception {
		/*produitRepository.save(new Produit("PC", "ASUS",900));
		produitRepository.save(new Produit("PC", "Delle",700));
		produitRepository.save(new Produit("IMPREMENT", "ASUS",900));
	
	*/}
	

}
