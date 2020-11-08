package fr.cailliaud.springboot.repository;

import fr.cailliaud.springboot.entity.ChampionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChampionRepository extends JpaRepository<ChampionEntity, Long> {
  Optional<ChampionEntity> findByName(String name);
}
