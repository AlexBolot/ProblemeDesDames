package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import ProblemeDesReines.chessBoard.IChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Knight	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 18:23
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 * The Knight class implements IChessPiece.<br>
 * Its pattern is : checking in a L shape (vector {1,2}) for 1 L of range.<br>
 * <br>
 * __ Class Dependency : ChessBoard, IChessPiece __
 */
public class Knight implements IChessPiece {
    /**
     * This method will apply a pattern on the [sender] ChessBoard.<br>
     * <br>
     * - Pattern : L shape -> vector {2,1}.<br>
     * - Range : 1 L.<br>
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

        ChessBoard board = (ChessBoard) sender;

        //Check 1/8
        if (row > 1 && col < board.width - 1) board.setStatus(row - 2, col + 1, -1);
        //Check 2/8
        if (row > 0 && col < board.width - 2) board.setStatus(row - 1, col + 2, -1);
        //Check 3/8
        if (row < board.height - 1 && col < board.width - 2) board.setStatus(row + 1, col + 2, -1);
        //Check 4/8
        if (row < board.height - 2 && col < board.width - 1) board.setStatus(row + 2, col + 1, -1);
        //Check 5/8
        if (row < board.height - 2 && col > 0) board.setStatus(row + 2, col - 1, -1);
        //Check 6/8
        if (row < board.height - 1 && col > 1) board.setStatus(row + 1, col - 2, -1);
        //Check 7/8
        if (row > 0 && col > 1) board.setStatus(row - 1, col - 2, -1);
        //Check 8/8
        if (row > 1 && col > 0) board.setStatus(row - 2, col - 1, -1);
    }
}
