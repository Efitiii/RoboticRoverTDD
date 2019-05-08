import com.roboticRover.exceptions.ExceptionMessages;
import com.roboticRover.exceptions.IllegalInputException;
import com.roboticRover.exceptions.InitializationException;
import com.roboticRover.service.IRoboticRoverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Efrem  on 5/2/19
 * @project java-test-project
 */
public class ExceptionTest extends SpringBootRoboticRoverMovementTests {

    @Autowired
    IRoboticRoverService roboticRoverService;

    @BeforeEach
    public void setUp(){
        roboticRoverService.initializePlateau(5,5);
    }

    @Test
    public void testIllegalInputException_illegalMotionInput() throws InitializationException {
        roboticRoverService.initializeRover(3,3,"N", 1002);

        Exception exception=Assertions.assertThrows(IllegalInputException.class, ()-> roboticRoverService.moveRobot(1002, "k"));
        assertEquals(ExceptionMessages.INVALID_MOTION_INPUT_EXCEPTION.getMessage(), exception.getMessage());

    }


    @Test
    public void testRoverInitialization_Coordinates_Greater_PlateauSize() throws InitializationException {


        Exception exception=Assertions.assertThrows(InitializationException.class, ()-> roboticRoverService.initializeRover(6, 6, "N", 1001));
        assertEquals(ExceptionMessages.COORDINATES_GREATER_THAN_PLATEAU_SIZE.getMessage(), exception.getMessage());

    }


    @Test
    public void testRoverInitialization_Motion_Input_OutOfBoundaries() throws InitializationException {

        roboticRoverService.initializeRover(5,5,"N", 1001);

        Exception exception=Assertions.assertThrows(IllegalInputException.class, ()-> roboticRoverService.moveRobot(1001,"m"));
        assertEquals(ExceptionMessages.INVALID_MOTION_INPUT_EXCEEDS_BOUNDARY.getMessage(), exception.getMessage());

    }


    @Test
    public void testInValidMoveOfRobot_SpaceOccupied() throws InitializationException, IllegalInputException {

        roboticRoverService.initializeRover(5, 5, "W", 1001);
        roboticRoverService.initializeRover(4, 5, "W", 1002);

        Exception exception=Assertions.assertThrows(IllegalInputException.class, ()-> roboticRoverService.moveRobot(1001,"M"));
        assertEquals(ExceptionMessages.INVALID_MOTION_INPUT_SPACE_OCCUPIED.getMessage(), exception.getMessage());
    }


    @Test
    public void testRobotIsNotInitializedException() throws InitializationException, IllegalInputException {

        roboticRoverService.initializeRover(5, 5, "W", 1001);
        roboticRoverService.initializeRover(4, 5, "W", 1002);

        Exception exception=Assertions.assertThrows(InitializationException.class, ()-> roboticRoverService.moveRobot(1003,"M"));
        assertEquals(ExceptionMessages.ROBOT_NOT_INITIALIZED.getMessage(), exception.getMessage());
    }



}
