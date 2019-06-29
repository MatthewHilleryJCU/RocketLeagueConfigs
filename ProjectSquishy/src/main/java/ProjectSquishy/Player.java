package ProjectSquishy;

import java.util.Objects;

public class Player {

    private String name;
    private int id;
    private ControlSettings controlSettings;
    private CameraSettings cameraSettings;

    public Player() {
        this.controlSettings = controlSettings;
        this.cameraSettings = cameraSettings;
        this.name = name;
        this.id = id;
    }

    public ControlSettings getControlSettings() {
        return controlSettings;
    }

    public void setControlSettings(ControlSettings controlSettings) {
        this.controlSettings = controlSettings;
    }

    public CameraSettings getCameraSettings() {
        return cameraSettings;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.cameraSettings = cameraSettings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", controlSettings=" + controlSettings.toString() +
                ", cameraSettings=" + cameraSettings.toString() +
                '}';
    }
}
