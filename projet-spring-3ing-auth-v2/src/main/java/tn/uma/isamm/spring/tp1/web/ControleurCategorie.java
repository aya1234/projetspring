package tn.uma.isamm.spring.tp1.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tn.uma.isamm.spring.tp1.entities.Categorie;
import tn.uma.isamm.spring.tp1.entities.Produit;
import tn.uma.isamm.spring.tp1.entities.ProduitAlimentaire;
import tn.uma.isamm.spring.tp1.entities.ProduitCosmetique;
import tn.uma.isamm.spring.tp1.metier.MetierVentes;

@Controller
public class ControleurCategorie {
	
		@Autowired
		private MetierVentes metierVentes;

		

		@RequestMapping("/user/categories")
		public String produits(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
				@RequestParam(name = "size", defaultValue = "2") int size,
				@RequestParam(name = "errorMessage", defaultValue = "") String errorMessage) {
			List<Categorie> listeCategories = metierVentes.getCategories();
			//			if(page == listeProduits.getTotalPages()) {
//				page--;
//				listeProduits = metierVentes.getProduitsPageable(page, size);
//			}
			model.addAttribute("activePage", page);
			model.addAttribute("size", size);
			model.addAttribute("listeCategories", listeCategories);
			return "categories";
		}
		
		 @PostMapping("/user/rechercheCategorieDesig")
		    public String rechercheCategorieDes(String designation, Model model) {
		        Categorie categorie = (Categorie) metierVentes.getCategoriesByDes(designation);
		        boolean etat = true;
		        if (categorie == null)
		            etat = false;
		        else {
		            ArrayList<Categorie> categories = new ArrayList<Categorie>();
		            categories.add(categorie);
		            model.addAttribute("activePage", 0);
		            model.addAttribute("size", 2);
		            model.addAttribute("taillePagination", 0);
		            model.addAttribute("listeCategories", categories);
		            model.addAttribute("etat", etat);
		        }
		        return "categories";
		    }
		
		@GetMapping("/user/detailcategorie")
		public String detailCategorie(long id,Model model) {
				Categorie categorie = metierVentes.getCategorieById(id);
				model.addAttribute("categorie", categorie);	
				return "detailCategorie";
		}
		
		@GetMapping("/admin/supprimercategorie")
		public String supprimerCategorie(Long id, Long activePage, Long nbElements, Long size, RedirectAttributes ra) {
			metierVentes.deleteCategorie(id);
			System.out.println(" ----"+activePage);
			if(activePage>0 && ((nbElements-1)==(size * (activePage))))
				activePage--;
			ra.addAttribute("page", activePage);
			return "redirect:/user/categories";
			
		}
		
		@GetMapping("/admin/ajoutercategorie")
		public String ajoutCategorie(Model model) {		
				model.addAttribute("categorie", new Categorie());	
				return "ajouterCategorie";
		}
		
		@PostMapping("/admin/ajoutercategorie")
		public String enregistrerCategorie(Categorie c, Model model) {		
				metierVentes.saveCategorie(c);
				return "redirect:/user/categories";
		}
		
		@GetMapping("/admin/modifiercategorie")
		public String modifierCategorie(@RequestParam(name="id")Long id, Model model) {	
			Categorie categorie = metierVentes.getCategorieById(id);
			model.addAttribute("categorie",categorie);
			return "modifierCategorie";	
		}
		
		@PostMapping("/admin/modifiercategorie")
		public String modifierCategorie(Categorie c ) {
			metierVentes.saveCategorie(c);
			return "redirect:/user/categories";
		}
		

}
