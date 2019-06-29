package ProjectSquishy;

import java.util.Objects;

public class CameraSettings extends Settings {

    private boolean cameraShake;
    private long fov;
    private long distance;
    private long height;
    private long angle;
    private double stiffness;
    private double swivel;
    private boolean ballCam;

    public CameraSettings(boolean cameraShake, long fov, long distance, long height, long angle, double stiffness, double swivel, boolean ballcam) {
        this.cameraShake = cameraShake;
        this.fov = fov;
        this.distance = distance;
        this.height = height;
        this.angle = angle;
        this.stiffness = stiffness;
        this.swivel = swivel;
        this.ballCam = ballcam;
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

    public void setFov(int fov) {
        this.fov = fov;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public long getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
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
        return cameraShake == that.cameraShake &&
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
        return Objects.hash(cameraShake, fov, distance, height, angle, stiffness, swivel, ballCam);
    }
}
