package com.chanoyfran.meli.twitter.domain.user.vo;

import com.chanoyfran.meli.shared.error.domain.Assert;

public record UserLastname(String value) {

  public UserLastname {
    Assert.field("value", value).maxLength(255);
  }
}
