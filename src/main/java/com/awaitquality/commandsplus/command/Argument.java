package com.awaitquality.commandsplus.command;

import com.awaitquality.commandsplus.CommandInterface;
import com.awaitquality.commandsplus.dynamic.Dynamic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Argument {

  @Setter
  private List<Argument> nextArguments = new ArrayList<>();

  private Consumer<Context> function;

  @Setter
  private Dynamic<?> dynamic;

  public Argument(String command) {
    this.dynamic = new Dynamic<>(command);
  }

  public Argument(Dynamic<?> argument) {
    this.dynamic = argument;
  }

  public Argument(String command, Consumer<Context> function) {
    this.dynamic = new Dynamic<>(command);
    this.function = function;
  }

  public Argument(String command, CommandInterface commandInterface) {
    this.dynamic = new Dynamic<>(command);
    this.function = commandInterface::execute;
  }

  public Argument(Dynamic<?> argument, Consumer<Context> function) {
    this.dynamic = argument;
    this.function = function;
  }

  public Argument(Dynamic<?> argument, CommandInterface commandInterface) {
    this.dynamic = argument;
    this.function = commandInterface::execute;
  }

  public Argument argument(Argument... node) {
    Collections.addAll(nextArguments, node);
    return this;
  }

  public Argument argument(String command) {
    nextArguments.add(new Argument(command));
    return this;
  }

  public Argument argument(Dynamic<?> argument) {
    nextArguments.add(new Argument(argument));
    return this;
  }

  public Argument argument(String command, Consumer<Context> function) {
    nextArguments.add(new Argument(command, function));
    return this;
  }

  public Argument argument(String command, CommandInterface commandInterface) {
    nextArguments.add(new Argument(command, commandInterface));
    return this;
  }

  public Argument argument(Dynamic<?> argument, Consumer<Context> function) {
    nextArguments.add(new Argument(argument, function));
    return this;
  }

  public Argument argument(Dynamic<?> argument, CommandInterface commandInterface) {
    nextArguments.add(new Argument(argument, commandInterface));
    return this;
  }

  public Argument setFunction(Consumer<Context> function) {
    this.function = function;
    return this;
  }

  public Argument setFunction(CommandInterface commandInterface) {
    this.function = commandInterface::execute;
    return this;
  }

  public Argument getDynamic(String arg) {
    return nextArguments.stream()
        .filter(argument -> argument.getDynamic().toString().equalsIgnoreCase(arg))
        .findFirst()
        .orElse(null);
  }

}
