package ProjectSquishy;

import ProjectSquishy.utils.parser.ButtonChecker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ButtonCheckerTest {

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

    private final ButtonChecker buttonChecker = new ButtonChecker();


    @Test
    public void when_passing_a_XBOXCROSS_string_to_checkout_button_cross_is_returned() {
        assertEquals("cross", buttonChecker.checkButton(XBOXCROSS));
    }

    @Test
    public void when_passing_a_XBOXCIRCLE_string_to_checkout_button_circle_is_returned() {
        assertEquals("circle", buttonChecker.checkButton(XBOXCIRCLE));
    }

    @Test
    public void when_passing_a_XBOXSQUARE_string_to_checkout_button_square_is_returned() {
        assertEquals("square", buttonChecker.checkButton(XBOXSQUARE));
    }

    @Test
    public void when_passing_a_XBOXTRIANGLE_string_to_checkout_button_triangle_is_returned() {
        assertEquals("triangle", buttonChecker.checkButton(XBOXTRIANGLE));
    }

    @Test
    public void when_passing_a_XBOXR1_string_to_checkout_button_R1_is_returned() {
        assertEquals("R1", buttonChecker.checkButton(XBOXR1));
    }

    @Test
    public void when_passing_a_XBOXR2_string_to_checkout_button_R2_is_returned() {
        assertEquals("R2", buttonChecker.checkButton(XBOXR2));
    }

    @Test
    public void when_passing_a_XBOXL1_string_to_checkout_button_L1_is_returned() {
        assertEquals("L1", buttonChecker.checkButton(XBOXL1));
    }

    @Test
    public void when_passing_a_XBOXL2_string_to_checkout_button_L2_is_returned() {
        assertEquals("L2", buttonChecker.checkButton(XBOXL2));
    }

    @Test
    public void when_passing_a_PS4CROSS_string_to_checkout_button_cross_is_returned() {
        assertEquals("cross", buttonChecker.checkButton(PS4CROSS));
    }

    @Test
    public void when_passing_a_PS4CIRCLE_string_to_checkout_button_circle_is_returned() {
        assertEquals("circle", buttonChecker.checkButton(PS4CIRCLE));
    }

    @Test
    public void when_passing_a_PS4SQUARE_string_to_checkout_button_square_is_returned() {
        assertEquals("square", buttonChecker.checkButton(PS4SQUARE));
    }

    @Test
    public void when_passing_a_PS4TRIANGLE_string_to_checkout_button_triangle_is_returned() {
        assertEquals("triangle", buttonChecker.checkButton(PS4TRIANGLE));
    }

    @Test
    public void when_passing_a_PS4L1_string_to_checkout_button_L1_is_returned() {
        assertEquals("L1", buttonChecker.checkButton(PS4L1));
    }

    @Test
    public void when_passing_a_PS4R2_string_to_checkout_button_R2_is_returned() {
        assertEquals("R2", buttonChecker.checkButton(PS4R2));
    }

    @Test
    public void when_passing_a_PS4R1_string_to_checkout_button_R1_is_returned() {
        assertEquals("R1", buttonChecker.checkButton(PS4R1));
    }

    @Test
    public void when_passing_a_PS4L2_string_to_checkout_button_L2_is_returned() {
        assertEquals("L2", buttonChecker.checkButton(PS4L2));
    }
    @Test
    public void when_passing_a_random_string_to_checkout_button_couldnt_map_button_is_returned() {
        assertEquals("L2", buttonChecker.checkButton(PS4L2));
    }
    @Test
    public void when_passing_a_XBOXLeftStick_string_to_checkout_button_cross_is_returned() {
        assertEquals("L3", buttonChecker.checkButton(XBOXLeftStick));
    }

    @Test
    public void when_passing_a_PS4L3_string_to_checkout_button_circle_is_returned() {
        assertEquals("L3", buttonChecker.checkButton(PS4L3));
    }

}
