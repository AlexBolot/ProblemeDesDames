package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import ProblemeDesReines.chessBoard.IChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Queen	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 18:23
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 * The Queen class implements IChessPiece.<br>
 * Its pattern is : checking all around on full range.<br>
 * <br>
 * __ Class Dependency : ChessBoard, IChessPiece __
 */
public class Queen implements IChessPiece {
    /**
     * This method will apply a pattern on the [sender] ChessBoard.<br>
     * <br>
     * - Pattern : All around.<br>
     * - Range : Full.<br>
     * <br>
     * __ Class Dependency : ChessBoard __
     *
     * @param sender The ChessBoard to apply the pattern on.
     * @param row    The row index of the start cell.
     * @param col    The col index of the start cell.
     */
    @Override
    public void applyPattern(IChessBoard sender, int row, int col) {
        if (!(sender instanceof ChessBoard)) return;

        ChessBoard chessBoard = (ChessBoard) sender;

        int y, x;

        //region diagonale top left
        y = row;
        x = col;
        while (y > 0 && x > 0) {
            y--;
            x--;

            chessBoard.setStatus(y, x, -1);
        }
        //endregion
        //region diagonale top right
        y = row;
        x = col;
        while (y > 0 && x < chessBoard.width - 1) {
            y--;
            x++;

            chessBoard.setStatus(y, x, -1);
        }
        //endregion

        //region diagonale bottom left
        y = row;
        x = col;
        while (y < chessBoard.height - 1 && x > 0) {
            y++;
            x--;

            chessBoard.setStatus(y, x, -1);
        }
        //endregion
        //region diagonale bottom right
        y = row;
        x = col;
        while (y < chessBoard.height - 1 && x < chessBoard.width - 1) {
            y++;
            x++;

            chessBoard.setStatus(y, x, -1);
        }
        //endregion

        //region row
        for (x = 0; x < chessBoard.width; x++) {
            if (chessBoard.getStatus(row, x) == 0) chessBoard.setStatus(row, x, -1);
        }
        //endregion
        //region column
        for (y = 0; y < chessBoard.height; y++) {
            if (chessBoard.getStatus(y, col) == 0) chessBoard.setStatus(y, col, -1);
        }
        //endregion   
    }
}
