package ProblemeDesReines;

import ProblemeDesReines.chessBoard.ChessBoard;
import ProblemeDesReines.chessPiece.ChessPieceType;

import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 19/04/17 17:12
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class App
{
    public static void main (String[] args)
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
        //endregion
    
        ChessBoard chessBoard = new ChessBoard(width, height, pieceType);
    
        if(attemptsToDo.equalsIgnoreCase("All"))
        {
            chessBoard.start();
        }
        else
        {
            chessBoard.start(Integer.parseInt(attemptsToDo));
        }
    }
}