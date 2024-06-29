package com.awaitquality.commandsplus.command;

import com.awaitquality.commandsplus.CommandInterface;
import com.awaitquality.commandsplus.dynamic.Dynamic;
import java.util.function.Consumer;

public class CommandPlus extends Argument {
  public CommandPlus(String command) {
    super(command);
  }

  public CommandPlus(Dynamic argument) {
    super(argument);
  }

  public CommandPlus(String command, Consumer<Context> function) {
    super(command, function);
  }

  public CommandPlus(String command,
                     CommandInterface commandInterface) {
    super(command, commandInterface);
  }

  public CommandPlus(Dynamic argument, Consumer<Context> function) {
    super(argument, function);
  }

  public CommandPlus(Dynamic argument, CommandInterface commandInterface) {
    super(argument, commandInterface);
  }

  public String getName() {
    return this.getDynamic().toString();
  }

}
