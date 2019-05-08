package com.roboticRover.controller;

import com.roboticRover.exceptions.IllegalInputException;
import com.roboticRover.exceptions.InitializationException;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */
public interface IRoboticRoverController {


    void initializePlateau(String plateauFields) throws IllegalInputException;

    void initializeRover(String roverFields, Integer id)  throws IllegalInputException, InitializationException;

    void moveRover(String motionFields, Integer roverId) throws IllegalInputException, InitializationException;
}
