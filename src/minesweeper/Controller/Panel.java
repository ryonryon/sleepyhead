package minesweeper;

public class Panel {

    private int xCoordinate;
    private int yCoordinate;
    private State state;
    private BoxValue boxValue;
    private int bomNumberAround;

    public Panel(int xCoordinate, int yCoordinate, BoxValue boxValue, int bomNumberAround) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.boxValue = boxValue;
        this.bomNumberAround = bomNumberAround;
    }

    public StateAfterBoxOpen boxOpen() {

        if(this.state == State.flagged || this.state == State.Opened) {
            return StateAfterBoxOpen.Nothing;
        }

        if(this.state == State.Close && this.boxValue == BoxValue.Bom) {
            return StateAfterBoxOpen.GameOver;
        }

        if(this.state == State.Close && this.boxValue == BoxValue.Blank) {
            return StateAfterBoxOpen.Nothing;
        }

        if(this.state == State.Close && this.boxValue == BoxValue.Numbers) {
            return StateAfterBoxOpen.Inducible;
        }

        return StateAfterBoxOpen.Error;
    }

    private enum State{
        Opened,
        Close,
        flagged
    }

    public enum BoxValue{
        Bom,
        Blank,
        Numbers
    }

    public enum StateAfterBoxOpen{
        Nothing,
        GameOver,
        Inducible,
        Error
    }
}
