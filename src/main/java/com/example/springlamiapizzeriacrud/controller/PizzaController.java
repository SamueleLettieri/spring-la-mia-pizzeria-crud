package com.example.springlamiapizzeriacrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springlamiapizzeriacrud.model.Pizza;
import com.example.springlamiapizzeriacrud.repository.PizzaRepository;

@Controller
@RequestMapping("/")
public class PizzaController {

	private @Autowired PizzaRepository pizzaRepository;
	
	@GetMapping
	public String index(@RequestParam(name="keyword", required = false) String keyword, Model model) {
		List<Pizza> elencoPizze;
		
		if (keyword!=null && !keyword.isEmpty()) {
			elencoPizze = pizzaRepository.findByNameLike("%"+keyword+"%");
		} else {
			elencoPizze = pizzaRepository.findAll();
		}

		model.addAttribute("elencoPizze", elencoPizze);
		return"pizze/index";
	}
	
	
		
	@GetMapping("pizze/{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		Pizza pizza = pizzaRepository.getReferenceById(id);
		model.addAttribute("pizza", pizza);
		return "pizze/detail";
	}

}
