package ProblemeDesReines;

import ProblemeDesReines.chessBoard.ChessBoard;
import ProblemeDesReines.chessPiece.ChessPieceType;

import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 28/09/17 23:08
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ("ConstantConditions")
public class App
{
    public static void main (String[] args)
    {
        while (true)
        {
            //region initialization
            Scanner scanner = new Scanner(System.in);

            //region read Width and Height
            System.out.print("Select Width : ");
            int width = positiveIntTryParse(scanner.nextLine());

            System.out.print("Select Height : ");
            int height = positiveIntTryParse(scanner.nextLine());
            //endregion

            //region read PieceType
            System.out.println("Queen - King - Rook - Bishop - Knight - Pawn");
            System.out.print("Select ChessPiece : ");

            ChessPieceType pieceType = null;
            try
            {
                String pieceName = scanner.nextLine();
                String formatedPieceName = pieceName.substring(0, 1).toUpperCase() + pieceName.substring(1).toLowerCase();

                pieceType = ChessPieceType.valueOf(formatedPieceName);
            }
            catch (IllegalArgumentException iae)
            {
                printError(iae);
            }
            //endregion

            //region read Attempts
            System.out.print("Select how many attempts : ");

            String attemptsToDo = scanner.nextLine();
            int formatedAttemptsToDo = 0;

            if (attemptsToDo.equalsIgnoreCase("Stop")) return;

            if (!attemptsToDo.equalsIgnoreCase("All")) formatedAttemptsToDo = positiveIntTryParse(attemptsToDo);

            System.out.print("Print result (Y/N) :");

            boolean printResult = scanner.nextLine().contains("Y");

            //endregion

            //region init of ChessBoard chessBoard
            ChessBoard chessBoard = null;
            try
            {
                chessBoard = new ChessBoard(width, height, pieceType);
            }
            catch (IllegalArgumentException iae)
            {
                printError(iae);
            }
            //endregion

            //region init of String result
            String result;

            if (attemptsToDo.equalsIgnoreCase("All"))
            {
                result = chessBoard.start(printResult);
            }
            else
            {
                result = chessBoard.start(formatedAttemptsToDo, printResult);
            }
            //endregion

            //region printing the result
            StringBuilder output = new StringBuilder();
            output.append("\n");
            output.append(result.split(";")[0]);
            output.append(" ");
            output.append(pieceType.name()).append("s");
            output.append(" - ");
            output.append(result.split(";")[1]);
            output.append(" milis");
            output.append(" - ");
            output.append(result.split(";")[2]);
            output.append(" possible arangements");
            output.append("\n");

            System.out.println(output);
            System.out.println("\n\n");
            //endregion
        }
    }

    private static void printError (Exception e)
    {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < e.getMessage().length(); i++)
        {
            str.append("-");
        }

        str.append("\n").append(e.getMessage()).append("\n");

        for (int i = 0; i < e.getMessage().length(); i++)
        {
            str.append("-");
        }

        System.out.println(str);
        System.exit(1);
    }

    private static int positiveIntTryParse (String string)
    {
        int res = 0;

        try
        {
            res = Integer.parseInt(string);

            if (res <= 0) printError(new IllegalArgumentException("Error —> !(" + string + " > 0)"));
        }
        catch (NumberFormatException nfe)
        {
            printError(new IllegalArgumentException("Error —> '" + string + "' is not a number"));
        }

        return res;
    }
}