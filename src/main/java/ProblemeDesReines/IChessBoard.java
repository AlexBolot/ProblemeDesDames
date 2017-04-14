package ProblemeDesReines;

/*................................................................................................................................
 . Copyright (c)
 .
 . The IChessBoard	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 14/04/17 10:33
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public interface IChessBoard
{
    public int getStatus (int row, int col);
    
    public void setStatus (int row, int col, int status);
}
