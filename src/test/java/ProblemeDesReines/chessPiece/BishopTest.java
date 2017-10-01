package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import org.junit.Test;

import static ProblemeDesReines.TestingUtils.isInDelta;
import static ProblemeDesReines.chessPiece.ChessPieceType.Bishop;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*................................................................................................................................
 . Copyright (c)
 .
 . The BishopTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 01/10/17 02:04
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class BishopTest
{
    @Test
    public void applyPattern () throws Exception
    {
        int size = 100;
        int expected = 198;
        int fiftyPercent = size * size / 2;

        ChessBoard chessBoard = new ChessBoard(size, size, Bishop);
        ChessBoard.DataTransferObject dto;

        //Testing with an All range.
        dto = chessBoard.start(false);
        assertEquals(expected, dto.getMaxAmount());

        //Testing around 50% of All range.
        dto = chessBoard.start(fiftyPercent, false);
        assertTrue(isInDelta(expected, dto.getMaxAmount(), 2));
    }
}
