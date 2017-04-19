package ProblemeDesReines;

import ProblemeDesReines.chessBoard.ChessBoard;
import ProblemeDesReines.chessPiece.ChessPieceType;

import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 19/04/17 20:08
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class App
{
    public static void main (String[] args)
    {
        while (true)
        {
            //region initialization
            Scanner scanner = new Scanner(System.in);
        
            System.out.print("Select Width : ");
        
            int width = Integer.parseInt(scanner.nextLine());
        
            System.out.print("Select Height : ");
        
            int height = Integer.parseInt(scanner.nextLine());
        
            System.out.println("Queen - King - Rook - Bishop - Knight - Pawn");
            System.out.print("Select ChessPiece : ");
        
            ChessPieceType pieceType = ChessPieceType.valueOf(scanner.nextLine());
        
            System.out.print("Select how many attempts : ");
        
            String attemptsToDo = scanner.nextLine();
            if(attemptsToDo.equalsIgnoreCase("Stop")) return;
        
            System.out.print("Print result (Y/N) :");
        
            boolean printResult = scanner.nextLine().contains("Y");
        
            //endregion
        
            ChessBoard chessBoard = new ChessBoard(width, height, pieceType);
            String result;
        
            if(attemptsToDo.equalsIgnoreCase("All"))
            {
                result = chessBoard.start(printResult);
            }
            else
            {
                result = chessBoard.start(Integer.parseInt(attemptsToDo), printResult);
            }
        
            StringBuilder output = new StringBuilder();
            output.append("\n");
            output.append(result.split(";")[0]);
            output.append(" ");
            output.append(pieceType.name()).append("s");
            output.append(" - ");
            output.append(result.split(";")[1]);
            output.append(" milis").append("\n");
        
            System.out.println(output);
        }
    }
}