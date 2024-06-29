package com.awaitquality.commandsplus.dynamic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dynamic<T> {
  private T dynamic;

  public Dynamic() {
    this.dynamic = null;
  }

  public Dynamic(T dynamic) {
    this.dynamic = dynamic;
  }

}
