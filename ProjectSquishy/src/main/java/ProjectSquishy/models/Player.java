package ProjectSquishy.models;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "PLAYER")
public class Player implements Persistable<Player> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "PLAYER_NAME")
    private String playerName;

    @OneToOne
    @MapsId
    @JoinColumn(name = "CONTROL_SETTINGS_ID")
    private ControlSettings controlSettings;

    @OneToOne
    @MapsId
    @JoinColumn(name = "CAMERA_SETTINGS_ID")
    private CameraSettings cameraSettings;

    @OneToOne
    @MapsId
    @JoinColumn(name = "DEADZONE_SETTINGS_ID")
    private DeadzoneSettings deadzoneSettings;


    public Player() {
    }

    public Player(String playerName, ControlSettings controlSettings, CameraSettings cameraSettings, DeadzoneSettings deadzoneSettings) {
        this.playerName = playerName;
        this.controlSettings = controlSettings;
        this.cameraSettings = cameraSettings;
        this.deadzoneSettings = deadzoneSettings;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void update(Player updateType) {
        if (id == updateType.id) {
            controlSettings = updateType.controlSettings;
            cameraSettings = updateType.cameraSettings;
            deadzoneSettings = updateType.deadzoneSettings;
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public DeadzoneSettings getDeadzoneSettings() {
        return deadzoneSettings;
    }

    public void setDeadzoneSettings(DeadzoneSettings deadzoneSettings) {
        this.deadzoneSettings = deadzoneSettings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id &&
                Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerName);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", controlSettings=" + controlSettings.toString() +
                ", cameraSettings=" + cameraSettings.toString() +
                ", deadzoneSettings=" + deadzoneSettings.toString() +
                '}';
    }
}
