package minesweeper.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Minesweeper {

    public Map<Coordinate, BoxValueStatus> getPanel() {
        return panel;
    }

    private Map<Coordinate, BoxValueStatus> panel;
    private ButtonType buttonType;

    public Minesweeper(int panelRowNum, int panelColumnNum) {

        buttonType = ButtonType.Open;

        createPanels(panelRowNum, panelColumnNum);

        setBombs(panelRowNum, panelColumnNum);

    }

    public void putFlag(int x, int y) {

        if(this.panel.get(new Coordinate(x, y)).getBoxStatus() == BoxValueStatus.BoxStatus.flagged) {

            this.panel.get(new Coordinate(x, y)).setBoxStatus(BoxValueStatus.BoxStatus.Close);

        } else if(this.panel.get(new Coordinate(x, y)).getBoxStatus() == BoxValueStatus.BoxStatus.Close) {

            this.panel.get(new Coordinate(x, y)).setBoxStatus(BoxValueStatus.BoxStatus.flagged);
        }
    }

    public void openPanel(int x, int y) {

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_1
                || this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_2
                || this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_3
                || this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_4
                || this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_5
                || this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_6
                || this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_7
                || this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_8
        ) {
            this.panel.get(new Coordinate(x, y)).setBoxStatus(BoxValueStatus.BoxStatus.Opened);

        }

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Bomb) {

            gameOver();
        }

        openPanel(x - 1, y - 1);
        openPanel(x, y - 1);
        openPanel(x + 1, y - 1);
        openPanel(x - 1, y);
        openPanel(x + 1, y);
        openPanel(x + 1, y + 1);
        openPanel(x, y + 1);
        openPanel(x + 1, y + 1);
    }

    public boolean isCompletion() {

        for (BoxValueStatus valStatus : this.panel.values()) {

            if(valStatus.getBoxStatus() == BoxValueStatus.BoxStatus.Opened) {

                continue;
            }

            if(valStatus.getBoxStatus() == BoxValueStatus.BoxStatus.Close
                    && valStatus.getBoxValue() != BoxValueStatus.BoxValue.Bomb) {

                return false;
            }

            if(valStatus.getBoxStatus() == BoxValueStatus.BoxStatus.flagged
                    && valStatus.getBoxValue() != BoxValueStatus.BoxValue.Bomb) {

                return false;
            }
        }

        return true;
    }

    public void toggleButtonType() {

        if(this.buttonType == ButtonType.Open) {

            this.buttonType = ButtonType.Flag;

        } else {

            this.buttonType = ButtonType.Open;
        }
    }

    public void restartMinesweeper(int panelRowNum, int panelColumnNum) {

        for (BoxValueStatus valStatus : this.panel.values()) {
            valStatus.setBoxStatus(BoxValueStatus.BoxStatus.Close);
        }

        setBombs(panelRowNum, panelColumnNum);
    }

    private void createPanels(int panelRowNum, int panelColumnNum) {

        panel = new HashMap<>();

        for(int i = 0; i < panelRowNum; i++) {

            for(int j = 0; j < panelColumnNum; j++) {

                this.panel.put(new Coordinate(i, j), new BoxValueStatus());

            }
        }
    }

    private void setBombs(int panelRowNum, int panelColumnNum) {

        int bombNumber = (int)Math.ceil((double)panelRowNum * panelColumnNum / 10);

        for(int i = 0; i < bombNumber; i++) {
            int[] randomNums = getRandom(panelRowNum, panelColumnNum);

            if(this.panel.get(new Coordinate(randomNums[0], randomNums[1])).getBoxValue()
                    != BoxValueStatus.BoxValue.Blank){
                i--;
                continue;
            }

            this.panel.get(new Coordinate(randomNums[0], randomNums[1])).setBoxValue(BoxValueStatus.BoxValue.Bomb);

            setNumberAroundBombs(randomNums[0], randomNums[1]);
        }
    }

    private int[] getRandom(int panelRowNum, int panelColumnNum) {

        Random random = new Random();
        int random0 = random.nextInt(panelRowNum);
        int random1 = random.nextInt(panelColumnNum);

        int[] randomIntArr = {random0, random1};

        return randomIntArr;
    }

    private void setNumberAroundBombs(int x, int y) {

        if(this.panel.get(new Coordinate(x - 1, y - 1)).getBoxValue() != BoxValueStatus.BoxValue.Bomb){
            incrementNumber(x - 1, y - 1);
        }

        if(this.panel.get(new Coordinate(x, y - 1)).getBoxValue() != BoxValueStatus.BoxValue.Bomb){
            incrementNumber(x, y - 1);
        }

        if(this.panel.get(new Coordinate(x + 1, y - 1)).getBoxValue() != BoxValueStatus.BoxValue.Bomb){
            incrementNumber(x + 1, y - 1);
        }

        if(this.panel.get(new Coordinate(x - 1, y)).getBoxValue() != BoxValueStatus.BoxValue.Bomb){
            incrementNumber(x - 1, y - 1);
        }

        if(this.panel.get(new Coordinate(x + 1, y)).getBoxValue() != BoxValueStatus.BoxValue.Bomb){
            incrementNumber(x + 1, y - 1);
        }

        if(this.panel.get(new Coordinate(x - 1, y + 1)).getBoxValue() != BoxValueStatus.BoxValue.Bomb){
            incrementNumber(x - 1, y + 1);
        }

        if(this.panel.get(new Coordinate(x, y + 1)).getBoxValue() != BoxValueStatus.BoxValue.Bomb){
            incrementNumber(x, y + 1);
        }

        if(this.panel.get(new Coordinate(x + 1, y + 1)).getBoxValue() != BoxValueStatus.BoxValue.Bomb){
            incrementNumber(x + 1, y + 1);
        }

    }

    private void incrementNumber(int x, int y){

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Blank) {
            this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_1);
        }

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_1) {
            this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_2);
        }

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_2) {
            this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_3);
        }

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_3) {
            this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_4);
        }

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_4) {
            this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_5);
        }

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_5) {
            this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_6);
        }

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_6) {
            this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_7);
        }

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_7) {
            this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_8);
        }
    }

    private void gameOver() {

        for (BoxValueStatus valStatus : this.panel.values()) {
            valStatus.setBoxStatus(BoxValueStatus.BoxStatus.Opened);
        }
    }

    private enum ButtonType{
        Open,
        Flag
    }
}
