package com.roboticRover.domain;

import java.util.Objects;

/**
 * @author Efrem  on 4/12/19
 * @project java-test-project
 */

/**
 * Rover is a model object that provides information on the Rover in the plateau.
 * It initializes the Position of the rover and its specific id.
 */
public class Rover {


    private final Integer id;
    private Position position;

    public Rover(Position position, Integer id) {
        this.position = position;

        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(id, rover.id) &&
                Objects.equals(position, rover.position);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
