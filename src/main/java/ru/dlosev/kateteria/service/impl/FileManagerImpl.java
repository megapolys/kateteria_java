package ru.dlosev.kateteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.dlosev.kateteria.exceptions.ReadFileException;
import ru.dlosev.kateteria.model.ImagePathDto;
import ru.dlosev.kateteria.properties.ImgProperties;
import ru.dlosev.kateteria.service.FileManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileManagerImpl implements FileManager {

	private final ImgProperties imgProperties;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImagePathDto getImagesByUuid(UUID uuid) {
		String sPath = null;
		List<String> lPaths = new ArrayList<>();
		File folder;
		try {
			folder = new ClassPathResource(imgProperties.getPath() + "/" + uuid.toString()).getFile();
		} catch (IOException e) {
			throw ReadFileException.exception(e);
		}
		File[] files = folder.listFiles();
		if (files == null) {
			throw ReadFileException.byFolderEmpty(uuid);
		}
		for (File file : files) {
			if (file.isFile() && file.getPath().endsWith(imgProperties.getExtension())) {
				if (file.getPath().endsWith(imgProperties.getSmallPostfix() + imgProperties.getExtension())) {
					sPath = getLocalPath(uuid, file);
				}
				if (file.getPath().endsWith(imgProperties.getLargePostfix() + imgProperties.getExtension())) {
					lPaths.add(getLocalPath(uuid, file));
				}
			}
		}
		if (sPath == null) {
			throw ReadFileException.bySPathNotFound(uuid);
		}
//		if (lPaths.isEmpty()) {
//			throw ReadFileException.byLPathNotFound(uuid);
//		}
		return ImagePathDto.builder()
			.sPath(sPath)
			.lPaths(lPaths)
			.build();
	}

	private String getLocalPath(UUID uuid, File file) {
		return imgProperties.getPath() + "/" + uuid + "/" + file.getName();
	}
}
