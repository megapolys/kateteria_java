package ru.dlosev.kateteria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.dlosev.kateteria.model.CakeDto;
import ru.dlosev.kateteria.model.CakeGroupDto;
import ru.dlosev.kateteria.model.entity.CakeEntity;
import ru.dlosev.kateteria.model.entity.CakeGroupEntity;
import ru.dlosev.kateteria.repository.CakeGroupRepository;
import ru.dlosev.kateteria.repository.CakeRepository;
import ru.dlosev.kateteria.service.CakeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CakeServiceImpl implements CakeService {

	private final CakeRepository cakeRepository;
	private final CakeGroupRepository cakeGroupRepository;
	private final ConversionService conversionService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CakeGroupDto> getAllCakes() {
		Map<Long, List<CakeDto>> groupedCakes = cakeRepository.findAll().stream()
			.sorted(Comparator.comparing(CakeEntity::getId))
			.collect(Collectors.groupingBy(
				CakeEntity::getGroupId,
				mapping(cakeEntity -> conversionService.convert(cakeEntity, CakeDto.class), toList())
			));

		return cakeGroupRepository.findAll().stream()
			.sorted(Comparator.comparing(CakeGroupEntity::getId))
			.map(cakeGroup -> CakeGroupDto.builder()
				.id(cakeGroup.getId())
				.name(cakeGroup.getName())
				.cakes(groupedCakes.containsKey(cakeGroup.getId()) ? groupedCakes.get(cakeGroup.getId()) : List.of())
				.build())
			.toList();
	}
}
