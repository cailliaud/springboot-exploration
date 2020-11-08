package fr.cailliaud.springboot.controller;

import fr.cailliaud.springboot.dto.Champion;
import fr.cailliaud.springboot.service.ChampionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/api/champions")
@RequiredArgsConstructor
@Validated
public class ChampionController {

  private final ChampionService championService;

  @GetMapping("/{name}")
  public Champion findChampionByName(@PathVariable String name) {
    return championService.findByName(name);
  }

  @PostMapping
  public Champion createChampion(@RequestBody @Valid Champion champion) {
    return championService.createChampion(champion);
  }
}
