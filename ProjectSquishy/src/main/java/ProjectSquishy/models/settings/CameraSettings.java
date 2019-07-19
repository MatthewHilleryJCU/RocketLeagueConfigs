package ProjectSquishy.models.settings;

import ProjectSquishy.dao.Persistable;
import ProjectSquishy.models.Player;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAMERA_SETTINGS")
public class CameraSettings implements Persistable<CameraSettings> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long cameraSettingsId;

    @Column(name = "CAMERA_SHAKE")
    private boolean cameraShake;

    @Column(name = "FOV")
    private long fov;

    @Column(name = "DISTANCE")
    private long distance;

    @Column(name = "HEIGHT")
    private long height;

    @Column(name = "ANGLE")
    private double angle;

    @Column(name = "STIFFNESS")
    private double stiffness;

    @Column(name = "SWIVEL")
    private double swivel;

    @Column(name = "BALLCAM")
    private boolean ballCam;

    @OneToOne(mappedBy = "cameraSettings")
    private Player player;


    public CameraSettings() {
    }

    public CameraSettings( boolean cameraShake, long fov, long distance, long height, long angle, double stiffness, double swivel, boolean ballCam) {
        this.cameraShake = cameraShake;
        this.fov = fov;
        this.distance = distance;
        this.height = height;
        this.angle = angle;
        this.stiffness = stiffness;
        this.swivel = swivel;
        this.ballCam = ballCam;
    }

    @Override
    public long getControlSettingsId() {
        return cameraSettingsId;
    }

    @Override
    public void update(CameraSettings updateType) {
        if (cameraSettingsId == updateType.cameraSettingsId) {
            cameraShake = updateType.cameraShake;
            fov = updateType.fov;
            distance = updateType.distance;
            height = updateType.height;
            angle = updateType.angle;
            stiffness = updateType.stiffness;
            swivel = updateType.swivel;
            ballCam = updateType.ballCam;
        }
    }

    public boolean isCameraShake() {
        return cameraShake;
    }

    public void setCameraShake(boolean cameraShake) {
        this.cameraShake = cameraShake;
    }

    public long getFov() {
        return fov;
    }

    public void setFov(long fov) {
        this.fov = fov;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public double getStiffness() {
        return stiffness;
    }

    public void setStiffness(double stiffness) {
        this.stiffness = stiffness;
    }

    public double getSwivel() {
        return swivel;
    }

    public void setSwivel(double swivel) {
        this.swivel = swivel;
    }

    public boolean isBallCam() {
        return ballCam;
    }

    public void setBallCam(boolean ballCam) {
        this.ballCam = ballCam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraSettings that = (CameraSettings) o;
        return cameraSettingsId == that.cameraSettingsId &&
                cameraShake == that.cameraShake &&
                fov == that.fov &&
                distance == that.distance &&
                height == that.height &&
                angle == that.angle &&
                Double.compare(that.stiffness, stiffness) == 0 &&
                Double.compare(that.swivel, swivel) == 0 &&
                ballCam == that.ballCam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cameraSettingsId, cameraShake, fov, distance, height, angle, stiffness, swivel, ballCam);
    }

    @Override
    public String toString() {
        return "CameraSettings{" +
                "\n cameraShake=" + cameraShake +
                ",\n fov=" + fov +
                ",\n distance=" + distance +
                ",\n height=" + height +
                ",\n angle=" + angle +
                ",\n stiffness=" + stiffness +
                ",\n swivel=" + swivel +
                ",\n ballCam=" + ballCam +
                "}\n";
    }
}
