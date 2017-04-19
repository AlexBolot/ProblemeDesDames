package ProblemeDesReines.chessBoard;

/*................................................................................................................................
 . Copyright (c)
 .
 . The IChessBoard	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 19/04/17 16:45
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public interface IChessBoard
{
    int getStatus (int row, int col);
    
    void setStatus (int row, int col, int status);
}
