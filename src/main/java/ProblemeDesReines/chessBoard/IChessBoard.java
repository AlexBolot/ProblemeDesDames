package ProblemeDesReines.chessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The IChessBoard	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 18:23
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 * This Interface forces the getStatus and setStatus method.<br>
 * Here we use it to ensure all ChessBoards will implement these methods so the ChessPieces can call them.
 */
public interface IChessBoard {
    /**
     * This method will look for the value in the cell at {[row], [col]} in the ChessBoard's grid.<br>
     *
     * @param row Index of the row of the cell to be read.
     * @param col Index of the column of the cell to be read.
     * @return The value found in the ChessBoard at coords {[row], [col]}.
     */
    int getStatus(int row, int col);


    /**
     * This method will over-write the value in the cell at {[row], [col]} in the ChessBoard's grid.<br>
     *
     * @param row    Index of the row of the cell to be updated.
     * @param col    Index of the column of the cell to be updated.
     * @param status New value of the cell to be updated.
     */
    void setStatus(int row, int col, int status);
}
