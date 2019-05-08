package com.roboticRover.domain.direction;

import com.roboticRover.exceptions.ExceptionMessages;
import com.roboticRover.exceptions.IllegalInputException;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */

/**
 * MotionResolver provides enum of the possible Motions for a robot.
 *
 */
public enum MotionResolver {


    MOVE_FORWARD ("m"), ROTATE_LEFT("l"), ROTATE_RIGHT("r");

    String motion;


    private MotionResolver(String motion){
        this.motion=motion;
    }


    public static MotionResolver getMotionValue(String str) throws IllegalInputException {


        String input= str.toLowerCase();

        if (!input.equals("l") && !input.equals("r") && !input.equals("m")){
            throw new IllegalInputException(ExceptionMessages.INVALID_MOTION_INPUT_EXCEPTION.getMessage());
        }

        MotionResolver output = null;

        switch (input) {
            case "m":
                output = MotionResolver.MOVE_FORWARD;
                break;
            case "l":
                output = MotionResolver.ROTATE_LEFT;
                break;
            case "r":
                output = MotionResolver.ROTATE_RIGHT;
                break;
        }

        return  output;
    }



}
