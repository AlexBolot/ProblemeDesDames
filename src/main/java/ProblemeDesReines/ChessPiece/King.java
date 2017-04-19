package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The King	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 19/04/17 16:45
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class King implements IChessPiece
{
    @Override
    public void applyPattern (Object sender, int row, int col)
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