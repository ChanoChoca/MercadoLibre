package com.chanoyfran.meli.twitter.domain.user.vo;

import com.chanoyfran.meli.shared.error.domain.Assert;

public record AuthorityName(String name) {

  public AuthorityName {
    Assert.field("name", name).notNull();
  }
}
