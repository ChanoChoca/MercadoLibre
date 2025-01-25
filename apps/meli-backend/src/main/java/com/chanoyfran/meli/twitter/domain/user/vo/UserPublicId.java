package com.chanoyfran.meli.twitter.domain.user.vo;

import com.chanoyfran.meli.shared.error.domain.Assert;

import java.util.UUID;

public record UserPublicId(UUID value) {

  public UserPublicId {
    Assert.notNull("value", value);
  }
}
