package com.chanoyfran.meli.twitter.application;

import com.chanoyfran.meli.shared.authentication.application.AuthenticatedUser;
import com.chanoyfran.meli.twitter.domain.user.aggregate.User;
import com.chanoyfran.meli.twitter.domain.user.repository.UserRepository;
import com.chanoyfran.meli.twitter.domain.user.service.UserReader;
import com.chanoyfran.meli.twitter.domain.user.service.UserSynchronizer;
import com.chanoyfran.meli.twitter.domain.user.vo.UserAddressToUpdate;
import com.chanoyfran.meli.twitter.domain.user.vo.UserEmail;
import com.chanoyfran.meli.twitter.infrastructure.secondary.service.kinde.KindeService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersApplicationService {

  private final UserSynchronizer userSynchronizer;
  private final UserReader userReader;

  public UsersApplicationService(UserRepository userRepository, KindeService kindeService) {
    this.userSynchronizer = new UserSynchronizer(userRepository, kindeService);
    this.userReader = new UserReader(userRepository);
  }

  @Transactional
  public User getAuthenticatedUserWithSync(Jwt jwtToken, boolean forceResync) {
    userSynchronizer.syncWithIdp(jwtToken, forceResync);
    return userReader.getByEmail(new UserEmail(AuthenticatedUser.username().get()))
      .orElseThrow();
  }

  @Transactional(readOnly = true)
  public User getAuthenticatedUser() {
    return userReader.getByEmail(new UserEmail(AuthenticatedUser.username().get()))
      .orElseThrow();
  }

  @Transactional
  public void updateAddress(UserAddressToUpdate userAddressToUpdate) {
    userSynchronizer.updateAddress(userAddressToUpdate);
  }
}
