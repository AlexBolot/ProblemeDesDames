package ProblemeDesReines;

import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The TestingUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 18:23
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class TestingUtils {
    public static int getRandBetween(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    public static boolean isInDelta(int expected, int obtained, double delta) {
        return Math.abs(obtained - expected) <= delta;
    }
}