import com.roboticRover.controller.IRoboticRoverController;
import com.roboticRover.domain.Plateau;
import com.roboticRover.domain.Position;
import com.roboticRover.domain.Rover;
import com.roboticRover.domain.direction.CardinalPointsResolver;
import com.roboticRover.exceptions.ExceptionMessages;
import com.roboticRover.exceptions.IllegalInputException;
import com.roboticRover.exceptions.InitializationException;
import com.roboticRover.service.IRoboticRoverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */
public class RobotiRoverControllerTest extends SpringBootRoboticRoverMovementTests {

    @Autowired
    IRoboticRoverController roboticRoverController;

    @Autowired
    IRoboticRoverService roboticRoverService;

    @Test
    public void testInitializationOfPlateau() throws IllegalInputException {

        String plateauFields= "5 5";

        roboticRoverController.initializePlateau(plateauFields);

        Plateau actualPlateau= roboticRoverService.getPlateau();


        Plateau expectedPlateau= new Plateau(5,5);

        assertTrue(expectedPlateau.getMax_X_Coord()==actualPlateau.getMax_X_Coord());
        assertTrue(expectedPlateau.getMax_Y_Coord()==actualPlateau.getMax_Y_Coord());


    }


    @Test
    public void testInValidInitializationOfPlateauException() throws InitializationException, IllegalInputException {

        String plateauFields= "5 K";

        Exception exception=Assertions.assertThrows(IllegalInputException.class, ()->roboticRoverController.initializePlateau(plateauFields));
        assertEquals(ExceptionMessages.INVALID_PLATEAU_INPUT_EXCEPTION.getMessage(), exception.getMessage());
    }


    @Test
    public void testInitializationOfRover() throws IllegalInputException, InitializationException {

        String roverFields= "4 4 N";

        roboticRoverController.initializeRover(roverFields, 1001);

        Rover actualRover= roboticRoverService.getRoverById(1001);

        Position expectedPosition= new Position(4,4,CardinalPointsResolver.NORTH);
        Rover expectedRover= new Rover(expectedPosition,1001);

        assertTrue(expectedRover.equals(actualRover));
    }


    @Test
    public void testInValidInitializationOfRoverException() throws InitializationException, IllegalInputException {

        String roverFields= "4 4 4";

        Exception exception=Assertions.assertThrows(IllegalInputException.class, ()->roboticRoverController.initializeRover(roverFields, 1001));
        assertEquals(ExceptionMessages.INVALID_ROVER_INITIALIZING_INPUT.getMessage(), exception.getMessage());
    }


    public void testMotionOfRover() throws IllegalInputException, InitializationException {

        String motionFields= "LMLMLMLMLMM";
        Integer roverId=1001;
        String roverFields= "1 2 N";

        roboticRoverController.initializeRover(roverFields, 1001);

        roboticRoverController.moveRover(motionFields,roverId);

        Rover actualRover= roboticRoverService.getRoverById(1001);

        Position expectedPosition= new Position(1,3,CardinalPointsResolver.NORTH);
        Rover expectedRover= new Rover(expectedPosition,1001);

        assertTrue(expectedRover.equals(actualRover));


    }


    @Test
    public void testInValidMotionInputException() throws InitializationException, IllegalInputException {

        String motionFields= "4 4 4";
        Integer roverId=1001;

        Exception exception=Assertions.assertThrows(IllegalInputException.class, ()->roboticRoverController.moveRover(motionFields,roverId));
        assertEquals(ExceptionMessages.INVALID_MOTION_INPUT_EXCEPTION.getMessage(), exception.getMessage());
    }


}
