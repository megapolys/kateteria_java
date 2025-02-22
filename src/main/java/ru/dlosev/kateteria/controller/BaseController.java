package ru.dlosev.kateteria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

	@GetMapping("/base")
	public String getMain(Model model) {
		model.addAttribute("activePage", "base");
		return "base";
	}
}
