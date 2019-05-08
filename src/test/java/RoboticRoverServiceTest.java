import com.roboticRover.domain.Plateau;
import com.roboticRover.domain.Position;
import com.roboticRover.domain.Rover;
import com.roboticRover.domain.direction.CardinalPointsResolver;
import com.roboticRover.exceptions.IllegalInputException;
import com.roboticRover.exceptions.InitializationException;
import com.roboticRover.service.IRoboticRoverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RoboticRoverServiceTest extends SpringBootRoboticRoverMovementTests {

    @Autowired
    IRoboticRoverService roboticRoverService;

    @BeforeEach
    public void setUp(){

        roboticRoverService.initializePlateau(5,5);
    }



    @Test
    public void testPlateauInitialization() {


        Plateau plateauActual = roboticRoverService.getPlateau();

        Plateau plateauExp = new Plateau(5,5);

        System.out.println(plateauExp.getMax_X_Coord());

        assertEquals(plateauExp.getMax_X_Coord(),plateauActual.getMax_X_Coord());
        assertEquals(plateauExp.getMax_Y_Coord(),plateauActual.getMax_Y_Coord());

    }


    @Test
    public void testRoverInitialization() throws InitializationException {

        roboticRoverService.initializeRover(4, 4, "N", 1001);

        Rover rover = roboticRoverService.getRoverById(1001);
        Position actualPosition = rover.getPosition();
        Position expectedPosition = new Position(4, 4, CardinalPointsResolver.getCardinalPoints("n"));

        assertEquals(actualPosition.getXcoord(), expectedPosition.getXcoord());
        assertEquals(actualPosition.getYcoord(), expectedPosition.getYcoord());
        assertEquals(actualPosition.getCardinalP(), expectedPosition.getCardinalP());


    }


    @Test
    public void testRoverMotion() throws InitializationException, IllegalInputException {

        roboticRoverService.initializeRover(4, 4, "N", 1001);

        roboticRoverService.moveRobot(1001, "L");
        assertEquals(CardinalPointsResolver.NORTH.rotateLeft(), roboticRoverService.getRoverById(1001).getPosition().getCardinalP());

        roboticRoverService.moveRobot(1001, "R");
        assertEquals(CardinalPointsResolver.WEST.rotateRight(), roboticRoverService.getRoverById(1001).getPosition().getCardinalP());


        roboticRoverService.moveRobot(1001, "M");
        assertEquals(new Integer(4), roboticRoverService.getRoverById(1001).getPosition().getXcoord());
        assertEquals(new Integer(5), roboticRoverService.getRoverById(1001).getPosition().getYcoord());

    }


    @Test
    public void initializeManyRovers() throws InitializationException {


        roboticRoverService.initializeRover(5, 5, "N", 1001);
        roboticRoverService.initializeRover(4, 4, "W", 1002);

        Map actualMap = roboticRoverService.getRoversMapByPosition();
        Map<Position, Rover> expectedMap = new ConcurrentHashMap<>();

        Position position1 = new Position(5, 5, CardinalPointsResolver.NORTH);
        Rover rover1 = new Rover(position1, 1001);

        Position position2 = new Position(4, 4, CardinalPointsResolver.WEST);
        Rover rover2 = new Rover(position2, 1002);

        expectedMap.put(position1, rover1);
        expectedMap.put(position2, rover2);

        assertEquals(expectedMap.size(), actualMap.size());
        assertTrue(expectedMap.equals(actualMap));
    }

    @Test
    public void testRobotFinalPosition_1() throws InitializationException, IllegalInputException {
        roboticRoverService.initializeRover(1, 2, "N", 1001);

        roboticRoverService.moveRobot(1001,"L");
        roboticRoverService.moveRobot(1001,"M");
        roboticRoverService.moveRobot(1001,"L");
        roboticRoverService.moveRobot(1001,"M");
        roboticRoverService.moveRobot(1001,"L");
        roboticRoverService.moveRobot(1001,"M");
        roboticRoverService.moveRobot(1001,"L");
        roboticRoverService.moveRobot(1001,"M");
        roboticRoverService.moveRobot(1001,"M");

        Position expectedPosition= new Position(1,3, CardinalPointsResolver.NORTH);
        Position actualPosition= roboticRoverService.getRoverById(1001).getPosition();

        assertTrue(expectedPosition.equals(actualPosition));
        assertTrue(expectedPosition.getCardinalP().equals(actualPosition.getCardinalP()));

    }


    @Test
    public void testRobotFinalPosition_2() throws InitializationException, IllegalInputException {
        roboticRoverService.initializeRover(3, 3, "E", 1001);

        roboticRoverService.moveRobot(1001,"M");
        roboticRoverService.moveRobot(1001,"M");
        roboticRoverService.moveRobot(1001,"R");
        roboticRoverService.moveRobot(1001,"M");
        roboticRoverService.moveRobot(1001,"M");
        roboticRoverService.moveRobot(1001,"R");
        roboticRoverService.moveRobot(1001,"M");
        roboticRoverService.moveRobot(1001,"R");
        roboticRoverService.moveRobot(1001,"R");
        roboticRoverService.moveRobot(1001,"M");

        Position expectedPosition= new Position(5,1, CardinalPointsResolver.EAST);
        Position actualPosition= roboticRoverService.getRoverById(1001).getPosition();

        assertTrue(expectedPosition.equals(actualPosition));
        assertTrue(expectedPosition.getCardinalP().equals(actualPosition.getCardinalP()));

    }




}
