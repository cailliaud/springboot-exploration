package fr.cailliaud.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Champion {

  private String reference;

  @NotEmpty(message = "Le nom du champion est obligatoire.")
  @JsonProperty("nom")
  private String name;

  private String faction;
}
