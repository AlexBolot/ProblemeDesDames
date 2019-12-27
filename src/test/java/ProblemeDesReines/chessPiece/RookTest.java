package ProblemeDesReines.chessPiece;

import ProblemeDesReines.chessBoard.ChessBoard;
import org.junit.Test;

import static ProblemeDesReines.TestingUtils.isInDelta;
import static ProblemeDesReines.chessPiece.ChessPieceType.Rook;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*................................................................................................................................
 . Copyright (c)
 .
 . The RookTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 18:23
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class RookTest {
    @Test
    public void applyPattern() throws Exception {
        int size = 100;
        int expected = 100;
        int onePercent = size * size / 100;

        ChessBoard chessBoard = new ChessBoard(size, size, Rook);
        ChessBoard.DataTransferObject dto;

        //Testing with an All range.
        dto = chessBoard.start(false);
        assertEquals(expected, dto.getMaxAmount());

        //Testing around 1% of All range.
        dto = chessBoard.start(onePercent, false);
        assertTrue(isInDelta(expected, dto.getMaxAmount(), 0));
    }
}