package com.javarush.games.game2048;
import com.javarush.engine.cell.*;


public class Game2048 extends Game {
    private static final int SIDE = 4;
    private boolean isGameStopped = false;
    private int score = 0;

    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {

                setCellColoredNumber(i, j, gameField[j][i]);
            }
        }

    }

    private void createNewNumber() {

        if (getMaxTileValue() >= 2048) {
            win();
            return;
        }

        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);

        if (gameField[x][y] != 0) {
            createNewNumber();
        } else {
            if (getRandomNumber(10) == 9) {
                gameField[x][y] = 4;
            } else {
                gameField[x][y] = 2;
            }
        }


    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        if (value != 0) {
            setCellValueEx(x, y, color, String.valueOf(value));
        } else {
            setCellValueEx(x, y, color, new String());
        }
    }

    private Color getColorByValue(int value) {
        Color color = Color.WHITE;
        switch (value) {
            case 0:
                color = Color.WHITE;
                break;

            case 2:
                color = Color.GOLD;
                break;
            case 4:
                color = Color.GOLDENROD;
                break;
            case 8:
                color = Color.GREENYELLOW;
                break;
            case 16:
                color = Color.GREEN;
                break;
            case 32:
                color = Color.GRAY;
                break;
            case 64:
                color = Color.MEDIUMPURPLE;
                break;
            case 128:
                color = Color.MEDIUMORCHID;
                break;
            case 256:
                color = Color.MEDIUMVIOLETRED;
                break;
            case 512:
                color = Color.MIDNIGHTBLUE;
                break;
            case 1024:
                color = Color.OLIVE;
                break;
            case 2048:
                color = Color.OLIVEDRAB;
                break;
            default:
                color = Color.WHITE;
                break;
        }
        return color;

    }

    private boolean compressRow(int[] row) {

        boolean b = false;
        for (int i = 0; i < row.length - 1; i++) {
            for (int j = 1; j < row.length; j++) {
                if (row[j - 1] == 0 && row[j] != 0) {
                    row[j - 1] = row[j];
                    row[j] = 0;
                    b = true;
                }
            }
        }
        return b;
    }

    private boolean mergeRow(int[] row) {
        boolean b = false;
        for (int i = 0; i < row.length - 1; i++) {
            if ((row[i] == row[i + 1]) && row[i] != 0) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                b = true;
                score += row[i];
                setScore(score);
            }
        }
        return b;
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                score = 0;
                setScore(score);
                drawScene();
            }
        } else {
            if (canUserMove()) {
                if (key == Key.LEFT) {
                    moveLeft();
                    drawScene();
                } else if (key == Key.RIGHT) {
                    moveRight();
                    drawScene();
                } else if (key == Key.UP) {
                    moveUp();
                    drawScene();
                } else if (key == Key.DOWN) {
                    moveDown();
                    drawScene();
                }
            } else {
                gameOver();
            }
        }
    }

    private void moveLeft() {
        boolean b = false;
        boolean c = false;
        boolean s = false;
        boolean change = false;
        for (int i = 0; i < 4; i++) {
            b = compressRow(gameField[i]);
            c = mergeRow(gameField[i]);
            s = compressRow(gameField[i]);
            if (b || c || s) {
                change = true;
            }
        }
        if (change) {
            createNewNumber();
        }

    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] resultArray = new int[SIDE][SIDE];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                resultArray[j][gameField.length - i - 1] = gameField[i][j];
            }
        }
        gameField = resultArray;
    }

    private int getMaxTileValue() {
        int max = gameField[0][0];
        for (int a = 0; a < gameField.length; a++) {
            for (int b = 0; b < gameField.length; b++) {
                if (gameField[a][b] > max) {
                    max = gameField[a][b];
                }
            }
        }
        return max;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE,
                "You win!", Color.BLACK, 70);
    }

    private boolean canUserMove() {
        for (int a = 0; a < gameField.length; a++) {
            for (int b = 0; b < gameField.length; b++) {
                if (gameField[a][b] == 0) {
                    return true;
                } else if ((a < gameField.length - 1) && gameField[a][b] == gameField[a + 1][b]) {
                    return true;
                } else if ((b < gameField.length - 1) && gameField[a][b] == gameField[a][b + 1]) {
                    return true;
                }
            }
        }
        return false;
    }


    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE,
                "Game over!", Color.BLACK, 70);
    }

}