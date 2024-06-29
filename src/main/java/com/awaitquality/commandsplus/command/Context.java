package com.awaitquality.commandsplus.command;

import com.awaitquality.commandsplus.dynamic.Dynamic;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
@Getter
public class Context {

  private CommandSender sender;

  private List<Dynamic<?>> args;

  public Player getPlayerSender() {
    if (sender instanceof Player player) {
      return player;
    }

    throw new IllegalStateException("Sender is not a player");
  }

  public ConsoleCommandSender getConsoleSender() {
    if (sender instanceof ConsoleCommandSender console) {
      return console;
    }

    throw new IllegalStateException("Sender is not a console");
  }

  public Dynamic<Player> getPlayer(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof Player player) {
      return new Dynamic<>(player);
    }

    throw new IllegalStateException("Argument is not a player");
  }

  public Dynamic<String> getString(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof String string) {
      return new Dynamic<>(string);
    }

    throw new IllegalStateException("Argument is not a string");
  }

  public Dynamic<Integer> getInteger(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof Integer integer) {
      return new Dynamic<>(integer);
    }

    throw new IllegalStateException("Argument is not an integer");
  }

  public Dynamic<Double> getDouble(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof Double doubleValue) {
      return new Dynamic<>(doubleValue);
    }

    throw new IllegalStateException("Argument is not a double");
  }

  public Dynamic<Boolean> getBoolean(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof Boolean booleanValue) {
      return new Dynamic<>(booleanValue);
    }

    throw new IllegalStateException("Argument is not a boolean");
  }

  public Dynamic<Float> getFloat(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof Float floatValue) {
      return new Dynamic<>(floatValue);
    }

    throw new IllegalStateException("Argument is not a float");
  }

  public Dynamic<Long> getLong(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof Long longValue) {
      return new Dynamic<>(longValue);
    }

    throw new IllegalStateException("Argument is not a long");
  }

  public Dynamic<Short> getShort(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof Short shortValue) {
      return new Dynamic<>(shortValue);
    }

    throw new IllegalStateException("Argument is not a short");
  }

  public Dynamic<Character> getCharacter(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof Character charValue) {
      return new Dynamic<>(charValue);
    }

    throw new IllegalStateException("Argument is not a character");
  }

  public Dynamic<World> getWorld(int index) {
    var arg = args.get(index);

    if (arg.getDynamic() instanceof World world) {
      return new Dynamic<>(world);
    }

    throw new IllegalStateException("Argument is not a world");
  }

  public Dynamic<?> getArg(int index) {
    return args.get(index);
  }
}
