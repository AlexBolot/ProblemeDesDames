package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Rook	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 19/04/17 16:45
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class Rook implements IChessPiece
{
    @Override
    public void applyPattern (Object sender, int row, int col)
    {
        if(!(sender instanceof ChessBoard)) return;
        
        ChessBoard chessBoard = (ChessBoard) sender;
        
        //region row
        for (int x = 0; x < chessBoard.width; x++)
        {
            if(chessBoard.getStatus(row, x) == 0) chessBoard.setStatus(row, x, -1);
        }
        //endregion
        //region column
        for (int y = 0; y < chessBoard.height; y++)
        {
            if(chessBoard.getStatus(y, col) == 0) chessBoard.setStatus(y, col, -1);
        }
        //endregion   
    }
}
