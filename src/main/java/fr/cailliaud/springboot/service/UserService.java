package fr.cailliaud.springboot.service;

import fr.cailliaud.springboot.entity.UserEntity;
import fr.cailliaud.springboot.repository.UserRepository;
import fr.cailliaud.springboot.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("java:S1130")
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity =
        userRepository
            .findByUsername(username)
            .orElseThrow(
                () ->
                    new UsernameNotFoundException(
                        String.format("L'utilisateur %s n'existe pas.", username)));

    return new CustomUserDetails(userEntity);
  }
}
