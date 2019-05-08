package com.roboticRover.service;

import com.roboticRover.domain.Plateau;
import com.roboticRover.domain.Position;
import com.roboticRover.domain.Rover;
import com.roboticRover.domain.direction.CardinalPointsResolver;
import com.roboticRover.domain.direction.MotionResolver;
import com.roboticRover.exceptions.ExceptionMessages;
import com.roboticRover.exceptions.InitializationException;
import com.roboticRover.exceptions.IllegalInputException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Efrem  on 4/12/19
 */

@Service
public class RoboticRoverService implements IRoboticRoverService {

    private Plateau plateau;

    private Map<Position, Rover> roversMapByPosition;
    private Map<Integer, Rover> roversMapById;


    public RoboticRoverService() {
        roversMapByPosition = new ConcurrentHashMap<>();
        roversMapById = new ConcurrentHashMap<>();
    }

    /**
     * Initializes the Rover with x-coordinate, y-coordinate, cardinal Point and rover Id
     *
     * @param xcoord
     * @param ycoord
     * @param cardinalP
     * @param roverId
     */

    @Override
    public void initializeRover(Integer xcoord, Integer ycoord, String cardinalP, Integer roverId) throws InitializationException {

        if (xcoord > plateau.getMax_X_Coord() || ycoord > plateau.getMax_Y_Coord()) {
            throw new InitializationException(ExceptionMessages.COORDINATES_GREATER_THAN_PLATEAU_SIZE.getMessage());
        }


        Position position = new Position(xcoord, ycoord, CardinalPointsResolver.getCardinalPoints(cardinalP.toLowerCase()));

        this.roversMapByPosition.put(position, new Rover(position, roverId));
        this.roversMapById.put(roverId, roversMapByPosition.get(position));

    }

    /**
     * Initializes the Plateau
     *
     * @param max_X_Coord
     * @param max_Y_Coord
     */

    @Override
    public void initializePlateau(Integer max_X_Coord, Integer max_Y_Coord) {

        this.plateau= new Plateau(max_X_Coord,max_Y_Coord);

    }


    @Override
    public Plateau getPlateau() {
        return plateau;
    }


    /**
     * Moves the Robot in the direction specified
     *
     * @param roverId
     * @param motionDirection
     */

    @Override
    public void moveRobot(Integer roverId, String motionDirection) throws IllegalInputException, InitializationException {

        Rover rover = getRoverById(roverId);

        MotionResolver input = MotionResolver.getMotionValue(motionDirection);


        switch (input) {
            case ROTATE_LEFT:
                rover.getPosition().setCardinalP(rover.getPosition().getCardinalP().rotateLeft());
                break;

            case ROTATE_RIGHT:
                rover.getPosition().setCardinalP(rover.getPosition().getCardinalP().rotateRight());
                break;

            case MOVE_FORWARD:
                synchronized (this) {
                    applyForwardMotion(rover);
                }
                break;

        }


    }

    @Override
    public Rover getRoverById(Integer id) throws InitializationException {

        if (!this.roversMapById.containsKey(id)){
            throw new InitializationException(ExceptionMessages.ROBOT_NOT_INITIALIZED.getMessage());
        }

        return this.roversMapById.get(id);
    }

    /**
     * Applies a forward motion on the input rover
     *
     * @param rover
     */

    private void applyForwardMotion(Rover rover) throws IllegalInputException {

        CardinalPointsResolver cardinalPoint = rover.getPosition().getCardinalP();
        int newXCoordinate = rover.getPosition().getXcoord() + cardinalPoint.getDx();
        int newYCoordinate = rover.getPosition().getYcoord() + cardinalPoint.getDy();

        if (newXCoordinate > plateau.getMax_X_Coord() || newYCoordinate > plateau.getMax_Y_Coord()) {
            throw new IllegalInputException(ExceptionMessages.INVALID_MOTION_INPUT_EXCEEDS_BOUNDARY.getMessage());
        }

        Position temporaryPosition = new Position(newXCoordinate, newYCoordinate, CardinalPointsResolver.NORTH);

        if (roversMapByPosition.containsKey(temporaryPosition)) {
            throw new IllegalInputException(ExceptionMessages.INVALID_MOTION_INPUT_SPACE_OCCUPIED.getMessage());
        }

        rover.getPosition().setXcoord(newXCoordinate);
        rover.getPosition().setYcoord(newYCoordinate);

    }

    @Override
    public Map<Position, Rover> getRoversMapByPosition() {
        return roversMapByPosition;
    }
}
