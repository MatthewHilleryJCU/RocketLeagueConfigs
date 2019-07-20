package ProjectSquishy.dao;

import ProjectSquishy.models.Player;
import ProjectSquishy.models.settings.CameraSettings;
import ProjectSquishy.models.settings.ControlSettings;
import ProjectSquishy.models.settings.DeadzoneSettings;
import org.apache.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DaoController {

    private List<ControlSettings> controlSettingsSet = new ArrayList<>();
    private List<CameraSettings> cameraSettingsSet = new ArrayList<>();
    private List<DeadzoneSettings> deadzoneSettingsSet = new ArrayList<>();
    private List<Player> playerSet = new ArrayList<>();
    private final Logger logger = Logger.getLogger(DaoController.class);

    public void addAllPlayers(Map<String, Player> players, GenericDao<Player> playerDao, GenericDao<ControlSettings> controlDao, GenericDao<CameraSettings> cameraDao, GenericDao<DeadzoneSettings> deadzoneDao) {
        for (Map.Entry<String, Player> player : players.entrySet()) {

            if (player.getValue().getControlSettings() != null) {
                if (!controlSettingsSet.contains(player.getValue().getControlSettings())){
                    controlSettingsSet.add(player.getValue().getControlSettings());
                }else {
                    for (ControlSettings setting : controlSettingsSet) {
                        if (setting.equals(player.getValue().getControlSettings())){
                            player.getValue().setControlSettings(setting);
                        }
                    }
                }
            } else {
                logger.info(player.getValue().getPlayerName() + " has no control settings.");
            }

            if (player.getValue().getCameraSettings() != null) {
                if (!cameraSettingsSet.contains(player.getValue().getCameraSettings())){
                    cameraSettingsSet.add(player.getValue().getCameraSettings());
                }else {
                    for (CameraSettings setting : cameraSettingsSet) {
                        if (setting.equals(player.getValue().getCameraSettings())){
                            player.getValue().setCameraSettings(setting);
                        }
                    }
                }
            } else {
                logger.info(player.getValue().getPlayerName() + " has no camera settings.");
            }

            if (player.getValue().getDeadzoneSettings() != null) {
                if (!deadzoneSettingsSet.contains(player.getValue().getDeadzoneSettings())){
                    deadzoneSettingsSet.add(player.getValue().getDeadzoneSettings());
                }else {
                    for (DeadzoneSettings setting : deadzoneSettingsSet) {
                        if (setting.equals(player.getValue().getDeadzoneSettings())){
                            player.getValue().setDeadzoneSettings(setting);
                        }
                    }
                }
            } else {
                logger.info(player.getValue().getPlayerName() + " has no deadzone settings.");
            }
            playerSet.add(player.getValue());
        }

        controlSettingsSet.forEach(controlDao::add);
        cameraSettingsSet.forEach(cameraDao::add);
        deadzoneSettingsSet.forEach(deadzoneDao::add);
        playerSet.forEach(playerDao::add);
    }

    public Map<String, Player> getAllPlayers() {
        // Create Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectSquishyDBconnect");

        // Create Daos
        GenericDao<Player> playerDao = new GenericDao<>(emf, Player.class);

        List<Player> searchedPlayers = playerDao.getAll();

        Map<String, Player> allPlayerMap = searchedPlayers.stream().collect(
                Collectors.toMap(Player::getPlayerName, player -> player));

        // Close Entity Manager Factory
        emf.close();

        return allPlayerMap;
    }
}

