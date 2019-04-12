package minesweeper.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Minesweeper {

    private Map<Coordinate, BoxValueStatus> panel;
    private ButtonType buttonType;

    public Map<Coordinate, BoxValueStatus> getPanel() {
        return panel;
    }

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

        if(
            this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_1
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

        if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Blank) {

            this.panel.get(new Coordinate(x, y)).setBoxStatus(BoxValueStatus.BoxStatus.Opened);

            int i = x == 0 ? x : x - 1;

            int j = x == 10 - 1 ? x : x + 1;

            int k = y == 0 ? y : y - 1;

            int l = y == 10 - 1 ? y : y + 1;

            for(; i <= j; i++) {
                for(; k <= l; k++) {
                    if(i == x && k == y) {

                        continue;
                    }

                    openAroundPanel(i, k);
                }

                k =  y == 0 ? y : y - 1;
            }
        }
    }

    private void openAroundPanel(int x, int y) {

        if(this.panel.get(new Coordinate(x, y)).getBoxStatus() == BoxValueStatus.BoxStatus.Close) {

            if(
                    this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Number_1
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

            if(this.panel.get(new Coordinate(x, y)).getBoxValue() == BoxValueStatus.BoxValue.Blank) {

                this.panel.get(new Coordinate(x, y)).setBoxStatus(BoxValueStatus.BoxStatus.Opened);

                int i = x == 0 ? x : x - 1;

                int j = x == 10 - 1 ? x : x + 1;

                int k = y == 0 ? y : y - 1;

                int l = y == 10 - 1 ? y : y + 1;

                for(; i <= j; i++) {
                    for(; k <= l; k++) {
                        if(i == x && k == y) {

                            continue;
                        }
                        System.out.println();

                        openAroundPanel(i, k);
                    }

                    k =  y == 0 ? y : y - 1;
                }
            }
        }
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

            setNumberAroundBombs(randomNums[0], randomNums[1], panelRowNum, panelColumnNum);
        }
    }

    private int[] getRandom(int panelRowNum, int panelColumnNum) {

        Random random = new Random();
        int random0 = random.nextInt(panelRowNum);
        int random1 = random.nextInt(panelColumnNum);

        int[] randomIntArr = {random0, random1};

        return randomIntArr;
    }

    private void setNumberAroundBombs(int x, int y, int panelRowNum, int panelColumnNum) {

        int i = x == 0 ? x : x - 1;

        int j = x == panelRowNum - 1 ? x : x + 1;

        int k = y == 0 ? y : y - 1;

        int l = y == panelColumnNum - 1 ? y : y + 1;

        for(; i <= j; i++) {
            for(; k <= l; k++) {
                incrementNumber(i, k);
            }

            k =  y == 0 ? y : y - 1;
        }
    }

    private void incrementNumber(int x, int y){

        switch(this.panel.get(new Coordinate(x, y)).getBoxValue()) {

            case Blank:
                this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_1);
                break;

            case Number_1:
                this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_2);
                break;

            case Number_2:
                this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_3);
                break;

            case Number_3:
                this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_4);
                break;

            case Number_4:
                this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_5);
                break;

            case Number_5:
                this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_6);
                break;

            case Number_6:
                this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_7);
                break;

            case Number_7:
                this.panel.get(new Coordinate(x, y)).setBoxValue(BoxValueStatus.BoxValue.Number_8);
                break;
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
