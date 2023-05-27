package com.training.hplusspringboot.controllers;

import com.training.hplusspringboot.beans.Product;
import com.training.hplusspringboot.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    private final ProductRepository productRepository;

    public SearchController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        System.out.println("insearch controller");
        System.out.println("search criteria " + search);
        List<Product> products = productRepository.searchByName(search);
        model.addAttribute("products", products);
        return "search";
    }
}
