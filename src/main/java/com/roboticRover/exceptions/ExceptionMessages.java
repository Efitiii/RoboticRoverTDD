package com.roboticRover.exceptions;

/**
 * @author Efrem  on 4/12/19
 * @project java-test-project
 */
public enum ExceptionMessages {


    COORDINATES_GREATER_THAN_PLATEAU_SIZE ("Coordinate point provided are greater than plateau size."),
    INVALID_MOTION_INPUT_EXCEPTION("The input for motion is not valid, it should either be 'l' for left 'r' for right or 'm' move forward"),
    INVALID_MOTION_INPUT_EXCEEDS_BOUNDARY("The robot can't move forward as it will leave the plateau area."),
    INVALID_MOTION_INPUT_SPACE_OCCUPIED ("Invalid motion input, space already occupied by another Robot"),
    ROBOT_NOT_INITIALIZED("Robot doesn't exist. Robot should be initialized to proceed"),
    INVALID_PLATEAU_INPUT_EXCEPTION("The plateau input information entered is not valid."),
    INVALID_ROVER_INITIALIZING_INPUT("The robotic rover initialization information is not valid");

    private String message;

    ExceptionMessages(String message) {

        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
