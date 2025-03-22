package ru.dlosev.kateteria.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CakeDto {

	/**
	 * Идентификатор
	 */
	Long id;

	/**
	 * Пути к изображениям
	 */
	ImagePathDto imagePath;

	/**
	 * Название изделия
	 */
	String title;

	/**
	 * Описание изделия
	 */
	String description;

	/**
	 * Стоимость за кг
	 */
	Integer cost;
}
