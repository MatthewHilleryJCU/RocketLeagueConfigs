package ProjectSquishy;

import java.util.Objects;

public class ControlSettings extends Settings {

    private String powerSlide;
    private String airRoll;
    private String airRollLeft;
    private String airRollRight;
    private String boost;
    private String jump;
    private String ballCam;
    private String brake;
    private String throttle;

    public ControlSettings(String powerSlide, String airRoll, String airRollLeft, String airRollRight, String boost, String jump, String ballCam, String brake, String throttle) {
        this.powerSlide = powerSlide;
        this.airRoll = airRoll;
        this.airRollLeft = airRollLeft;
        this.airRollRight = airRollRight;
        this.boost = boost;
        this.jump = jump;
        this.ballCam = ballCam;
        this.brake = brake;
        this.throttle = throttle;
    }

    public String getPowerSlide() {
        return powerSlide;
    }

    public void setPowerSlide(String powerSlide) {
        this.powerSlide = powerSlide;
    }

    public String getAirRoll() {
        return airRoll;
    }

    public void setAirRoll(String airRoll) {
        this.airRoll = airRoll;
    }

    public String getAirRollLeft() {
        return airRollLeft;
    }

    public void setAirRollLeft(String airRollLeft) {
        this.airRollLeft = airRollLeft;
    }

    public String getAirRollRight() {
        return airRollRight;
    }

    public void setAirRollRight(String airRollRight) {
        this.airRollRight = airRollRight;
    }

    public String getBoost() {
        return boost;
    }

    public void setBoost(String boost) {
        this.boost = boost;
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }

    public String getBallCam() {
        return ballCam;
    }

    public void setBallCam(String ballCam) {
        this.ballCam = ballCam;
    }

    public String getBrake() {
        return brake;
    }

    public void setBrake(String brake) {
        this.brake = brake;
    }

    public String getThrottle() {
        return throttle;
    }

    public void setThrottle(String throttle) {
        this.throttle = throttle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControlSettings that = (ControlSettings) o;
        return Objects.equals(powerSlide, that.powerSlide) &&
                Objects.equals(airRoll, that.airRoll) &&
                Objects.equals(airRollLeft, that.airRollLeft) &&
                Objects.equals(airRollRight, that.airRollRight) &&
                Objects.equals(boost, that.boost) &&
                Objects.equals(jump, that.jump) &&
                Objects.equals(ballCam, that.ballCam) &&
                Objects.equals(brake, that.brake) &&
                Objects.equals(throttle, that.throttle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerSlide, airRoll, airRollLeft, airRollRight, boost, jump, ballCam, brake, throttle);
    }

    @Override
    public String toString() {
        return "ControlSettings{" +
                "powerSlide='" + powerSlide + '\'' +
                ", airRoll='" + airRoll + '\'' +
                ", airRollLeft='" + airRollLeft + '\'' +
                ", airRollRight='" + airRollRight + '\'' +
                ", boost='" + boost + '\'' +
                ", jump='" + jump + '\'' +
                ", ballCam='" + ballCam + '\'' +
                ", brake='" + brake + '\'' +
                ", throttle='" + throttle + '\'' +
                '}';
    }
}

