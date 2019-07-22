package ProjectSquishy.models.settings;

import ProjectSquishy.dao.Persistable;
import ProjectSquishy.models.Player;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "DEADZONE_SETTINGS")
public class DeadzoneSettings implements Persistable<DeadzoneSettings> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long deadzoneSettingsId;

    @Column(name = "DEADZONE_SHAPE", columnDefinition = "varchar(255) default Square")
    private String deadzoneShape;

    @Column(name = "DEADZONE", columnDefinition = "double default .3")
    private double deadzone;

    @Column(name = "DODGE_DEADZONE", columnDefinition = "double default .5")
    private double dodgeDeadzone;

    @Column(name = "AERIAL_SENSITIVITY", columnDefinition = "double default 1")
    private double aerialSensitivity;

    @Column(name = "STEERING_SENSITIVITY", columnDefinition = "double default `")
    private double steeringSensitivity;

    @OneToOne(mappedBy = "deadzoneSettings")
    private Player player;

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
    public long getControlSettingsId() {
        return deadzoneSettingsId;
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
        return deadzoneSettingsId == that.deadzoneSettingsId &&
                Objects.equals(deadzoneShape, that.deadzoneShape) &&
                Objects.equals(deadzone, that.deadzone) &&
                Objects.equals(dodgeDeadzone, that.dodgeDeadzone) &&
                Objects.equals(aerialSensitivity, that.aerialSensitivity) &&
                Objects.equals(steeringSensitivity, that.steeringSensitivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deadzoneSettingsId, deadzoneShape, deadzone, dodgeDeadzone, aerialSensitivity, steeringSensitivity);
    }

    @Override
    public String toString() {
        return "DeadzoneSettings{" +
                "id=" + deadzoneSettingsId +
                ", deadzoneShape='" + deadzoneShape + '\'' +
                ", deadzone=" + deadzone +
                ", dodgeDeadzone=" + dodgeDeadzone +
                ", aerialSensitivity=" + aerialSensitivity +
                ", steeringSensitivity=" + steeringSensitivity +
                '}';
    }
}
