package ProjectSquishy.models.settings;

import ProjectSquishy.dao.Persistable;
import ProjectSquishy.models.Player;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONTROL_SETTINGS")
public class ControlSettings implements Persistable<ControlSettings> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long controlSettingsId;

    @Column(name = "POWER_SLIDE", columnDefinition =" varchar(255) default square")
    private String powerSlide;

    @Column(name = "AIR_ROLL", columnDefinition = "varchar(255) default square")
    private String airRoll;

//    @Column(name = "AIR_ROLL_LEFT")
////    private String airRollLeft;
////
////    @Column(name = "AIR_ROLL_RIGHT")
////    private String airRollRight;

    @Column(name = "BOOST", columnDefinition = "varchar(255) default circle")
    private String boost;

    @Column(name = "JUMP", columnDefinition = "varchar(255) default cross")
    private String jump;

    @Column(name = "BALL_CAM", columnDefinition = "varchar(255) default triangle")
    private String ballCam;

    @Column(name = "BRAKE", columnDefinition = "varchar(255) default L1")
    private String brake;

    @Column(name = "THROTTLE", columnDefinition = "varchar(255) default R1")
    private String throttle;

    @OneToOne(mappedBy = "controlSettings")
    private Player player;

    public ControlSettings() {
    }

    @Override
    public long getControlSettingsId() {
        return controlSettingsId;
    }

    public ControlSettings( String powerSlide, String airRoll,
//                           String airRollLeft, String airRollRight,
                           String boost, String jump, String ballCam, String brake, String throttle) {
        this.powerSlide = powerSlide;
        this.airRoll = airRoll;
//        this.airRollLeft = airRollLeft;
//        this.airRollRight = airRollRight;
        this.boost = boost;
        this.jump = jump;
        this.ballCam = ballCam;
        this.brake = brake;
        this.throttle = throttle;
    }

    @Override
    public void update(ControlSettings updateType) {
        if (controlSettingsId == updateType.controlSettingsId){
            powerSlide = updateType.powerSlide;
            airRoll = updateType.airRoll;
//            airRollLeft = updateType.airRollLeft;
//            airRollRight = updateType.airRollRight;
            boost = updateType.boost;
            jump = updateType.jump;
            ballCam = updateType.ballCam;
            brake = updateType.brake;
            throttle = updateType.throttle;
        }
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

//    public String getAirRollLeft() {
//        return airRollLeft;
//    }
//
//    public void setAirRollLeft(String airRollLeft) {
//        this.airRollLeft = airRollLeft;
//    }
//
//    public String getAirRollRight() {
//        return airRollRight;
//    }
//
//    public void setAirRollRight(String airRollRight) {
//        this.airRollRight = airRollRight;
//    }

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
        return controlSettingsId == that.controlSettingsId &&
                Objects.equals(powerSlide, that.powerSlide) &&
                Objects.equals(airRoll, that.airRoll) &&
//                Objects.equals(airRollLeft, that.airRollLeft) &&
//                Objects.equals(airRollRight, that.airRollRight) &&
                Objects.equals(boost, that.boost) &&
                Objects.equals(jump, that.jump) &&
                Objects.equals(ballCam, that.ballCam) &&
                Objects.equals(brake, that.brake) &&
                Objects.equals(throttle, that.throttle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controlSettingsId, powerSlide, airRoll,
//                airRollLeft, airRollRight,
                boost, jump, ballCam, brake, throttle);
    }

    @Override
    public String toString() {
        return "ControlSettings{" +
                "controlSettingsId=" + controlSettingsId +
                ", powerSlide='" + powerSlide + '\'' +
                ", airRoll='" + airRoll + '\'' +
//                ", airRollLeft='" + airRollLeft + '\'' +
//                ", airRollRight='" + airRollRight + '\'' +
                ", boost='" + boost + '\'' +
                ", jump='" + jump + '\'' +
                ", ballCam='" + ballCam + '\'' +
                ", brake='" + brake + '\'' +
                ", throttle='" + throttle + '\'' +
                '}';
    }
}

