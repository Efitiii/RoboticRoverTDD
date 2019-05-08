package com.roboticRover.domain;

/**
 * @author Efrem  on 4/12/19
 * @project java-test-project
 */
/**
 * Plateau is a model object that provides information on the Plateau
 * it initializes the maximum x coordinate and maximum y coordinate for the rover to operate
 */
public class Plateau {

    private final  Integer max_X_Coord;
    private final  Integer max_Y_Coord;

    public Plateau(Integer max_X_Coord, Integer max_Y_Coord){
        this.max_X_Coord=max_X_Coord;
        this.max_Y_Coord=max_Y_Coord;
    }


    public Integer getMax_X_Coord() {
        return max_X_Coord;
    }

    public Integer getMax_Y_Coord() {
        return max_Y_Coord;
    }

}
