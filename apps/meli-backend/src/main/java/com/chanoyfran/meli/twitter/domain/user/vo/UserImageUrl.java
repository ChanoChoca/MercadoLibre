package com.chanoyfran.meli.twitter.domain.user.vo;

import com.chanoyfran.meli.shared.error.domain.Assert;

public record UserImageUrl(String value) {

  public UserImageUrl {
    Assert.field("value", value).maxLength(1000);
  }
}
