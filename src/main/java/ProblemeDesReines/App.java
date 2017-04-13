package ProblemeDesReines;

import java.util.ArrayList;
import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 13/04/17 14:19
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class App
{
    private static ArrayList<Case> listCases = new ArrayList<Case>();
    private static int width, height, queenCount;
    
    public static void main (String[] args)
    {
        //region initialization
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Select Width : ");
    
        width = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Select Height : ");
    
        height = Integer.parseInt(scanner.nextLine());
        //endregion
    
        int row, col = 0;
    
        for (int i = 0; i < width * height; i++)
        {
            col = i % width;
            row = i / height;
    
            listCases.add(new Case(col, row));
        }
    
        solve(0, 0);
    
        System.out.println(queenCount);
    }
    
    private static void solve (int col, int row)
    {
        while (col < width - 1 || row < height - 1)
        {
            Case currentCase = getCase(col, row);
        
            if(currentCase.isAdmissible())
            {
                currentCase.setQueen(true);
                currentCase.setAdmissible(false);
                queenCount++;
            
                System.out.println(col + " - " + row);
            
                int x, y;
            
                //region diagonale top left
                x = col;
                y = row;
                while (x > 0 && y > 0)
                {
                    getCase(x, y).setAdmissible(false);
                
                    x--;
                    y--;
                }
                //endregion
                //region diagonale top right
                x = col;
                y = row;
                while (x < width && y > 0)
                {
                    getCase(x, y).setAdmissible(false);
                
                    x++;
                    y--;
                }
                //endregion
            
                //region diagonale bottom left
                x = col;
                y = row;
                while (x > 0 && y < height)
                {
                    getCase(x, y).setAdmissible(false);
                
                    x--;
                    y++;
                }
                //endregion
                //region diagonale bottom right
                x = col;
                y = row;
                while (x < width && y < height)
                {
                    getCase(x, y).setAdmissible(false);
                
                    x++;
                    y++;
                }
                //endregion
            
                //region row left
                x = col;
                y = row;
                while (x > 0)
                {
                    getCase(x, y).setAdmissible(false);
                
                    x--;
                }
                //endregion
                //region row right
                x = col;
                y = row;
                while (x < width)
                {
                    getCase(x, y).setAdmissible(false);
                
                    x++;
                }
                //endregion
            
                //region col up
                x = col;
                y = row;
                while (y > 0)
                {
                    getCase(x, y).setAdmissible(false);
                
                    y--;
                }
                //endregion
                //region col down
                x = col;
                y = row;
                while (y < height)
                {
                    getCase(x, y).setAdmissible(false);
                
                    y++;
                }
                //endregion
            }
            
            if(col < width - 1)
            {
                col++;
            }
            else
            {
                col = 0;
                row++;
            }
        }
    }
    
    private static Case getCase (int col, int row)
    {
        return listCases.get(col + (row * width));
    }
    
    private static class Case
    {
        int     col;
        int     row;
        boolean queen;
        boolean admissible;
        
        public Case (int col, int row)
        {
            setCol(col);
            setRow(row);
            setQueen(false);
            setAdmissible(true);
        }
        
        //region Getters and Setters
        public boolean isAdmissible ()
        {
            return admissible;
        }
        
        public void setAdmissible (boolean admissible)
        {
            this.admissible = admissible;
        }
        
        public int getCol ()
        {
            return col;
        }
        
        public void setCol (int col)
        {
            this.col = col;
        }
        
        public int getRow ()
        {
            return row;
        }
        
        public void setRow (int row)
        {
            this.row = row;
        }
        
        public boolean isQueen ()
        {
            return queen;
        }
        
        public void setQueen (boolean queen)
        {
            this.queen = queen;
        }
        //endregion
    }
}
