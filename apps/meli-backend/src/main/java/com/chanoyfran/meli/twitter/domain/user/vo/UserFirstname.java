package com.chanoyfran.meli.twitter.domain.user.vo;

import com.chanoyfran.meli.shared.error.domain.Assert;

public record UserFirstname(String value) {

  public UserFirstname {
    Assert.field("value", value).maxLength(255);
  }
}
