package ProblemeDesReines.ChessPiece;

import ProblemeDesReines.ChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Bishop	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 16/04/17 17:39
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class Bishop implements IChessPiece
{
    public void applyPattern (Object sender, int row, int col)
    {
        if(!(sender instanceof ChessBoard)) return;
        
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
