package com.roboticRover.domain.direction;

/**
 * @author Efrem  on 5/2/19
 * @project java-test-project
 */

/**
 * CardinalPointsResolver provides objects of the cardinal points and handles the motion inputs
 *
 */

public enum CardinalPointsResolver {

    NORTH(0, 0, 1),
    EAST(1, 1, 0),
    SOUTH(2, 0, -1),
    WEST(3, -1, 0);

    private final int dx, dy;
    private final int left, right;


    private CardinalPointsResolver(int ordinal, int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        this.left = (ordinal + 3) % 4;
        this.right = (ordinal + 1) % 4;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public CardinalPointsResolver rotateLeft() {
        return values()[left];
    }

    public CardinalPointsResolver rotateRight() {
        return values()[right];
    }


    public static CardinalPointsResolver getCardinalPoints(String str) {
        CardinalPointsResolver output = null;

        switch (str) {
            case "n":
                output = CardinalPointsResolver.NORTH;
                break;
            case "s":
                output = CardinalPointsResolver.SOUTH;
                break;
            case "e":
                output = CardinalPointsResolver.EAST;
                break;
            case "w":
                output = CardinalPointsResolver.WEST;
                break;
        }

        return  output;
    }


}
