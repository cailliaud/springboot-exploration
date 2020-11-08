package fr.cailliaud.springboot.mapper;

import fr.cailliaud.springboot.dto.Champion;
import fr.cailliaud.springboot.entity.ChampionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChampionMapper {

  Champion championEntityToChampion(ChampionEntity championEntity);

  ChampionEntity championToChampionEntity(Champion champion);
}
