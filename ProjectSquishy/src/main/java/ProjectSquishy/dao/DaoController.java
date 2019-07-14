package ProjectSquishy.dao;

import ProjectSquishy.models.Player;
import ProjectSquishy.models.settings.CameraSettings;
import ProjectSquishy.models.settings.ControlSettings;
import ProjectSquishy.models.settings.DeadzoneSettings;

import java.util.Map;

public class DaoController {

    public void addAllPlayers(Map<String, Player> players, GenericDao<Player> playerDao, GenericDao<ControlSettings> controlDao, GenericDao<CameraSettings> cameraDao, GenericDao<DeadzoneSettings> deadzoneDao) {
        for (Map.Entry<String, Player> player : players.entrySet()) {
            if (player.getValue().getDeadzoneSettings() != null && player.getValue().getCameraSettings() != null && player.getValue().getControlSettings() != null) {
                cameraDao.add(player.getValue().getCameraSettings());
                controlDao.add(player.getValue().getControlSettings());
                deadzoneDao.add(player.getValue().getDeadzoneSettings());
                playerDao.add(player.getValue());
            }
        }
    }
}

