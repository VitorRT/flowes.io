package br.com.bycoffe.flowes.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.models.Categorie;

@RestController
public class CategorieController {
    
    @GetMapping("/api/v1/categorie")
    public Categorie returnCategorie() {
        return new Categorie(1l, "Do Today 👇", LocalDate.now());
    }
}
