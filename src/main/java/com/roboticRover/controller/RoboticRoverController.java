package com.roboticRover.controller;

import com.roboticRover.domain.InputField;
import com.roboticRover.exceptions.ExceptionMessages;
import com.roboticRover.exceptions.IllegalInputException;
import com.roboticRover.exceptions.InitializationException;
import com.roboticRover.service.IRoboticRoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */

@Controller
public class RoboticRoverController implements IRoboticRoverController {

    @Autowired
    IRoboticRoverService roboticRoverService;

    /**
     * Initializes the Plateau
     *
     * @param plateauFields
     */

    @Override
    public void initializePlateau(String plateauFields) throws IllegalInputException {

        if (!InputField.PLATEAU_FIELD.matches(plateauFields)){
            throw new IllegalInputException(ExceptionMessages.INVALID_PLATEAU_INPUT_EXCEPTION.getMessage());
        }
        roboticRoverService.initializePlateau(Character.getNumericValue(plateauFields.charAt(0)), Character.getNumericValue(plateauFields.charAt(2)));
    }

    /**
     * Initializes the Rover
     *
     * @param roverFields
     * @param roverId
     */

    @Override
    public void initializeRover(String roverFields, Integer roverId) throws IllegalInputException, InitializationException {

        if (!InputField.ROVER_FIELD.matches(roverFields)){
            throw new IllegalInputException(ExceptionMessages.INVALID_ROVER_INITIALIZING_INPUT.getMessage());
        }

        roboticRoverService.initializeRover(Character.getNumericValue(roverFields.charAt(0)), Character.getNumericValue(roverFields.charAt(2)), Character.toString(roverFields.charAt(4)),roverId);


    }

    /**
     * Moves the Rover according to the input fields
     *
     * @param motionFields
     * @param roverId
     */

    @Override
    public void moveRover(String motionFields, Integer roverId) throws IllegalInputException, InitializationException {

        if (!InputField.MOTION_FIELD.matches(motionFields)){
            throw new IllegalInputException(ExceptionMessages.INVALID_MOTION_INPUT_EXCEPTION.getMessage());
        }


        motionFields.chars().mapToObj(c->(char)c).forEach(x->{
            try {
                roboticRoverService.moveRobot(roverId,x.toString());
            } catch (IllegalInputException e) {
                e.printStackTrace();
            } catch (InitializationException e) {
                e.printStackTrace();
            }
        });

    }


}
