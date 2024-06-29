package com.awaitquality.cpexample;

import com.awaitquality.commandsplus.CommandsPlusExecutor;
import com.awaitquality.commandsplus.dynamic.PlayerDynamic;
import org.bukkit.entity.Player;

public class Commands extends CommandsPlusExecutor {

  /**
   * Example implementation of a CommandsPlusExecutor.
   */
  public Commands() {
    addCommand("tp", (ctx) -> ctx.getPlayerSender().sendMessage("Not enough args..."))
        .argument(new PlayerDynamic(), new TeleportCommand());

    addCommand("gensplus", (ctx) -> {
      Player player = ctx.getPlayerSender();
      player.sendMessage("GensPlus v1.0.0");
    });
  }

}
