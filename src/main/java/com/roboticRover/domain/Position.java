package com.roboticRover.domain;


import com.roboticRover.domain.direction.CardinalPointsResolver;

import java.util.Objects;

/**
 * @author Efrem  on 4/12/19
 * @project java-test-project
 */

/**
 * Position is a model object that provides information on the Position of a rover
 * It takes xcoordinate (xcoord), ycoordinates(ycoord) and CardinalPointsResolver (cardinalP) as an input
 */
public class Position {


    private Integer xcoord;
    private Integer ycoord;
    private CardinalPointsResolver cardinalP;

    public Position(Integer xcoord, Integer ycoord, CardinalPointsResolver cardinalP) {


        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.cardinalP = cardinalP;
    }




    public Integer getXcoord() {
        return xcoord;
    }

    public Integer getYcoord() {
        return ycoord;
    }

    public CardinalPointsResolver getCardinalP() {
        return cardinalP;
    }

    public void setXcoord(Integer xcoord) {
        this.xcoord = xcoord;
    }

    public void setYcoord(Integer ycoord) {
        this.ycoord = ycoord;
    }

    public void setCardinalP(CardinalPointsResolver cardinalP) {
        this.cardinalP = cardinalP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(xcoord, position.xcoord) &&
                Objects.equals(ycoord, position.ycoord);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xcoord, ycoord);
    }
}
