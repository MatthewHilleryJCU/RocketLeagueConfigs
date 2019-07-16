package ProjectSquishy.dao;

import ProjectSquishy.models.Player;
import ProjectSquishy.models.settings.CameraSettings;
import ProjectSquishy.models.settings.ControlSettings;
import ProjectSquishy.models.settings.DeadzoneSettings;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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



    public Map<String, Player> getAllPlayers(){
        // Create Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlDBconnect");

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

