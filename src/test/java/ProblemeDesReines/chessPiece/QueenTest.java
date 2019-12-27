package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import org.junit.Test;

import static ProblemeDesReines.TestingUtils.isInDelta;
import static ProblemeDesReines.chessPiece.ChessPieceType.Queen;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*................................................................................................................................
 . Copyright (c)
 .
 . The QueenTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 18:23
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class QueenTest {
    @Test
    public void applyPattern() throws Exception {
        int size = 100;
        int expected = 97;
        int twentyFivePercent = 2500;

        ChessBoard chessBoard = new ChessBoard(size, size, Queen);
        ChessBoard.DataTransferObject dto;

        //Testing with an All range.
        dto = chessBoard.start(false);
        assertEquals(expected, dto.getMaxAmount());

        //Testing around 25% of All range.
        dto = chessBoard.start(twentyFivePercent, false);
        assertTrue(isInDelta(expected, dto.getMaxAmount(), 1));
    }
}