package minesweeper.Controller;

public class Panel {

    private int xCoordinate;
    private int yCoordinate;
    private BoxStatus boxStatus;
    private BoxValue boxValue;
    private int bomNumberAround;

    public Panel(int xCoordinate, int yCoordinate, BoxValue boxValue, int bomNumberAround) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.boxValue = boxValue;
        this.bomNumberAround = bomNumberAround;
    }

    public StateAfterBoxOpen boxOpen() {

        if(this.boxStatus == BoxStatus.flagged || this.boxStatus == BoxStatus.Opened) {
            return StateAfterBoxOpen.Nothing;
        }

        if(this.boxStatus == BoxStatus.Close && this.boxValue == BoxValue.Bom) {
            return StateAfterBoxOpen.GameOver;
        }

        if(this.boxStatus == BoxStatus.Close && this.boxValue == BoxValue.Blank) {
            return StateAfterBoxOpen.Inducible;
        }

        if(
            this.boxStatus == BoxStatus.Close
            && this.boxValue == BoxValue.Number_1
            || this.boxValue == BoxValue.Number_2
            || this.boxValue == BoxValue.Number_3
            || this.boxValue == BoxValue.Number_4
            || this.boxValue == BoxValue.Number_5
            || this.boxValue == BoxValue.Number_6
            || this.boxValue == BoxValue.Number_7
            || this.boxValue == BoxValue.Number_8
        ) {
            return StateAfterBoxOpen.Nothing;
        }

        return StateAfterBoxOpen.Error;
    }

    private enum BoxStatus{

        Opened,
        Close,
        flagged
    }

    public enum BoxValue{

        Bom,
        Blank,
        Number_1,
        Number_2,
        Number_3,
        Number_4,
        Number_5,
        Number_6,
        Number_7,
        Number_8
    }

    public enum StateAfterBoxOpen{
        
        Nothing,
        GameOver,
        Inducible,
        Error
    }
}
