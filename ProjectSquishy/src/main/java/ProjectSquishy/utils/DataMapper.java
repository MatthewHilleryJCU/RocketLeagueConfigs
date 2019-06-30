package ProjectSquishy.utils;

import ProjectSquishy.models.CameraSettings;
import ProjectSquishy.models.ControlSettings;
import ProjectSquishy.models.DeadzoneSettings;
import ProjectSquishy.models.Player;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Map;

public class DataMapper {

    public Map<String, Player> mapData(Map<String, Player> players, Document cameraDoc, Document controlDoc, Document deadzoneDoc) {

        mapCameraData(cameraDoc, players);
        mapControlData(controlDoc, players);
        mapDeadzoneData(deadzoneDoc, players);
        return players;
    }

    private void mapDeadzoneData(Document deadzoneDoc, Map<String, Player> players) {

        Element table = deadzoneDoc.select("table").get(1); //select the first table.
        Elements rows = table.select("tr");

        ArrayList<String> values = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            DeadzoneSettings settings = new DeadzoneSettings();

            for (int j = 0; j < cols.size(); j++) {
                String l = cols.get(j).text();
                values.add(l);
            }

            settings.setDeadzoneShape(values.get(2));
            settings.setDeadzone(Double.valueOf(values.get(3)));
            settings.setDodgeDeadzone(Double.valueOf(values.get(4)));
            settings.setAerialSensitivity(Double.valueOf(values.get(5)));
            settings.setSteeringSensitivity(Double.valueOf(values.get(6)));

            System.out.println(values.get(0));
            if (players.get(values.get(0)) != null) {
                players.get(values.get(0)).setDeadzoneSettings(settings);
            } else {
                Player player = new Player();
                player.setDeadzoneSettings(settings);
                players.put(values.get(0), player);
            }
            values.clear();
        }
    }

    private void mapControlData(Document controlDoc, Map<String, Player> players) {

        Element table = controlDoc.select("table").get(1); //select the first table.
        Elements rows = table.select("tr");

        ArrayList<String> values = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            ControlSettings settings = new ControlSettings();

            for (int j = 0; j < cols.size(); j++) {
                String l = cols.get(j).val();
                values.add(l);
                System.out.println(l);
            }

            settings.setPowerSlide(values.get(2));
            settings.setAirRoll(values.get(3));
//            settings.setAirRollLeft(values.get(4));
//            settings.setAirRollRight(values.get(5));
            settings.setBoost(values.get(4));
            settings.setJump(values.get(5));
            settings.setBallCam(values.get(6));
            settings.setBrake(values.get(7));
            settings.setThrottle(values.get(8));

            if (players.get(values.get(0)) != null) {
                players.get(values.get(0)).setControlSettings(settings);
            } else {
                Player player = new Player();
                player.setControlSettings(settings);
                players.put(values.get(0), player);
            }
        }
    }

    private void mapCameraData(Document cameraDoc, Map<String, Player> players) {

        Element table = cameraDoc.select("table").get(1); //select the first table.
        Elements rows = table.select("tr");

        ArrayList<String> values = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            CameraSettings settings = new CameraSettings();
            Player player = new Player();

            for (int j = 0; j < cols.size(); j++) {
                String l = cols.get(j).text();
                values.add(l);
            }

            player.setPlayerName(values.get(0));
            settings.setCameraShake(Boolean.valueOf(values.get(2)));
            settings.setFov(Long.valueOf(values.get(3)));
            settings.setHeight(Long.valueOf(values.get(4)));
            settings.setAngle(Double.valueOf(values.get(5)));
            settings.setDistance(Long.valueOf(values.get(6)));
            settings.setStiffness(Double.valueOf(values.get(7)));
            settings.setSwivel(Double.valueOf(values.get(8)));
            //TODO Sort out toggle? Boolean?

            player.setCameraSettings(settings);
            players.put(player.getPlayerName(), player);
            values.clear();
        }
    }
}
