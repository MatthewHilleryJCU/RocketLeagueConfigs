package ProjectSquishy.utils;

import ProjectSquishy.models.CameraSettings;
import ProjectSquishy.models.ControlSettings;
import ProjectSquishy.models.Player;
import org.json.simple.JSONObject;

public class JsonMapper {

    Player player;
    JSONObject jsonObject;
    JSONObject cameraObject;
    JSONObject controllerObject;


    public JsonMapper(JSONObject jsonObject, Player player) {
        this.jsonObject = jsonObject;
        this.cameraObject = getCameraJsonObject(this.jsonObject);
        this.controllerObject = getControllerJsonObject(this.jsonObject);
        this.player = mapPlayerSettings(player, cameraObject, controllerObject);
    }


    public JSONObject getCameraJsonObject(JSONObject jsonObject) {

        JSONObject camera = (JSONObject) jsonObject.get("camera");
        return camera;
    }

    public JSONObject getControllerJsonObject(JSONObject jsonObject) {

        JSONObject controller = (JSONObject) jsonObject.get("controls");
        return controller;
    }

    private Player mapPlayerSettings(Player player, JSONObject cameraObject, JSONObject controllerObject) {

        player.setName((String) jsonObject.get("name"));
        player.setCameraSettings(new CameraSettings(
                (boolean) cameraObject.get("cameraShake"),
                (long) cameraObject.get("fov"),
                (long) cameraObject.get("distance"),
                (long) cameraObject.get("height"),
                (long) cameraObject.get("angle"),
                (double) cameraObject.get("stiffness"),
                (double) cameraObject.get("swivel"),
                (boolean) cameraObject.get("ballCam"))
        );

        player.setControlSettings(new ControlSettings(
                (String) controllerObject.get("powerSlide"),
                (String) controllerObject.get("airRoll"),
                (String) controllerObject.get("airRollLeft"),
                (String) controllerObject.get("airRollRight"),
                (String) controllerObject.get("boost"),
                (String) controllerObject.get("jump"),
                (String) controllerObject.get("ballCam"),
                (String) controllerObject.get("brake"),
                (String) controllerObject.get("throttle"))
        );

        return player;
    }
}

