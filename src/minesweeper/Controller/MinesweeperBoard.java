package minesweeper.Controller;

import java.util.ArrayList;
import java.util.Random;

public class MinesweeperBoard {

    private int mapHeight;
    private int mapWidth;
    private ArrayList<Panel> mineSweeperBoard;

    public MinesweeperBoard(int mapHeight, int mapWidth) {

        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;

        mineSweeperBoard = new ArrayList<Panel>();

        startGame();
    }

    private void startGame() {

        // create Panels
        for(int i = 0; i < this.mapWidth; i++) {

            for(int j = 0; j < this.mapHeight; j++) {
                this.mineSweeperBoard.add(new Panel(i, j, Panel.BoxValue.Blank, 0));
            }
        }

        // set Bom
        Random rand = new Random();
        int bomCount = (int)Math.ceil(this.mineSweeperBoard.size() * 0.13);
        int[][] randomBomcoordinate = new int[bomCount][];

        for(int k = 0; k < bomCount; k++) {

        }

        // set Number around Bom

    }

    public void clickPanel(int x, int y) {


    }

    private void gameOver() {

        // TODO Open all panel

    }
}
