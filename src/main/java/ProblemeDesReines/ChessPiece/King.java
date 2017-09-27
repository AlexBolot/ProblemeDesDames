package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import ProblemeDesReines.chessBoard.IChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The King	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/09/17 22:58
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 The King class implements IChessPiece.<br>
 Its pattern is : checking all around on a 1 cell range.<br>
 <br>
 __ Class Dependency : ChessBoard, IChessPiece __
 */
public class King implements IChessPiece
{
    /**
     This method will apply a pattern on the [sender] ChessBoard.<br>
     <br>
     - Pattern : All around.<br>
     - Range : 1 cell.<br>
     <br>
     __ Class Dependency : ChessBoard __

     @param sender The ChessBoard to apply the pattern on.
     @param row    The row number of the start cell.
     @param col    The col number of the start cell.
     */
    @Override
    public void applyPattern (IChessBoard sender, int row, int col)
    {
        if(!(sender instanceof ChessBoard)) return;

        ChessBoard chessBoard = (ChessBoard) sender;

        //Check 0°
        if(row > 0) chessBoard.setStatus(row - 1, col, -1);

        //Check 30°
        if(row > 0 && col < chessBoard.width - 1) chessBoard.setStatus(row - 1, col + 1, -1);

        //Check 90°
        if(col < chessBoard.width - 1) chessBoard.setStatus(row, col + 1, -1);

        //Check 120°
        if(row < chessBoard.height - 1 && col < chessBoard.width - 1) chessBoard.setStatus(row + 1, col + 1, -1);

        //Check 180°
        if(row < chessBoard.height - 1) chessBoard.setStatus(row + 1, col, -1);

        //Check 240°
        if(row < chessBoard.height - 1 && col > 0) chessBoard.setStatus(row + 1, col - 1, -1);

        //Check 270°
        if(col > 0) chessBoard.setStatus(row, col - 1, -1);

        //Check 330°
        if(row > 0 && col > 0) chessBoard.setStatus(row - 1, col - 1, -1);
    }
}