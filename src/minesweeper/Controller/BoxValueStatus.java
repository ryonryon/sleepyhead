package minesweeper.Controller;

public class BoxValueStatus {

    private BoxValue boxValue;

    private BoxStatus boxStatus;

    public BoxValueStatus() {

        this.boxValue = BoxValue.Blank;
        this.boxStatus = BoxStatus.Close;
    }

    public BoxValue getBoxValue() {
        return boxValue;
    }

    public void setBoxValue(BoxValue boxValue) {
        this.boxValue = boxValue;
    }

    public BoxStatus getBoxStatus() {
        return boxStatus;
    }

    public void setBoxStatus(BoxStatus boxStatus) {
        this.boxStatus = boxStatus;
    }

    public enum BoxValue{

        Bomb,
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

    public enum BoxStatus{

        Opened,
        Close,
        flagged
    }
}
