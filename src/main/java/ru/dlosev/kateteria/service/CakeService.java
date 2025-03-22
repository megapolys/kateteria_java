package ru.dlosev.kateteria.service;

import ru.dlosev.kateteria.model.CakeGroupDto;

import java.util.List;

public interface CakeService {

	/**
	 * Получение всех сгруппированных карточек изделий
	 *
	 * @return список сгруппированных изделий
	 */
	List<CakeGroupDto> getAllCakes();
}
