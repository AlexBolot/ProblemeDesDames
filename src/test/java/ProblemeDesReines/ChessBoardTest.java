package ProblemeDesReines;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*................................................................................................................................
 . Copyright (c)
 .
 . The ChessBoardTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 14/04/17 10:33
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 Unit test for simple ChessBoard.
 */
public class ChessBoardTest extends TestCase
{
    /**
     Create the test case
     
     @param testName name of the test case
     */
    public ChessBoardTest (String testName)
    {
        super(testName);
    }
    
    /**
     @return the suite of tests being tested
     */
    public static Test suite ()
    {
        return new TestSuite(ChessBoardTest.class);
    }
    
    /**
     Rigourous Test :-)
     */
    public void testApp ()
    {
        assertTrue(true);
    }
}
