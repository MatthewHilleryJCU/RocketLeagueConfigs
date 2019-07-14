package ProjectSquishy.utils.IO;

import ProjectSquishy.models.Player;

import java.util.Map;

public class PlayerDataController {

    public static void print(Map<String, Player> players) {
        for (Map.Entry<String, Player> player : players.entrySet()) {

            System.out.println(player.getKey());
            if (player.getValue().getDeadzoneSettings() != null) {
                System.out.println(player.getValue().getDeadzoneSettings().toString());
            } else {
                System.out.println("No deadzone data! ");
            }
            if (player.getValue().getCameraSettings() != null) {
                System.out.println(player.getValue().getCameraSettings().toString());
            } else {
                System.out.println("No camera settings data!");
            }

            if (player.getValue().getControlSettings() != null) {
                System.out.println(player.getValue().getControlSettings().toString());
            } else {
                System.out.println("No controls settings data!");
            }
            System.out.println("______________________________");
        }
    }
}
