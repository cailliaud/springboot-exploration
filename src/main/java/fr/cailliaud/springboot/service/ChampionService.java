package fr.cailliaud.springboot.service;

import fr.cailliaud.springboot.dto.Champion;
import fr.cailliaud.springboot.entity.ChampionEntity;
import fr.cailliaud.springboot.mapper.ChampionMapper;
import fr.cailliaud.springboot.repository.ChampionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Transactional
@Service
@RequiredArgsConstructor
public class ChampionService {

  private static final String CHAMPION_REFERENCE_PREFIX = "CHP";

  private final ChampionRepository championRepository;
  private final ChampionMapper championMapper;
  private final ReferenceGenerator referenceGenerator;

  @Transactional(readOnly = true)
  public Champion findByName(String name) {

    ChampionEntity championEntity =
        championRepository
            .findByName(name)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Aucun champion trouvé pour le nom %s", name)));
    return championMapper.championEntityToChampion(championEntity);
  }

  public Champion createChampion(Champion champion) {

    championRepository
        .findByName(champion.getName())
        .ifPresent(
            c -> {
              throw new ResponseStatusException(
                  HttpStatus.CONFLICT,
                  String.format("Le champion %s existe déjà", champion.getName()));
            });

    ChampionEntity championEntity = championMapper.championToChampionEntity(champion);
    championEntity.setReference(referenceGenerator.generateReference(CHAMPION_REFERENCE_PREFIX));
    championEntity = championRepository.save(championEntity);
    return championMapper.championEntityToChampion(championEntity);
  }
}
