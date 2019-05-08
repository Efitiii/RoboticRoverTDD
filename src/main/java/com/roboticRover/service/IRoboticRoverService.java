package com.roboticRover.service;

import com.roboticRover.domain.Plateau;
import com.roboticRover.domain.Position;
import com.roboticRover.domain.Rover;
import com.roboticRover.exceptions.IllegalInputException;
import com.roboticRover.exceptions.InitializationException;

import java.util.Map;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */


public interface IRoboticRoverService {


    void initializeRover(Integer xcoord, Integer ycoord, String cardinalP, Integer id) throws InitializationException;

    Plateau getPlateau();

    void moveRobot(Integer roverId, String motionDirection) throws IllegalInputException, InitializationException;

    Rover getRoverById(Integer id) throws InitializationException;

    public void initializePlateau(Integer max_X_Coord, Integer max_Y_Coord);

    Map<Position, Rover> getRoversMapByPosition();
}
