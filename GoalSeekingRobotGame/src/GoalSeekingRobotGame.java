import java.util.ArrayList;
import java.util.Scanner;

public class GoalSeekingRobotGame {
    //displays map
    public static void display(char[][] map)
    {
        for(int i =0; i < map.length; i++)
        {
            for(int j =0; j < map[i].length; j++)
            {
                System.out.print(map[i][j]);
                if(j < map[i].length - 1)
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
    //returns the 5x5 grid
    public static char[][] board(int[] yPositionArray, int[] xPositionArray, char[][] inputMap)
    {
        char board[][] = new char[5][5];

        for(int i=yPositionArray[0]-2, yPos = 0; i<= yPositionArray[0] + 2; i++, yPos++)
        {
            for(int j=xPositionArray[0]-2, xPos = 0; j<= xPositionArray[0] + 2; j++, xPos++)
            {
                if(i<0 || j<0 )
                {
                    board[yPos][xPos] = '%';
                }
                else
                {
                    board[yPos][xPos] = inputMap[i][j];
                }
            }
        }
        return board;
    }
    // The main movement for the bot
    public static void move(char[][] inputMap, int[] yPositionArray,  int[] xPositionArray, int[] energyArray, String[] winnerStatus)
    {
        Scanner input = new Scanner(System.in);
        String movement;
        System.out.println("Ready: ");
        movement = input.next();
        movement = movement.toLowerCase();
        boolean moveSelected = true;
        while(moveSelected)
        {
            moveSelected = false;
            switch (movement)
            {
                case "u":
                    if(vaildMovement(movement,yPositionArray,xPositionArray,inputMap))
                    {

                        winner(movement, yPositionArray, xPositionArray, inputMap, winnerStatus);
                        battery(movement,inputMap,yPositionArray,xPositionArray,energyArray);
                        speicalChars(yPositionArray,xPositionArray,inputMap);
                        yPositionArray[0]= yPositionArray[0] - 1;
                        energyArray[0]= energyArray[0] - 1;
                        inputMap[yPositionArray[0]][xPositionArray[0]] = 'o';
                        break;
                    }
                case "d":
                    if(vaildMovement(movement,yPositionArray,xPositionArray,inputMap))
                    {
                        winner(movement, yPositionArray, xPositionArray, inputMap, winnerStatus);
                        battery(movement,inputMap,yPositionArray,xPositionArray,energyArray);
                        speicalChars(yPositionArray,xPositionArray,inputMap);
                        yPositionArray[0]= yPositionArray[0] + 1;
                        energyArray[0]= energyArray[0] - 1;
                        inputMap[yPositionArray[0]][xPositionArray[0]] = 'o';
                        break;
                    }
                case "l":
                    if(vaildMovement(movement,yPositionArray,xPositionArray,inputMap))
                    {
                        winner(movement, yPositionArray, xPositionArray, inputMap, winnerStatus);
                        battery(movement,inputMap,yPositionArray,xPositionArray,energyArray);
                        speicalChars(yPositionArray,xPositionArray,inputMap);
                        xPositionArray[0]= xPositionArray[0] - 1;
                        energyArray[0]= energyArray[0] - 1;
                        inputMap[yPositionArray[0]][xPositionArray[0]] = 'o';
                        break;
                    }
                case "r":
                    if(vaildMovement(movement,yPositionArray,xPositionArray,inputMap))
                    {
                        winner(movement, yPositionArray, xPositionArray, inputMap, winnerStatus);
                        battery(movement,inputMap,yPositionArray,xPositionArray,energyArray);
                        speicalChars(yPositionArray,xPositionArray,inputMap);
                        xPositionArray[0]= xPositionArray[0] + 1;
                        energyArray[0]= energyArray[0] - 1;
                        inputMap[yPositionArray[0]][xPositionArray[0]] = 'o';
                        break;
                    }
                default:
                    System.out.println("Please enter another direction?");
                    movement = input.next();
                    moveSelected = true;
            }
        }

    }
    //Contains the battery life
    public static void battery(String direction, char[][] inputMap, int[] yPositionArray,  int[] xPositionArray, int[] energyArray)
    {
        switch (direction) {
            case "u":
                if (inputMap[yPositionArray[0] - 1][xPositionArray[0]] == '-' )
                {
                    energyArray[0]=energyArray[0]-10;
                }
                if(inputMap[yPositionArray[0] - 1][xPositionArray[0]] == '+')
                {
                    energyArray[0]=energyArray[0]+10;
                }
            case "d":
                if (inputMap[yPositionArray[0] + 1][xPositionArray[0]] == '-' )
                {
                    energyArray[0]=energyArray[0]-10;
                }
                if(inputMap[yPositionArray[0] + 1][xPositionArray[0]] == '+')
                {
                    energyArray[0]=energyArray[0]+10;
                }

            case "l":
                if (inputMap[yPositionArray[0]][xPositionArray[0]-1] == '-' )
                {
                    energyArray[0]=energyArray[0]-10;
                }
                if(inputMap[yPositionArray[0]][xPositionArray[0]-1] == '+')
                {
                    energyArray[0]=energyArray[0]+10;
                }

            case "r":
                if (inputMap[yPositionArray[0]][xPositionArray[0]+1] == '-' )
                {
                    energyArray[0]=energyArray[0]-10;
                }
                if(inputMap[yPositionArray[0]][xPositionArray[0]+1] == '+')
                {
                    energyArray[0]=energyArray[0]+10;
                }
        }
    }
    //Validates if a move is possible in the game
    public static boolean vaildMovement(String direction, int[] yPositionArray, int[] xPositionArray, char[][] inputMap)
    {
        switch (direction)
        {
            case "u":
                if(inputMap[yPositionArray[0]-1][xPositionArray[0]] != '#' && inputMap[yPositionArray[0]-1][xPositionArray[0]] != '%') {
                    return true;
                }
                else{
                    return false;
                }
            case "d":
                if((inputMap[yPositionArray[0]+1][xPositionArray[0]] != '#') &&  (inputMap[yPositionArray[0]-1][xPositionArray[0]] != '%')) {
                    return true;
                }
                else{
                    return false;
                }

            case "l":
                if(inputMap[yPositionArray[0]][xPositionArray[0]-1] != '#' &&  inputMap[yPositionArray[0]][xPositionArray[0]-1] != '%') {
                    return true;
                }
                else{
                    return false;
                }

            case "r":
                if(inputMap[yPositionArray[0]][xPositionArray[0]+1] != '#' &&  inputMap[yPositionArray[0]][xPositionArray[0]+1] != '%') {
                    return true;
                }
                else{
                    return false;
                }
        }
        return false;
    }
    //Determines is player wins
    public static void winner(String direction, int[] yPositionArray, int[] xPositionArray, char[][] inputMap, String[] winnerStatus)
    {
        switch (direction)
        {
            case "u":
                if(inputMap[yPositionArray[0]-1][xPositionArray[0]] == '*') {
                    winnerStatus[0] = "true";
                }

            case "d":
                if(inputMap[yPositionArray[0]+1][xPositionArray[0]] == '*') {
                    winnerStatus[0] = "true";
                }

            case "l":
                if(inputMap[yPositionArray[0]][xPositionArray[0]-1] == '*') {
                    winnerStatus[0] = "true";
                }
            case "r":
                if(inputMap[yPositionArray[0]][xPositionArray[0]+1] == '*') {
                    winnerStatus[0] = "true";
                }
        }
    }
    //Allows for the map to keep special directions and have a trail
    public static void speicalChars( int[] yPositionArray, int[] xPositionArray, char[][] inputMap)
    {
        if(yPositionArray[0] == 5 && xPositionArray[0] == 6)
        {
            inputMap[yPositionArray[0]][xPositionArray[0]] = 'r';
        }
        else if(yPositionArray[0] == 6 && xPositionArray[0] == 14)
        {
            inputMap[yPositionArray[0]][xPositionArray[0]] = 'r';
        }
        else if(yPositionArray[0] == 14 && xPositionArray[0] == 11)
        {
            inputMap[yPositionArray[0]][xPositionArray[0]] = 'r';
        }
        else if(yPositionArray[0] == 2 && xPositionArray[0] == 35)
        {
            inputMap[yPositionArray[0]][xPositionArray[0]] = 'd';
        }
        else if(yPositionArray[0] == 6 && xPositionArray[0] == 30)
        {
            inputMap[yPositionArray[0]][xPositionArray[0]] = 'd';
        }
        else if(yPositionArray[0] == 16 && xPositionArray[0] == 35)
        {
            inputMap[yPositionArray[0]][xPositionArray[0]] = 'u';
        }
        else
        {
            inputMap[yPositionArray[0]][xPositionArray[0]] = '.';
        }
    }

    public static void main(String[] args) {
        String fileName = "game.txt";
        Scanner loader = new Scanner(GoalSeekingRobotGame.class.getResourceAsStream(fileName));
        int numSteps = loader.nextInt();
        int yPosition = loader.nextInt();
        int xPosition = loader.nextInt();
        int[] yPositionArray;
        int[] xPositionArray;
        int[] energyArray;
        String[] winningStatus;
        yPositionArray = new int[1];
        xPositionArray = new int[1];
        energyArray = new int[1];
        winningStatus = new String[1];

        yPositionArray[0] = yPosition;
        xPositionArray[0] = xPosition;
        energyArray[0] = numSteps;
        winningStatus[0] = "false";
        loader.nextLine();
        ArrayList<char[]> land = new ArrayList<>();
        while (loader.hasNext()){
            String nextLine = loader.nextLine();
            char[] nextRow = new char[nextLine.length()];
            for (int i = 0; i < nextLine.length(); i++) {
                nextRow[i] = nextLine.charAt(i);
            }
            land.add(nextRow);
        }

        char[][] inputMap = new char[land.size()][];
        for (int i = 0; i < inputMap.length; i++)
        {
            inputMap[i] = land.get(i);
        }
        inputMap[yPosition][xPosition] = 'o';
        display(inputMap);
        while((energyArray[0]>0) && (winningStatus[0].equals("false"))) {

            System.out.println(energyArray[0]);
            display(board(yPositionArray, xPositionArray, inputMap));
            move(inputMap, yPositionArray, xPositionArray, energyArray, winningStatus);
        }
        if(winningStatus[0].equals("true") && energyArray[0]>=0)
        {
            display(inputMap);
            System.out.println("Congratulations! You won the game!");
        }
        else
        {
            display(inputMap);
            System.out.println("Sorry you lost the game");
        }
    }
}