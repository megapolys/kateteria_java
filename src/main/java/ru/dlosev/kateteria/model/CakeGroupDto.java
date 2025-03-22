package ru.dlosev.kateteria.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CakeGroupDto {

	/**
	 * Идентификатор
	 */
	Long id;

	/**
	 * Наименование группы
	 */
	String name;

	/**
	 * Список изделий
	 */
	List<CakeDto> cakes;
}
