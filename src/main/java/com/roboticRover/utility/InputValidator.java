package com.roboticRover.utility;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */

@Component
public class InputValidator {


    public boolean validatePlateauInitialization(String input){

        Pattern regex= Pattern.compile("^[1-9]+\\s{1}[1-9]+$");
        Matcher plateauInitializationMatcher= regex.matcher(input);
        return plateauInitializationMatcher.matches();

    }


    public boolean validateRobotInitialization(String input){

        Pattern regex= Pattern.compile("^[1-9]+\\s{1}[1-9]+\\s{1}[newsNEWS]{1}$");
        Matcher plateauInitializationMatcher= regex.matcher(input);
        return plateauInitializationMatcher.matches();

    }

    public boolean validateRobotMotionInput(String input) {

        Pattern regex= Pattern.compile("^[lrmLRM]+");
        Matcher plateauInitializationMatcher= regex.matcher(input);
        return plateauInitializationMatcher.matches();

    }
}
