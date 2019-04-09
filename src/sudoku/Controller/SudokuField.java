package sudoku.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class SudokuField {

    private List<Coordinate> sudokuField;

    SudokuField() {

        this.sudokuField = new ArrayList<>();

        setRandomTemplate();
    }

    void setNumber(int x, int y, int value) {

        for (Coordinate square : this.sudokuField) {

            if(square.getxCoordinate() == x + 1 && square.getyCoordinate() == y + 1) {

                square.setValue(value);
            }
        }
    }

    private void setRandomTemplate(){

        String fileName = getRandomSudokufile(2);

        try {
            Scanner scanner = new Scanner(new File(fileName));

            for (int row = 0; row < 9; row++) {

                String line= scanner.next();
                String[] values = line.split(",");

                for (int col = 0; col < 9; col++) {

                    this.sudokuField.add(new Coordinate(row, col, Integer.parseInt(values[col])));
                }
            }

        } catch (FileNotFoundException|NullPointerException e) {

            System.out.println("File not found");

        } catch (NumberFormatException e) {

            System.out.println("File data might be wrong");
        }
    }

    public void resetGame() {
        // TODO
    }

    private String getRandomSudokufile(int fileCount) {

        Random random = new Random();
        int fileNumber = random.nextInt(fileCount);

        return "../sleepyhead/src/sudoku/Controller/Questions/question_" + fileNumber + ".csv";
    }

    List<Coordinate> getSudokuField() {

        return this.sudokuField;
    }

    ArrayList<errorCoordinate> isCompletion() {

        ArrayList<errorCoordinate> errorList = new ArrayList<>();

        int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        int x4 = 0;
        int x5 = 0;
        int x6 = 0;
        int x7 = 0;
        int x8 = 0;
        int x9 = 0;

        int y1 = 0;
        int y2 = 0;
        int y3 = 0;
        int y4 = 0;
        int y5 = 0;
        int y6 = 0;
        int y7 = 0;
        int y8 = 0;
        int y9 = 0;

        int box1 = 0;
        int box2 = 0;
        int box3 = 0;
        int box4 = 0;
        int box5 = 0;
        int box6 = 0;
        int box7 = 0;
        int box8 = 0;
        int box9 = 0;

        for (Coordinate coordinate : this.sudokuField) {
            
            if(coordinate.getxCoordinate() == 1) {
                x1 += coordinate.getValue();
            }

            if(coordinate.getxCoordinate() == 1) {
                x1 += coordinate.getValue();
            }

            if(coordinate.getxCoordinate() == 2) {
                x2 += coordinate.getValue();
            }

            if(coordinate.getxCoordinate() == 3) {
                x3 += coordinate.getValue();
            }

            if(coordinate.getxCoordinate() == 4) {
                x4 += coordinate.getValue();
            }

            if(coordinate.getxCoordinate() == 5) {
                x5 += coordinate.getValue();
            }

            if(coordinate.getxCoordinate() == 6) {
                x6 += coordinate.getValue();
            }

            if(coordinate.getxCoordinate() == 7) {
                x7 += coordinate.getValue();
            }

            if(coordinate.getxCoordinate() == 8) {
                x8 += coordinate.getValue();
            }

            if(coordinate.getxCoordinate() == 9) {
                x9 += coordinate.getValue();
            }

            if(coordinate.getyCoordinate() == 1) {
                y1 += coordinate.getValue();
            }

            if(coordinate.getyCoordinate() == 2) {
                y2 += coordinate.getValue();
            }

            if(coordinate.getyCoordinate() == 3) {
                y3 += coordinate.getValue();
            }

            if(coordinate.getyCoordinate() == 4) {
                y4 += coordinate.getValue();
            }

            if(coordinate.getyCoordinate() == 5) {
                y5 += coordinate.getValue();
            }

            if(coordinate.getyCoordinate() == 6) {
                y6 += coordinate.getValue();
            }

            if(coordinate.getyCoordinate() == 7) {
                y7 += coordinate.getValue();
            }

            if(coordinate.getyCoordinate() == 8) {
                y8 += coordinate.getValue();
            }

            if(coordinate.getyCoordinate() == 9) {
                y9 += coordinate.getValue();
            }

            if(coordinate.getBoxCoordinate() == 1) {
                box1 += coordinate.getValue();
            }

            if(coordinate.getBoxCoordinate() == 2) {
                box2 += coordinate.getValue();
            }

            if(coordinate.getBoxCoordinate() == 3) {
                box3 += coordinate.getValue();
            }

            if(coordinate.getBoxCoordinate() == 4) {
                box4 += coordinate.getValue();
            }

            if(coordinate.getBoxCoordinate() == 5) {
                box5 += coordinate.getValue();
            }

            if(coordinate.getBoxCoordinate() == 6) {
                box6 += coordinate.getValue();
            }

            if(coordinate.getBoxCoordinate() == 7) {
                box7 += coordinate.getValue();
            }

            if(coordinate.getBoxCoordinate() == 8) {
                box8 += coordinate.getValue();
            }

            if(coordinate.getBoxCoordinate() == 9) {
                box9 += coordinate.getValue();
            }
        }

        if(x1 != 45) {
            errorList.add(errorCoordinate.X1);
        }

        if(x2 != 45) {
            errorList.add(errorCoordinate.X2);
        }

        if(x3 != 45) {
            errorList.add(errorCoordinate.X3);
        }

        if(x4 != 45) {
            errorList.add(errorCoordinate.X4);
        }

        if(x5 != 45) {
            errorList.add(errorCoordinate.X5);
        }

        if(x6 != 45) {
            errorList.add(errorCoordinate.X6);
        }

        if(x7 != 45) {
            errorList.add(errorCoordinate.X7);
        }

        if(x8 != 45) {
            errorList.add(errorCoordinate.X8);
        }

        if(x9 != 45) {
            errorList.add(errorCoordinate.X9);
        }

        if(y1 != 45) {
            errorList.add(errorCoordinate.Y1);
        }

        if(y2 != 45) {
            errorList.add(errorCoordinate.Y2);
        }

        if(y3 != 45) {
            errorList.add(errorCoordinate.Y3);
        }

        if(y4 != 45) {
            errorList.add(errorCoordinate.Y4);
        }

        if(y5 != 45) {
            errorList.add(errorCoordinate.Y5);
        }

        if(y6 != 45) {
            errorList.add(errorCoordinate.Y6);
        }

        if(y7 != 45) {
            errorList.add(errorCoordinate.Y7);
        }

        if(y8 != 45) {
            errorList.add(errorCoordinate.Y8);
        }

        if(y9 != 45) {
            errorList.add(errorCoordinate.Y9);
        }

        if(box1 != 45) {
            errorList.add(errorCoordinate.BOX1);
        }

        if(box2 != 45) {
            errorList.add(errorCoordinate.BOX2);
        }

        if(box3 != 45) {
            errorList.add(errorCoordinate.BOX3);
        }

        if(box4 != 45) {
            errorList.add(errorCoordinate.BOX4);
        }

        if(box5 != 45) {
            errorList.add(errorCoordinate.BOX5);
        }

        if(box6 != 45) {
            errorList.add(errorCoordinate.BOX6);
        }

        if(box7 != 45) {
            errorList.add(errorCoordinate.BOX7);
        }

        if(box8 != 45) {
            errorList.add(errorCoordinate.BOX8);
        }

        if(box9 != 45) {
            errorList.add(errorCoordinate.BOX9);
        }

        return errorList;
    }

    public enum errorCoordinate{
        X1, X2, X3, X4, X5, X6, X7, X8, X9,
        Y1, Y2, Y3, Y4, Y5, Y6, Y7, Y8, Y9,
        BOX1, BOX2, BOX3, BOX4, BOX5, BOX6, BOX7, BOX8, BOX9,
    }
}
