package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import org.junit.Test;

import static ProblemeDesReines.TestingUtils.isInDelta;
import static ProblemeDesReines.chessPiece.ChessPieceType.Knight;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*................................................................................................................................
 . Copyright (c)
 .
 . The KnightTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 18:23
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class KnightTest {
    @Test
    public void applyPattern() throws Exception {
        int size = 100;
        int expected = 3666;
        int fiftyPercent = size * size / 2;

        ChessBoard chessBoard = new ChessBoard(size, size, Knight);
        ChessBoard.DataTransferObject dto;

        //Testing with an All range.
        dto = chessBoard.start(false);
        assertEquals(expected, dto.getMaxAmount());

        //Testing around 50% of All range.
        dto = chessBoard.start(fiftyPercent, false);
        assertTrue(isInDelta(expected, dto.getMaxAmount(), 48));
    }
}
