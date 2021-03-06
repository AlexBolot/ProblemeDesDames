package ProblemeDesReines.chessBoard;

import ProblemeDesReines.chessPiece.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*................................................................................................................................
 . Copyright (c)
 .
 . The ChessBoard	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 18:23
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 * The ChessBoard class will handle the chess grid, its value and will be the one accessing it.<br>
 * It is also in charge of the pattern process : asking the [pieceType] to use <i>applyPattern()</i>.<br>
 */
public class ChessBoard implements IChessBoard {
    public int width, height;
    private int[] grid, optimalGrid;
    private int startX, startY;
    private ChessPieceType pieceType;

    /**
     * Simple Constructor of the ChessBoard Class.<br>
     *
     * @param width     Number of columns in the ChessBoard.
     * @param height    Number of rows in the ChessBoard.
     * @param pieceType Type of ChessPiece to be placed on the ChessBoard.
     */
    public ChessBoard(int width, int height, ChessPieceType pieceType) throws IllegalArgumentException {
        if (width <= 0) throw new IllegalArgumentException("Error : width not strictly positive");
        if (height <= 0) throw new IllegalArgumentException("Error : height not strictly positive");
        if (pieceType == null) throw new IllegalArgumentException("Error : PieceType is null");

        this.width = width;
        this.height = height;
        this.pieceType = pieceType;

        grid = new int[width * height];
    }

    /**
     * Puts all the grid's cells to 0.
     */
    private void initGrid() {
        for (int i = 0; i < width * height; i++) {
            grid[i] = 0;
        }
    }

    /**
     * This method will try to solve the MaxPieces problem on the grid.<br>
     * It will attempt it [width] x [height] times as it will try solving starting from every cell.<br>
     * <br>
     * <hr>
     * <h3>
     * Note : This is always 100% reliable but requires a more time as it tries all combinations
     * </h3>
     * <hr>
     *
     * @param printResult Does the user want to print the best combination grid on System.out ?
     * @return A String representation the informations to print to the user :<br>
     * —> max amount of pieces.<br>
     * —> duration of the process.<br>
     * —> amount of other combination with same amount of pieces.
     */
    public DataTransferObject start(boolean printResult) {
        int maxAmount = 0;
        int combinCount = 0;
        long startTime = System.nanoTime();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                initGrid();

                startY = y;
                startX = x;

                solve(startY, startX);

                //noinspection Duplicates
                if (getPieceAmount() > maxAmount) {
                    maxAmount = getPieceAmount();
                    combinCount = 1;
                    optimalGrid = grid.clone();
                } else if (getPieceAmount() == maxAmount) combinCount++;
            }
        }

        long deltaTime = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

        if (printResult) printGrid();

        return new DataTransferObject(maxAmount, deltaTime, combinCount);
    }

    /**
     * This method will try to solve the MaxPieces problem on the grid.<br>
     * It will attempt it [attemptsToDo] times, using new random start coords each time.<br>
     * <br>
     * <hr>
     * <h3>Notes :</h3>
     * — Note 1 : This is not always 100% reliable<br>
     * — Note 2 : MaxAttempt is the attempts of start(All) : [width] x [height]<br>
     * <br>
     * <hr>
     * <h3>Influence of increasing [attemptsToDo] :</h3>
     * — More reliable<br>
     * — Less performance<br>
     * <br>
     * <hr>
     * <h3>Accuracy tests :</h3>
     * 1. Rook : 100% reliable no matter [attemptsToDo]<br>
     * 2. King : 100% reliable no matter [attemptsToDo]<br>
     * 3. Pawn : 99% reliable. Can be trusted if [attemptsToDo] superior to 1% MaxAttempt<br>
     * 4. Queen : Mostly reliable => 25% of MaxAttempt —> 2% wrong and 1% delta.<br>
     * 5. Bishop : Mostly reliable => 50% of MaxAttempt —> 5% wrong and 0.5% delta.<br>
     * 6. Knight : Not very reliable => 50% of MaxAttempt —> 50% wrong and 0.45% delta.<br>
     * <br>
     * <hr>
     *
     * @param printResult Does the user want to print the best combination grid on System.out ?
     * @return A String representation the informations to print to the user :<br>
     * —> max amount of pieces.<br>
     * —> duration of the process.<br>
     * —> amount of other combination with same amount of pieces.
     */
    public DataTransferObject start(int attemptsToDo, boolean printResult) throws IllegalArgumentException {
        if (attemptsToDo <= 0) throw new IllegalArgumentException("Error : attemptsToDo not strictly positive");

        int maxAmount = 0;
        int combinCount = 0;
        long startTime = System.nanoTime();

        for (int j = 0; j < attemptsToDo; j++) {
            initGrid();

            startY = new Random().nextInt(height);
            startX = new Random().nextInt(width);

            solve(startY, startX);

            //noinspection Duplicates
            if (getPieceAmount() > maxAmount) {
                maxAmount = getPieceAmount();
                combinCount = 1;
                optimalGrid = grid.clone();
            } else if (getPieceAmount() == maxAmount) combinCount++;
        }

        long deltaTime = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

        if (printResult) printGrid();

        return new DataTransferObject(maxAmount, deltaTime, combinCount);
    }

    /**
     * This method is called to read and update the grid's cells' value.<br>
     * It uses <i>getStatus()</i>, <i>setStatus()</i> and <i>applyPattern()</i> to fill the grid.
     *
     * @param row The row index of the start cell.
     * @param col The column index of the start cell.
     */
    private void solve(int row, int col) {
        while (true) {
            if (getStatus(row, col) == 0) {
                setStatus(row, col, 1);

                applyPattern(row, col);
            }

            //region change col and row for next case
            if (row == height - 1 && col == width - 1) {
                row = 0;
                col = 0;
            } else if (col < width - 1) {
                col++;
            } else {
                row++;
                col = 0;
            }
            //endregion

            if (row == startY && col == startX) {
                break;
            }
        }
    }

    /**
     * This method will look for the value in the cell at {[row], [col]} in the ChessBoard's grid.<br>
     *
     * @param row Index of the row of the cell to be read.
     * @param col Index of the column of the cell to be read.
     * @return The value found in the ChessBoard at coords {[row], [col]}.
     */
    public int getStatus(int row, int col) {
        return grid[col + (row * width)];
    }

    /**
     * This method will over-write the value in the cell at {[row], [col]} in the ChessBoard's grid.<br>
     *
     * @param row    Index of the row of the cell to be updated.
     * @param col    Index of the column of the cell to be updated.
     * @param status New value of the cell to be updated.
     */
    public void setStatus(int row, int col, int status) {
        grid[col + (row * width)] = status;
    }

    /**
     * This method will call <i>applyPattern</i> from the ChessPiece class corresponding to [chessPieceType].<br>
     * It will the pass [row] and [col] as parameters.
     *
     * @param row The row index of the start cell.
     * @param col The col index of the start cell.
     */
    private void applyPattern(int row, int col) {
        switch (pieceType) {
            case Queen:
                new Queen().applyPattern(this, row, col);
                break;
            case King:
                new King().applyPattern(this, row, col);
                break;
            case Rook:
                new Rook().applyPattern(this, row, col);
                break;
            case Bishop:
                new Bishop().applyPattern(this, row, col);
                break;
            case Knight:
                new Knight().applyPattern(this, row, col);
                break;
            case Pawn:
                new Pawn().applyPattern(this, row, col);
                break;
        }
    }

    /**
     * Sums the amount of ChessPieces that were placed on the grid.
     *
     * @return the sum of the ChessPieces placed on the grid.
     */
    private int getPieceAmount() {
        int pieceAmount = 0;

        for (int i : grid) {
            if (i == 1) pieceAmount++;
        }

        return pieceAmount;
    }

    /**
     * Creates a StringBuilder to format the grid into an acutal visual grid.<br>
     * It catches <i>OutOfMemoryError</i> in case the StringBuilder can't handle all the characters.
     */
    private void printGrid() {
        try {
            StringBuilder outputGrid = new StringBuilder();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int val = optimalGrid[j + (i * width)];

                    if (val == 1) outputGrid.append(" 0 ").append("|");
                    if (val == -1) outputGrid.append(" - ").append("|");
                }
                outputGrid.deleteCharAt(outputGrid.length() - 1);
                outputGrid.append("\n");
            }

            System.out.println(outputGrid);

        } catch (OutOfMemoryError oome) {
            oome.printStackTrace();
        }
    }

    /**
     * Class used to easily return several informations from a mehtod
     */
    public class DataTransferObject {
        private int maxAmount;
        private long deltaTime;
        private int combinCount;

        DataTransferObject(int maxAmount, long deltaTime, int combinCount) {
            this.maxAmount = maxAmount;
            this.deltaTime = deltaTime;
            this.combinCount = combinCount;
        }

        public int getMaxAmount() {
            return maxAmount;
        }

        public long getDeltaTime() {
            return deltaTime;
        }

        public int getCombinCount() {
            return combinCount;
        }

    }
}