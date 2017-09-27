package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Pawn	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/09/17 22:56
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 The Pawn class implements IChessPiece.<br>
 Its pattern is : checking diagonals on a 1 cell range.<br>
 <br>
 __ Class Dependency : ChessBoard, IChessPiece __
 */
public class Pawn implements IChessPiece
{
    /**
     This method will apply a pattern on the [sender] ChessBoard.<br>
     <br>
     - Pattern : Diagonals.<br>
     - Range : 1 cell.<br>
     <br>
     __ Class Dependency : ChessBoard __

     @param sender The ChessBoard to apply the pattern on.
     @param row    The row number of the start cell.
     @param col    The col number of the start cell.
     */
    @Override
    public void applyPattern (Object sender, int row, int col)
    {
        if(!(sender instanceof ChessBoard)) return;

        ChessBoard board = (ChessBoard) sender;

        //Check top left
        if(row > 0 && col > 0 && board.getStatus(row - 1, col - 1) == 0) board.setStatus(row - 1, col - 1, -1);
        //Check bottom right
        if(row > 0 && col < board.width - 1 && board.getStatus(row - 1, col + 1) == 0) board.setStatus(row - 1, col + 1, -1);
        //Check bottom left
        if(row < board.height - 1 && col > 0 && board.getStatus(row + 1, col - 1) == 0) board.setStatus(row + 1, col - 1, -1);
        //Check bottom right
        if(row < board.height - 1 && col < board.width - 1 && board.getStatus(row + 1, col + 1) == 0) board.setStatus(row + 1, col + 1, -1);
    }
}
