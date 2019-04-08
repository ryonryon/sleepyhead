package alarm.Sudoku;

public class Coordinate {

    private int xCoordinate;
    private int yCoordinate;
    private int boxCoordinate;
    private int value;

    public Coordinate(int x, int y, int value) {

        this.xCoordinate = x + 1;
        this.yCoordinate = y + 1;
        this.boxCoordinate = getBoxCoordinateFromXY(x, y);
        this.value = value;

    }

    /**
     * @return the xCoordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
     * @param xCoordinate the xCoordinate to set
     */
    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * @return the yCoordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**
     * @param yCoordinate the yCoordinate to set
     */
    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * @return the boxCoordinate
     */
    public int getBoxCoordinate() {
        return boxCoordinate;
    }

    /**
     * @param boxCoordinate the boxCoordinate to set
     */
    public void setBoxCoordinate(int boxCoordinate) {
        this.boxCoordinate = boxCoordinate;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    public int getBoxCoordinateFromXY(int x, int y){

        if(x == 0 && y == 0) {return 1;}
        if(x == 1 && y == 0) {return 1;}
        if(x == 2 && y == 0) {return 1;}
        if(x == 0 && y == 1) {return 1;}
        if(x == 1 && y == 1) {return 1;}
        if(x == 2 && y == 1) {return 1;}
        if(x == 0 && y == 2) {return 1;}
        if(x == 1 && y == 2) {return 1;}
        if(x == 2 && y == 2) {return 1;}

        if(x == 3 && y == 0) {return 2;}
        if(x == 4 && y == 0) {return 2;}
        if(x == 5 && y == 0) {return 2;}
        if(x == 3 && y == 1) {return 2;}
        if(x == 4 && y == 1) {return 2;}
        if(x == 5 && y == 1) {return 2;}
        if(x == 3 && y == 2) {return 2;}
        if(x == 4 && y == 2) {return 2;}
        if(x == 5 && y == 2) {return 2;}

        if(x == 6 && y == 0) {return 3;}
        if(x == 7 && y == 0) {return 3;}
        if(x == 8 && y == 0) {return 3;}
        if(x == 6 && y == 1) {return 3;}
        if(x == 7 && y == 1) {return 3;}
        if(x == 8 && y == 1) {return 3;}
        if(x == 6 && y == 2) {return 3;}
        if(x == 7 && y == 2) {return 3;}
        if(x == 8 && y == 2) {return 3;}

        if(x == 0 && y == 3) {return 4;}
        if(x == 1 && y == 3) {return 4;}
        if(x == 2 && y == 3) {return 4;}
        if(x == 0 && y == 4) {return 4;}
        if(x == 1 && y == 4) {return 4;}
        if(x == 2 && y == 4) {return 4;}
        if(x == 0 && y == 5) {return 4;}
        if(x == 1 && y == 5) {return 4;}
        if(x == 2 && y == 5) {return 4;}

        if(x == 3 && y == 3) {return 5;}
        if(x == 4 && y == 3) {return 5;}
        if(x == 5 && y == 3) {return 5;}
        if(x == 3 && y == 4) {return 5;}
        if(x == 4 && y == 4) {return 5;}
        if(x == 5 && y == 4) {return 5;}
        if(x == 3 && y == 5) {return 5;}
        if(x == 4 && y == 5) {return 5;}
        if(x == 5 && y == 5) {return 5;}

        if(x == 6 && y == 3) {return 6;}
        if(x == 7 && y == 3) {return 6;}
        if(x == 8 && y == 3) {return 6;}
        if(x == 6 && y == 4) {return 6;}
        if(x == 7 && y == 4) {return 6;}
        if(x == 8 && y == 4) {return 6;}
        if(x == 6 && y == 5) {return 6;}
        if(x == 7 && y == 5) {return 6;}
        if(x == 8 && y == 5) {return 6;}

        if(x == 0 && y == 6) {return 7;}
        if(x == 1 && y == 6) {return 7;}
        if(x == 2 && y == 6) {return 7;}
        if(x == 0 && y == 7) {return 7;}
        if(x == 1 && y == 7) {return 7;}
        if(x == 2 && y == 7) {return 7;}
        if(x == 0 && y == 8) {return 7;}
        if(x == 1 && y == 8) {return 7;}
        if(x == 2 && y == 8) {return 7;}

        if(x == 3 && y == 6) {return 8;}
        if(x == 4 && y == 6) {return 8;}
        if(x == 5 && y == 6) {return 8;}
        if(x == 3 && y == 7) {return 8;}
        if(x == 4 && y == 7) {return 8;}
        if(x == 5 && y == 7) {return 8;}
        if(x == 3 && y == 8) {return 8;}
        if(x == 4 && y == 8) {return 8;}
        if(x == 5 && y == 8) {return 8;}

        if(x == 6 && y == 6) {return 9;}
        if(x == 7 && y == 6) {return 9;}
        if(x == 8 && y == 6) {return 9;}
        if(x == 6 && y == 7) {return 9;}
        if(x == 7 && y == 7) {return 9;}
        if(x == 8 && y == 7) {return 9;}
        if(x == 6 && y == 8) {return 9;}
        if(x == 7 && y == 8) {return 9;}
        if(x == 8 && y == 8) {return 9;}

        return 0;
    }
}
