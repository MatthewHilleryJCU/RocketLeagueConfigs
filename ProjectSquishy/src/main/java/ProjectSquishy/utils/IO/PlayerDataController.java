package ProjectSquishy.utils.IO;

import ProjectSquishy.models.Player;

import java.util.Map;

public class PlayerDataController {

    public void printAllPlayers(Map<String, Player> players) {
        for (Map.Entry<String, Player> player : players.entrySet()) {
           printPlayer(player.getValue());
        }
    }

    public void printPlayer(Player player) {
        System.out.println(player.getPlayerName());
        if (player.getDeadzoneSettings() != null) {
            System.out.println(player.getDeadzoneSettings().toString());
        } else {
            System.out.println("No deadzone data! ");
        }
        if (player.getCameraSettings() != null) {
            System.out.println(player.getCameraSettings().toString());
        } else {
            System.out.println("No camera settings data!");
        }

        if (player.getControlSettings() != null) {
            System.out.println(player.getControlSettings().toString());
        } else {
            System.out.println("No controls settings data!");
        }
        System.out.println("______________________________");
    }
}
