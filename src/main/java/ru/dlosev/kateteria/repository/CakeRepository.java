package ru.dlosev.kateteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dlosev.kateteria.model.entity.CakeEntity;

public interface CakeRepository extends JpaRepository<CakeEntity, Long> {

}
