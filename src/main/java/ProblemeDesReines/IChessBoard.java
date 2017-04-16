package ProblemeDesReines;

/*................................................................................................................................
 . Copyright (c)
 .
 . The IChessBoard	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 16/04/17 13:07
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public interface IChessBoard
{
    int getStatus (int row, int col);
    
    void setStatus (int row, int col, int status);
}
