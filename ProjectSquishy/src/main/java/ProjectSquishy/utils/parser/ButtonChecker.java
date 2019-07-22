package ProjectSquishy.utils.parser;

import org.apache.log4j.Logger;

public class ButtonChecker {

    private static final String XBOXCROSS = "/commons/images/d/d2/Xbox_button_A.svg";
    private static final String XBOXCIRCLE = "/commons/images/b/b8/Xbox_button_B.svg";
    private static final String XBOXSQUARE = "/commons/images/8/8c/Xbox_button_X.svg";
    private static final String XBOXTRIANGLE = "/commons/images/d/df/Xbox_button_Y.svg";
    private static final String XBOXR1 = "/commons/images/8/89/Xbox_Right_Bumper.svg";
    private static final String XBOXR2 = "/commons/images/7/7a/Xbox_Right_Trigger.svg";
    private static final String XBOXL1 = "/commons/images/8/8c/Xbox_Left_Bumper.svg";
    private static final String XBOXL2 = "/commons/images/2/23/Xbox_Left_Trigger.svg";
    private static final String XBOXLeftStick = "/commons/images/6/68/Xbox_Left_stick.svg";

    private static final String PS4CROSS = "/commons/images/8/8f/PlayStation_button_X.svg";
    private static final String PS4CIRCLE = "/commons/images/6/6b/PlayStation_button_C.svg";
    private static final String PS4SQUARE = "/commons/images/4/49/PlayStation_button_S.svg";
    private static final String PS4TRIANGLE = "/commons/images/6/69/PlayStation_button_T.svg";
    private static final String PS4R1 = "/commons/images/7/7c/PlayStation_button_R1.svg";
    private static final String PS4R2 = "/commons/images/0/0e/PlayStation_button_R2.svg";
    private static final String PS4L1 = "/commons/images/6/66/PlayStation_button_L1.svg";
    private static final String PS4L2 = "/commons/images/9/97/PlayStation_button_L2.svg";
    private static final String PS4L3 = "/commons/images/4/48/PlayStation_button_L3.svg";

    private final Logger logger = Logger.getLogger(ButtonChecker.class);


    public String checkButton(String buttonSource) {

        switch (buttonSource) {
            case XBOXCROSS:
            case PS4CROSS:
                return "cross";
            case XBOXCIRCLE:
            case PS4CIRCLE:
                return "circle";
            case XBOXTRIANGLE:
            case PS4TRIANGLE:
                return "triangle";
            case XBOXSQUARE:
            case PS4SQUARE:
                return "square";
            case XBOXR1:
            case PS4R1:
                return "R1";
            case XBOXR2:
            case PS4R2:
                return "R2";
            case XBOXL1:
            case PS4L1:
                return "L1";
            case XBOXL2:
            case PS4L2:
                return "L2";
            case XBOXLeftStick:
            case PS4L3:
                return "L3";
            default:
                logger.error("Couldn't map button from: " + buttonSource);
                return "Couldn't map button";

        }
    }
}
