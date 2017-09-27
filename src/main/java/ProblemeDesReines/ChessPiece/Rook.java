package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Rook	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/09/17 22:56
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 The Rook class implements IChessPiece.<br>
 Its pattern is : checking horizontal and vertical axis on full range.<br>
 <br>
 __ Class Dependency : ChessBoard, IChessPiece __
 */
public class Rook implements IChessPiece
{
    /**
     This method will apply a pattern on the [sender] ChessBoard.<br>
     <br>
     - Pattern : Horizontal and Vertical axis.<br>
     - Range : Full.<br>
     <br>
     __ Class Dependency : ChessBoard __

     @param sender The ChessBoard to apply the pattern on.
     @param row    The row number of the start cell.
     @param col    The col number of the start cell.
     */
    @Override
    public void applyPattern (Object sender, int row, int col)
    {
        if (!(sender instanceof ChessBoard)) return;

        ChessBoard chessBoard = (ChessBoard) sender;

        //region row
        for (int x = 0; x < chessBoard.width; x++)
        {
            if (chessBoard.getStatus(row, x) == 0) chessBoard.setStatus(row, x, -1);
        }
        //endregion
        //region column
        for (int y = 0; y < chessBoard.height; y++)
        {
            if (chessBoard.getStatus(y, col) == 0) chessBoard.setStatus(y, col, -1);
        }
        //endregion   
    }
}
