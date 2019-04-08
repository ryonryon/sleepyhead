package minesweeper.Controller;

import java.util.ArrayList;

public class MinesweeperBoard {

    private int mapHeight;
    private int mapWidth;
    private ArrayList<Panel> mineSweeperBoard;

    public MinesweeperBoard(int mapHeight, int mapWidth) {

        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;

        mineSweeperBoard = new ArrayList<>();

        startGame();
    }

    private void startGame() {

        createPanels();

        setBombs();

        setNumberAroundBombs();

    }

    private void createPanels() {

        for(int i = 0; i < this.mapWidth; i++) {

            for(int j = 0; j < this.mapHeight; j++) {

                this.mineSweeperBoard.add(new Panel(i, j, Panel.BoxValue.Blank, 0));
            }
        }
    }

    private void setBombs() {
        // TODO not yet finished

    }

    private void setNumberAroundBombs() {
        // TODO not yet finished

    }

    public void clickPanel(int x, int y) {

        for (Panel panel: this.mineSweeperBoard) {

            if(panel.getXCoordinate() == x && panel.getYCoordinate() == y) {

                Panel.StateAfterBoxOpen afterStatus = panel.boxOpen();

                if(afterStatus.equals(Panel.StateAfterBoxOpen.GameOver)) {

                    gameOver();
                }

                if(afterStatus.equals(Panel.StateAfterBoxOpen.Inducible)) {

                    clickPanel(x - 1, y - 1);
                    clickPanel(x, y - 1);
                    clickPanel(x + 1, y - 1);
                    clickPanel(x - 1, y);
                    clickPanel(x + 1, y);
                    clickPanel(x - 1, y + 1);
                    clickPanel(x, y - 1);
                    clickPanel(x + 1, y + 1);
                }

                if(afterStatus.equals(Panel.StateAfterBoxOpen.Error)) {

                    arrartError();
                }
            }
        }
    }

    public boolean isCompletion() {
        for (Panel panel: this.mineSweeperBoard) {

            if(panel.getBoxStatus() == Panel.BoxStatus.Close) {

                if(panel.getBoxValue() != Panel.BoxValue.Bomb) {
                    return false;
                }
            }
        }
        return true;
    }

    private void arrartError() {
    }

    private void gameOver() {

        for (Panel panel: this.mineSweeperBoard) {
            panel.boxOpen();
        }
    }


}
