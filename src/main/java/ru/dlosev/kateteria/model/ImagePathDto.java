package ru.dlosev.kateteria.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ImagePathDto {

	/**
	 * Путь к маленькой картинке
	 */
	String sPath;

	/**
	 * Список путей к большим картинкам
	 */
	List<String> lPaths;
}
