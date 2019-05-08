package com.roboticRover.domain;

import java.util.regex.Pattern;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */

/**
 * InputField checks for the validity of the input fields
 */

public enum InputField {

    PLATEAU_FIELD(Pattern.compile("^[1-9]+\\s{1}[1-9]+$")),
    ROVER_FIELD(Pattern.compile("^[1-9]+\\s{1}[1-9]+\\s{1}[newsNEWS]{1}$")),
    MOTION_FIELD(Pattern.compile("^[lrmLRM]+"));


    private Pattern regex;

    InputField(Pattern pattern) {
        this.regex = pattern;
    }

    public Boolean matches(String text) {
        return regex.matcher(text).find();
    }


}
