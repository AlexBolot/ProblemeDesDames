package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import ProblemeDesReines.chessBoard.IChessBoard;


/*................................................................................................................................
 . Copyright (c)
 .
 . The Bishop	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/09/17 22:58
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 The Bishop class implements IChessPiece.<br>
 Its pattern is : checking diagonals on full range.<br>
 <br>
 __ Class Dependency : ChessBoard, IChessPiece __
 */
public class Bishop implements IChessPiece
{
    /**
     This method will apply a pattern on the [sender] ChessBoard.<br>
     <br>
     - Pattern : Diagonals.<br>
     - Range : Full.<br>
     <br>
     __ Class Dependency : ChessBoard __

     @param sender The ChessBoard to apply the pattern on.
     @param row    The row number of the start cell.
     @param col    The col number of the start cell.
     */
    public void applyPattern (IChessBoard sender, int row, int col)
    {
        if (!(sender instanceof ChessBoard)) return;

        ChessBoard chessBoard = (ChessBoard) sender;

        int y, x;

        //region diagonale top left
        y = row;
        x = col;
        while (y > 0 && x > 0)
        {
            y--;
            x--;

            chessBoard.setStatus(y, x, -1);
        }
        //endregion
        //region diagonale top right
        y = row;
        x = col;
        while (y > 0 && x < chessBoard.width - 1)
        {
            y--;
            x++;

            chessBoard.setStatus(y, x, -1);
        }
        //endregion

        //region diagonale bottom left
        y = row;
        x = col;
        while (y < chessBoard.height - 1 && x > 0)
        {
            y++;
            x--;

            chessBoard.setStatus(y, x, -1);
        }
        //endregion
        //region diagonale bottom right
        y = row;
        x = col;
        while (y < chessBoard.height - 1 && x < chessBoard.width - 1)
        {
            y++;
            x++;

            chessBoard.setStatus(y, x, -1);
        }
        //endregion
    }
}
