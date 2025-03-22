package ru.dlosev.kateteria.service;

import ru.dlosev.kateteria.model.ImagePathDto;

import java.util.UUID;

public interface FileManager {

	/**
	 * Получение всех изображений по идентификатору
	 *
	 * @param uuid идентификатор изделия
	 *
	 * @return пути к изображениям
	 */
	ImagePathDto getImagesByUuid(UUID uuid);
}
