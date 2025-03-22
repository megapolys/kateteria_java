package ru.dlosev.kateteria.exceptions;

import java.util.UUID;

public class ReadFileException extends RuntimeException {

	public ReadFileException(String message) {
		super(message);
	}

	public ReadFileException(String message, Throwable cause) {
		super(message, cause);
	}

	public static ReadFileException exception(Throwable cause) {
		return new ReadFileException("Ошибка при чтении файла", cause);
	}

	public static ReadFileException byFolderEmpty(UUID uuid) {
		return new ReadFileException(String.format("Папка с изображениями пустая для uuid %s", uuid));
	}

	public static ReadFileException bySPathNotFound(UUID uuid) {
		return new ReadFileException(String.format("Не найдена маленькое изображение для uuid %s", uuid));
	}

	public static ReadFileException byLPathNotFound(UUID uuid) {
		return new ReadFileException(String.format("Не найдено ни одного большого изображения для uuid %s", uuid));
	}
}
