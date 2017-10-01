package ProblemeDesReines;

import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The TestingUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 01/10/17 01:19
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class TestingUtils
{
    public static int getRandBetween (int min, int max)
    {
        return new Random().nextInt(max - min) + min;
    }

    public static boolean isInDelta (int expected, int obtained, double delta)
    {
        return Math.abs(obtained - expected) <= delta;
    }
}