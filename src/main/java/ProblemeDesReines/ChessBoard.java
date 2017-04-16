package ProblemeDesReines;

import ProblemeDesReines.ChessPiece.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The ChessBoard	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 16/04/17 17:50
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class ChessBoard implements IChessBoard
{
    public int[] grid, optimalGrid;
    public int width, height, startX, startY;
    private ChessPieceType pieceType;
    
    public ChessBoard (int width, int height, ChessPieceType pieceType, int attemptsToDo)
    {
        this.width = width;
        this.height = height;
        this.pieceType = pieceType;
        
        grid = new int[width * height];
    }
    
    public void start (int attemptsToDo)
    {
        int maxAmount = 0;
        long startTime = System.nanoTime();
        
        for (int j = 0; j < attemptsToDo; j++)
        {
            for (int i = 0; i < width * height; i++)
            {
                grid[i] = 0;
            }
            
            startY = 0;//new Random().nextInt(height);
            startX = 0;//new Random().nextInt(width);
            
            solve(startY, startX);
            
            if(getPieceAmount() > maxAmount)
            {
                maxAmount = getPieceAmount();
                optimalGrid = grid.clone();
            }
        }
        
        float deltaTime = System.nanoTime() - startTime;
        
        System.out.println(maxAmount + " - " + deltaTime / 100000 + " millis");
        
        printGrid();
        
    }
    
    private void solve (int row, int col)
    {
        while (true)
        {
            if(getStatus(row, col) == 0)
            {
                setStatus(row, col, 1);
                
                applyPattern(row, col);
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
    
    public int getStatus (int row, int col)
    {
        return grid[col + (row * width)];
    }
    
    public void setStatus (int row, int col, int status)
    {
        grid[col + (row * width)] = status;
    }
    
    private void applyPattern (int row, int col)
    {
        switch (pieceType)
        {
            case Queen:
                new Queen().applyPattern(this, row, col);
                break;
            case King:
                new King().applyPattern(this, row, col);
                break;
            case Rook:
                new Rook().applyPattern(this, row, col);
                break;
            case Bishop:
                new Bishop().applyPattern(this, row, col);
                break;
            case Knight:
                new Knight().applyPattern(this, row, col);
                break;
            case Pawn:
                new Pawn().applyPattern(this, row, col);
                break;
        }
    }
    
    private int getPieceAmount ()
    {
        int pieceAmount = 0;
        
        for (int i : grid)
        {
            if(i == 1) pieceAmount++;
        }
        
        return pieceAmount;
    }
    
    private void printGrid ()
    {
        try
        {
        
        
            StringBuilder outputGrid = new StringBuilder();
        
            for (int i = 0; i < height; i++)
            {
                for (int j = 0; j < width; j++)
                {
                    int val = optimalGrid[j + (i * width)];
                
                    if(val == 1) outputGrid.append(" 0 ").append("|");
                    if(val == -1) outputGrid.append(" - ").append("|");
                }
                outputGrid.deleteCharAt(outputGrid.length() - 1);
                outputGrid.append("\n");
            }
        
            System.out.println(outputGrid);
        
        }
        catch (OutOfMemoryError oome)
        {
            oome.printStackTrace();
        }
    }
}