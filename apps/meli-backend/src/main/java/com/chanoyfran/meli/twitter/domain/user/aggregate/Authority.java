package com.chanoyfran.meli.twitter.domain.user.aggregate;

import com.chanoyfran.meli.shared.error.domain.Assert;
import com.chanoyfran.meli.twitter.domain.user.vo.AuthorityName;
import org.jilt.Builder;

@Builder
public class Authority {

  private AuthorityName name;

  public Authority(AuthorityName authorityName) {
    Assert.notNull("name", authorityName);
    this.name = authorityName;
  }

  public AuthorityName getName() {
    return name;
  }
}
