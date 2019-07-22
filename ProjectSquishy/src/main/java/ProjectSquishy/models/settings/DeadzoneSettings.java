package ProjectSquishy.models.settings;

import ProjectSquishy.dao.Persistable;
import ProjectSquishy.models.Player;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "DEADZONE_SETTINGS")
public class DeadzoneSettings implements Persistable<DeadzoneSettings> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO
            , generator = "native"
    )
    @GenericGenerator(name = "native", strategy = "native")
    private long deadzoneSettingsId;

    @Column(name = "DEADZONE_SHAPE")
    private String deadzoneShape;

    @Column(name = "DEADZONE")
    private double deadzone;

    @Column(name = "DODGE_DEADZONE")
    private double dodgeDeadzone;

    @Column(name = "AERIAL_SENSITIVITY")
    private double aerialSensitivity;

    @Column(name = "STEERING_SENSITIVITY")
    private double steeringSensitivity;

    @OneToMany(mappedBy = "deadzoneSettings")
    private List<Player> players = new ArrayList<>();

    public DeadzoneSettings() {
    }

    public DeadzoneSettings(String deadzoneShape, double deadzone, double dodgeDeadzone, double aerialSensitivity, double steeringSensitivity) {
        this.deadzoneShape = deadzoneShape;
        this.deadzone = deadzone;
        this.dodgeDeadzone = dodgeDeadzone;
        this.aerialSensitivity = aerialSensitivity;
        this.steeringSensitivity = steeringSensitivity;
    }

    @Override
    public long getId() {
        return deadzoneSettingsId;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getDeadzoneShape() {
        return deadzoneShape;
    }

    public void setDeadzoneShape(String deadzoneShape) {
        this.deadzoneShape = deadzoneShape;
    }

    public double getDeadzone() {
        return deadzone;
    }

    public void setDeadzone(double deadzone) {
        this.deadzone = deadzone;
    }


    public double getDodgeDeadzone() {
        return dodgeDeadzone;
    }

    public void setDodgeDeadzone(double dodgeDeadzone) {
        this.dodgeDeadzone = dodgeDeadzone;
    }

    public double getAerialSensitivity() {
        return aerialSensitivity;
    }

    public void setAerialSensitivity(double aerialSensitivity) {
        this.aerialSensitivity = aerialSensitivity;
    }

    public double getSteeringSensitivity() {
        return steeringSensitivity;
    }

    public void setSteeringSensitivity(double steeringSensitivity) {
        this.steeringSensitivity = steeringSensitivity;
    }

    @Override
    public void update(DeadzoneSettings updateType) {
        if (deadzoneSettingsId == updateType.deadzoneSettingsId) {
            deadzoneShape = updateType.deadzoneShape;
            deadzone = updateType.deadzone;
            dodgeDeadzone = updateType.dodgeDeadzone;
            aerialSensitivity = updateType.aerialSensitivity;
            steeringSensitivity = updateType.steeringSensitivity;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeadzoneSettings that = (DeadzoneSettings) o;
        return Objects.equals(deadzoneShape, that.deadzoneShape) &&
                Objects.equals(deadzone, that.deadzone) &&
                Objects.equals(dodgeDeadzone, that.dodgeDeadzone) &&
                Objects.equals(aerialSensitivity, that.aerialSensitivity) &&
                Objects.equals(steeringSensitivity, that.steeringSensitivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deadzoneShape, deadzone, dodgeDeadzone, aerialSensitivity, steeringSensitivity);
    }

    @Override
    public String toString() {
        return "DeadzoneSettings{" +
                "\n deadzoneShape='" + deadzoneShape + '\'' +
                ",\n deadzone=" + deadzone +
                ",\n dodgeDeadzone=" + dodgeDeadzone +
                ",\n aerialSensitivity=" + aerialSensitivity +
                ",\n steeringSensitivity=" + steeringSensitivity +
                '}';
    }
}
