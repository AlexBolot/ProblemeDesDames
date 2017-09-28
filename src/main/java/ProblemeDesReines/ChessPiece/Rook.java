package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import ProblemeDesReines.chessBoard.IChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Rook	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 28/09/17 21:57
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
     @param row    The row index of the start cell.
     @param col    The col index of the start cell.
     */
    @Override
    public void applyPattern (IChessBoard sender, int row, int col)
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
