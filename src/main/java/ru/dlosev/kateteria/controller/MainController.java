package ru.dlosev.kateteria.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dlosev.kateteria.service.CakeService;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final CakeService cakeService;

	@GetMapping("/base")
	public String getBase(Model model) {
		return "base";
	}

	@GetMapping("/cakes")
	public String getCakes(Model model) {
		model.addAttribute("cakes", cakeService.getAllCakes());
		return "cakes";
	}
}
