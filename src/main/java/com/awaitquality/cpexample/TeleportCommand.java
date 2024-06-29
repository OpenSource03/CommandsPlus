package com.awaitquality.cpexample;

import com.awaitquality.commandsplus.CommandInterface;
import com.awaitquality.commandsplus.command.Context;

public class TeleportCommand implements CommandInterface {
  @Override
  public void execute(Context data) {
    var player = data.getPlayerSender();

    var to = data.getPlayer(0).getDynamic();

    if (to == null) {
      player.sendMessage("Player not found");
      return;
    }

    player.teleport(to);
  }
}
