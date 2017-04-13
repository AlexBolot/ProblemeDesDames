package ProblemeDesReines;

import java.util.Random;
import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 14/04/17 00:25
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class App
{
    private static int[] grid;
    private static int   width, height, startX, startY;
    
    public static void main (String[] args)
    {
        //region initialization
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Select Width : ");
    
        width = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Select Height : ");
    
        height = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Select how many attempts : ");
    
        int attemptsToDo = Integer.parseInt(scanner.nextLine());
        //endregion
    
        grid = new int[width * height];
        int maxAmount = 0;
        long startTime = System.currentTimeMillis();
    
        for (int j = 0; j < attemptsToDo; j++)
        {
            for (int i = 0; i < width * height; i++)
            {
                grid[i] = 0;
            }
        
            startY = new Random().nextInt(height);
            startX = new Random().nextInt(width);
        
            solve(startY, startX);
        
            if(getPieceAmount() > maxAmount) maxAmount = getPieceAmount();
        }
    
        float deltaTime = System.currentTimeMillis() - startTime;
    
        //System.out.println(maxAmount + " - " + deltaTime/1000f + " s");
        System.out.println(maxAmount + " - " + deltaTime + " millis");
    }
    
    private static void solve (int row, int col)
    {
        while (true)
        {
            if(getStatus(row, col) == 0)
            {
                setStatus(row, col, 1);
    
                //System.out.println(row + " - " + col);
    
                int y, x;
                
                //region diagonale top left
                y = row;
                x = col;
                while (y > 0 && x > 0)
                {
                    y--;
                    x--;
    
                    setStatus(y, x, -1);
                }
                //endregion
                //region diagonale top right
                y = row;
                x = col;
                while (y > 0 && x < width - 1)
                {
                    y--;
                    x++;
    
                    setStatus(y, x, -1);
                }
                //endregion
    
                //region diagonale bottom left
                y = row;
                x = col;
                while (y < height - 1 && x > 0)
                {
                    y++;
                    x--;
    
                    setStatus(y, x, -1);
                }
                //endregion
                //region diagonale bottom right
                y = row;
                x = col;
                while (y < height - 1 && x < width - 1)
                {
                    y++;
                    x++;
    
                    setStatus(y, x, -1);
                }
                //endregion
    
                //region row
                for (x = 0; x < width; x++)
                {
                    if(getStatus(row, x) == 0) setStatus(row, x, -1);
                }
                //endregion
                //region column
                for (y = 0; y < height; y++)
                {
                    if(getStatus(y, col) == 0) setStatus(y, col, -1);
                }
                //endregion
            }
    
            //region change col and row for next case
            if(row == height - 1 && col == width - 1)
            {
                row = 0;
                col = 0;
            }
            else if(col < width - 1)
            {
                col++;
            }
            else
            {
                row++;
                col = 0;
            }
            //endregion
    
            if(row == startY && col == startX)
            {
                break;
            }
        }
    }
    
    private static int getStatus (int row, int col)
    {
        return grid[col + (row * width)];
    }
    
    private static void setStatus (int row, int col, int status)
    {
        grid[col + (row * width)] = status;
    }
    
    private static int getPieceAmount ()
    {
        int pieceAmount = 0;
        
        for (int i : grid)
        {
            if(i == 1) pieceAmount++;
        }
        
        return pieceAmount;
    }
}