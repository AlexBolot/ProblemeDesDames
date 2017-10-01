package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import org.junit.Test;

import static ProblemeDesReines.TestingUtils.isInDelta;
import static ProblemeDesReines.chessPiece.ChessPieceType.Pawn;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*................................................................................................................................
 . Copyright (c)
 .
 . The PawnTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 01/10/17 02:32
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class PawnTest
{
    @Test
    public void applyPattern () throws Exception
    {
        int size = 100;
        int expected = 5000;
        int onePercent = size * size / 100;

        ChessBoard chessBoard = new ChessBoard(size, size, Pawn);
        ChessBoard.DataTransferObject dto;

        //Testing with an All range.
        dto = chessBoard.start(false);
        assertEquals(expected, dto.getMaxAmount());

        //Testing around 1% of All range.
        dto = chessBoard.start(onePercent, false);
        assertTrue(isInDelta(expected, dto.getMaxAmount(), 2));
    }
}