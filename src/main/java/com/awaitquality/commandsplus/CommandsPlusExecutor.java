package com.awaitquality.commandsplus;

import com.awaitquality.commandsplus.command.Argument;
import com.awaitquality.commandsplus.command.CommandPlus;
import com.awaitquality.commandsplus.command.Context;
import java.util.Arrays;
import java.util.function.Consumer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandsPlusExecutor implements CommandExecutor {
  private final CommandsPlus commandsPlus;

  public CommandsPlusExecutor() {
    this(new CommandsPlus());
  }

  public CommandsPlusExecutor(CommandsPlus commandsPlus) {
    this.commandsPlus = commandsPlus;
  }

  public CommandsPlusExecutor addCommand(CommandPlus... command) {
    commandsPlus.addCommand(command);
    return this;
  }

  public CommandsPlusExecutor addCommand(Argument... argument) {
    commandsPlus.addCommand(Arrays.stream(argument).filter(arg -> arg instanceof CommandPlus)
        .map(arg -> (CommandPlus) arg).toArray(CommandPlus[]::new));

    return this;
  }

  public Argument addCommand(String command) {
    CommandPlus commandPlus = new CommandPlus(command);

    commandsPlus.addCommand(commandPlus);

    return commandPlus;
  }

  public Argument addCommand(String command, Consumer<Context> function) {
    CommandPlus commandPlus = new CommandPlus(command, function);

    commandsPlus.addCommand(commandPlus);

    return commandPlus;
  }

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
                           @NotNull String s, @NotNull String[] strings) {
    commandsPlus.execute(commandSender, command, s, strings);

    return true;
  }
}
