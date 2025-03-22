package ru.dlosev.kateteria.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.dlosev.kateteria.model.CakeDto;
import ru.dlosev.kateteria.model.entity.CakeEntity;
import ru.dlosev.kateteria.service.FileManager;

@Component
@RequiredArgsConstructor
public class CakeEntityToCakeDtoConverter implements Converter<CakeEntity, CakeDto> {

	private final FileManager fileManager;

	@Override
	public CakeDto convert(CakeEntity cakeEntity) {
		return CakeDto.builder()
			.id(cakeEntity.getId())
			.imagePath(fileManager.getImagesByUuid(cakeEntity.getUuid()))
			.title(cakeEntity.getTitle())
			.description(cakeEntity.getDescription())
			.cost(cakeEntity.getCost())
			.build();
	}
}
