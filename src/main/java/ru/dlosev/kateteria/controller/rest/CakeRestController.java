package ru.dlosev.kateteria.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dlosev.kateteria.model.CakeGroupDto;
import ru.dlosev.kateteria.service.CakeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CakeRestController {

	private final CakeService cakeService;

	/**
	 * Получение всех сгруппированных карточек изделий
	 *
	 * @return список сгруппированных изделий
	 */
	@GetMapping("api/cake")
	public List<CakeGroupDto> getAllCakes() {
		return cakeService.getAllCakes();
	}
}
