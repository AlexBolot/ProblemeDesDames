package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Pawn	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 19/04/17 20:08
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class Pawn implements IChessPiece
{
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
