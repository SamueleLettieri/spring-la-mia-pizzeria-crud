package com.example.springlamiapizzeriacrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springlamiapizzeriacrud.model.Pizza;
import com.example.springlamiapizzeriacrud.repository.PizzaRepository;

@Controller
@RequestMapping("/")
public class PizzaController {

	private @Autowired PizzaRepository pizzaRepository;
	
	@GetMapping
	public String index(Model model) {
		List<Pizza> elencoPizze = pizzaRepository.findAll();
		model.addAttribute("elencoPizze", elencoPizze);
		return"pizze/index";
	}
}
