package ru.dlosev.kateteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dlosev.kateteria.model.entity.CakeGroupEntity;

public interface CakeGroupRepository extends JpaRepository<CakeGroupEntity, Long> {

}
