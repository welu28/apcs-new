package battleship;

import java.util.*;

public class Battleship
{
    private Player user;
    private Player computer;
    private Grid userGrid;
    private Grid comGrid;
    int[] shipLengths = {2, 3, 3, 4, 5};
    ArrayList<String> columns = new ArrayList<String>();
    
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    
    public Battleship()
    {
        user = new Player();
        computer = new Player();
        userGrid = user.getGrid();
        comGrid = computer.getGrid();
        initializeCols();
        user.printUserShips();
        userPlaceShips();
        comPlaceShips();
        while(!user.win() && !computer.win())
        {
            System.out.println("Current guesses: ");
            user.printUserGuessed();
            guess();
            if(user.win())
            {
                System.out.println("User wins!");
                break;
            }
            compGuess();
            if(computer.win())
            {
                System.out.println("You lost :(");
                break;
            }
            System.out.println("Computer's guesses: ");
            computer.printUserGuessed();
            System.out.println("Your ships: ");
            user.printUserShips();
        }
        
    }
    
    private void initializeCols()
    {
        for(char col = 'A'; col <= 'J'; col++)
        {
            columns.add(String.valueOf(col));
        }
    }
        
    private void userPlaceShips()
    {
        Scanner io = new Scanner(System.in);
        int row = -1;
        int col = -1;
        int direction = -1;
        for(int length: shipLengths)
        {
            while(true)
            {
                System.out.println("You will now put a ship of length " + length);
                String theCol = io.("Place the column (A-J): ").toUpperCase();
                row = io.readInt("Place the row (1-10): ") - 1;
                col = columns.indexOf(theCol.toUpperCase());
                String theDir = io.readLine("Choose the direction (h/v)").toUpperCase();
                direction = 0;
                if(theDir.equals("V"))
                {
                    direction = 1;
                }
                if (row < 0 || row >= 10 || col < 0 || col >= 10 || !user.validShip(col, row, direction))
                {
                    System.out.println("Invalid.");
                }
                else
                {
                    user.chooseShipLocation(col, row, direction);
                    break;
                }
            }
            user.printUserShips();
        }
    }
    
    private void comPlaceShips()
    {
        for(int length: shipLengths)
        {
            int row = -1;
            int col = -1;
            int direction = -1;
            System.out.println("The computer will now place its ships");
            while(true)
            {
                row = Randomizer.nextInt(0, 9);
                col = Randomizer.nextInt(0, 9);
                direction = Randomizer.nextInt(0, 1);
                if(computer.validShip(col, row, direction))
                {
                    break;
                }
            }
            user.chooseShipLocation(col, row, direction);
        }
    }
        
    private void guess()
    {
        Scanner io = new Scanner(System.in);
        String theCol = readLine("Guess the column (A-J): ").toUpperCase();
        int col = columns.indexOf(theCol.toUpperCase());
        int row = readInt("Guess the column (1-10): ") - 1;
        if(userGrid.alreadyGuessed(col, row))
        {
            System.out.println("Invalid.");
            return;
        }
        else if(comGrid.hasShip(col, row))
        {
            System.out.println("Hit! ");
        }
        else
        {
            System.out.println("Miss :(");
        }
        computer.recordGuess(col, row);
    }
    
    private void compGuess()
    {
        int col = Randomizer.nextInt(10);
        int row = Randomizer.nextInt(10);
        if(comGrid.alreadyGuessed(col, row))
        {
            guess();
        }
        else if(userGrid.hasShip(col, row))
        {
            System.out.println("Computer has hit! ");
        }
        else
        {
            System.out.println("Computer miss :(");
        }
    }
    
    public void run()
    {
        userPlaceShips();
        comPlaceShips();
        
        while(true)
        {
            guess();
            if(user.win())
            {
                System.out.println("Congrats! You won!");
                break;
            }
            compGuess();
            if(computer.win())
            {
                System.out.println("Sorry! The computer won!");
                break;
            }
        }
    }
}
