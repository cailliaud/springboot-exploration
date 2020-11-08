package fr.cailliaud.springboot.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReferenceGenerator {

  public String generateReference(@NonNull String prefix) {
    UUID uuid = UUID.randomUUID();
    return String.format("%s-%s", prefix, uuid.toString());
  }
}
