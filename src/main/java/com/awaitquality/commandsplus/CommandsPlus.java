package com.awaitquality.commandsplus;

import com.awaitquality.commandsplus.command.Argument;
import com.awaitquality.commandsplus.command.CommandPlus;
import com.awaitquality.commandsplus.command.Context;
import com.awaitquality.commandsplus.dynamic.BooleanDynamic;
import com.awaitquality.commandsplus.dynamic.CharDynamic;
import com.awaitquality.commandsplus.dynamic.Dynamic;
import com.awaitquality.commandsplus.dynamic.FloatDynamic;
import com.awaitquality.commandsplus.dynamic.LongDynamic;
import com.awaitquality.commandsplus.dynamic.PlayerDynamic;
import com.awaitquality.commandsplus.dynamic.WorldDynamic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandsPlus {

  private final List<CommandPlus> commands;

  public CommandsPlus() {
    this.commands = new ArrayList<>();
  }

  public void addCommand(CommandPlus... command) {
    Collections.addAll(commands, command);
  }

  public CommandPlus getCommandByName(String name) {
    for (CommandPlus command : commands) {
      if (command.getName().equalsIgnoreCase(name)) {
        return command;
      }
    }
    return null;
  }

  public void execute(@NotNull CommandSender commandSender, @NotNull Command command,
                      @NotNull String s, @NotNull String[] strings) {
    Argument argument = getCommandByName(command.getName());

    List<Dynamic<?>> dynamics = new ArrayList<>();

    for (String arg : strings) {
      argument = argument.getDynamic(arg);

      Dynamic<?> dynamic = argument.getDynamic();

      if (dynamic == null) {
        dynamics.add(null);
      }

      if (dynamic instanceof PlayerDynamic) {
        PlayerDynamic playerDynamic = (PlayerDynamic) dynamic;

        playerDynamic.setDynamic(Bukkit.getPlayer(arg));
        dynamics.add(playerDynamic);
      }

      if (dynamic instanceof BooleanDynamic) {
        BooleanDynamic booleanDynamic = (BooleanDynamic) dynamic;

        booleanDynamic.setDynamic(Boolean.parseBoolean(arg));
        dynamics.add(booleanDynamic);
      }

      if (dynamic instanceof LongDynamic) {
        LongDynamic longDynamic = (LongDynamic) dynamic;

        longDynamic.setDynamic(Long.parseLong(arg));
        dynamics.add(longDynamic);
      }

      if (dynamic instanceof FloatDynamic) {
        FloatDynamic floatDynamic = (FloatDynamic) dynamic;

        floatDynamic.setDynamic(Float.parseFloat(arg));
        dynamics.add(floatDynamic);
      }

      if (dynamic instanceof CharDynamic) {
        CharDynamic charDynamic = (CharDynamic) dynamic;

        charDynamic.setDynamic(arg.charAt(0));
        dynamics.add(charDynamic);
      }

      if (dynamic instanceof WorldDynamic) {
        WorldDynamic worldDynamic = (WorldDynamic) dynamic;

        worldDynamic.setDynamic(Bukkit.getWorld(arg));
        dynamics.add(worldDynamic);
      }

      dynamics.add(new Dynamic<>(arg));
    }

    argument.getFunction().accept(new Context(commandSender, dynamics));
  }

}
