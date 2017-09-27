package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.IChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The IChessPiece	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/09/17 22:58
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 This Interface forces the applyPattern method.<br>
 Here we use it to ensure all ChessPieces will implement this method.
 */
public interface IChessPiece
{
    /**
     This method will apply a pattern on the [sender] ChessBoard.<br>

     @param sender The ChessBoard to apply the pattern on.
     @param row    The row number of the start cell.
     @param col    The col number of the start cell.
     */
    void applyPattern (IChessBoard sender, int row, int col);
}