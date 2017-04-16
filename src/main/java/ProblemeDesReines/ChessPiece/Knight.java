package ProblemeDesReines.ChessPiece;

import ProblemeDesReines.ChessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Knight	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 16/04/17 17:39
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class Knight implements IChessPiece
{
    @Override
    public void applyPattern (Object sender, int row, int col)
    {
        if(!(sender instanceof ChessBoard)) return;
        
        ChessBoard board = (ChessBoard) sender;
        
        //Check 1/8
        if(row > 1 && col < board.width - 1) board.setStatus(row - 2, col + 1, -1);
        //Check 2/8
        if(row > 0 && col < board.width - 2) board.setStatus(row - 1, col + 2, -1);
        //Check 3/8
        if(row < board.height - 1 && col < board.width - 2) board.setStatus(row + 1, col + 2, -1);
        //Check 4/8
        if(row < board.height - 2 && col < board.width - 1) board.setStatus(row + 2, col + 1, -1);
        //Check 5/8
        if(row < board.height - 2 && col > 0) board.setStatus(row + 2, col - 1, -1);
        //Check 6/8
        if(row < board.height - 1 && col > 1) board.setStatus(row + 1, col - 2, -1);
        //Check 7/8
        if(row > 0 && col > 1) board.setStatus(row - 1, col - 2, -1);
        //Check 8/8
        if(row > 1 && col > 0) board.setStatus(row - 2, col - 1, -1);
    }
}
