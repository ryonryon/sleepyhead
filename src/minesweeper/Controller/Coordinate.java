package minesweeper.Controller;

import java.util.Objects;

public class Coordinate {

    private final int xCoordinate;
    private final int yCoordinate;

    public Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj == null) return false;

        if(getClass() != obj.getClass()) return false;

        Coordinate coordinate = (Coordinate) obj;

        return this.xCoordinate == coordinate.xCoordinate && this.yCoordinate == coordinate.yCoordinate;
    }
}
