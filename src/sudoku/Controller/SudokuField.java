package sudoku.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class SudokuField {

    private List<Coordinate> sudokuField;
    private String tempFileName;

    SudokuField() {

        this.tempFileName = getRandomSudokufile(2);

        setTemplate();
    }

    void setNumber(int x, int y, int value) {

        for (Coordinate square : this.sudokuField) {

            if(square.getxCoordinate() == x + 1 && square.getyCoordinate() == y + 1) {

                square.setValue(value);
            }
        }
    }

    void setTemplate(){

        try {
            this.sudokuField = new ArrayList<>();

            Scanner scanner = new Scanner(new File(this.tempFileName));

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

    private String getRandomSudokufile(int fileCount) {

        Random random = new Random();
        int fileNumber = random.nextInt(fileCount);

        return "../sleepyhead/src/sudoku/Controller/Questions/question_" + fileNumber + ".csv";
    }

    List<Coordinate> getSudokuField() {

        return this.sudokuField;
    }

    ArrayList<String> isCompletion() {

        ArrayList<String> errorList = new ArrayList<>();

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
            errorList.add(errorCoordinate.X1.name());
        }

        if(x2 != 45) {
            errorList.add(errorCoordinate.X2.name());
        }

        if(x3 != 45) {
            errorList.add(errorCoordinate.X3.name());
        }

        if(x4 != 45) {
            errorList.add(errorCoordinate.X4.name());
        }

        if(x5 != 45) {
            errorList.add(errorCoordinate.X5.name());
        }

        if(x6 != 45) {
            errorList.add(errorCoordinate.X6.name());
        }

        if(x7 != 45) {
            errorList.add(errorCoordinate.X7.name());
        }

        if(x8 != 45) {
            errorList.add(errorCoordinate.X8.name());
        }

        if(x9 != 45) {
            errorList.add(errorCoordinate.X9.name());
        }

        if(y1 != 45) {
            errorList.add(errorCoordinate.Y1.name());
        }

        if(y2 != 45) {
            errorList.add(errorCoordinate.Y2.name());
        }

        if(y3 != 45) {
            errorList.add(errorCoordinate.Y3.name());
        }

        if(y4 != 45) {
            errorList.add(errorCoordinate.Y4.name());
        }

        if(y5 != 45) {
            errorList.add(errorCoordinate.Y5.name());
        }

        if(y6 != 45) {
            errorList.add(errorCoordinate.Y6.name());
        }

        if(y7 != 45) {
            errorList.add(errorCoordinate.Y7.name());
        }

        if(y8 != 45) {
            errorList.add(errorCoordinate.Y8.name());
        }

        if(y9 != 45) {
            errorList.add(errorCoordinate.Y9.name());
        }

        if(box1 != 45) {
            errorList.add(errorCoordinate.BOX1.name());
        }

        if(box2 != 45) {
            errorList.add(errorCoordinate.BOX2.name());
        }

        if(box3 != 45) {
            errorList.add(errorCoordinate.BOX3.name());
        }

        if(box4 != 45) {
            errorList.add(errorCoordinate.BOX4.name());
        }

        if(box5 != 45) {
            errorList.add(errorCoordinate.BOX5.name());
        }

        if(box6 != 45) {
            errorList.add(errorCoordinate.BOX6.name());
        }

        if(box7 != 45) {
            errorList.add(errorCoordinate.BOX7.name());
        }

        if(box8 != 45) {
            errorList.add(errorCoordinate.BOX8.name());
        }

        if(box9 != 45) {
            errorList.add(errorCoordinate.BOX9.name());
        }

        return errorList;
    }

    public enum errorCoordinate{
        X1, X2, X3, X4, X5, X6, X7, X8, X9,
        Y1, Y2, Y3, Y4, Y5, Y6, Y7, Y8, Y9,
        BOX1, BOX2, BOX3, BOX4, BOX5, BOX6, BOX7, BOX8, BOX9,
    }
}
