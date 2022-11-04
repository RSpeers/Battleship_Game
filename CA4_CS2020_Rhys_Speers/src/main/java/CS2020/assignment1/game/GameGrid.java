package CS2020.assignment1.game;
import java.util.Random;

public class GameGrid extends AbstractGameGrid{
    int width = 0;
    int height = 0;
    int noOfShips = 0;
   
    public GameGrid(int Width, int Height, int NoOfShips){
        width = Width;
        height = Height;
        noOfShips = NoOfShips;

        //generate new game grid to specifiied size
        gameGrid = new String[width][height];

        //call methods to set up the game to prepare for play
        initializeGrid();
        generateShips(noOfShips);

        //place all ships onto grid
        for(int i = 0; i < noOfShips; i++){
            placeShip(ships[i]);
        }
        
        

    }

    public void initializeGrid (){
        //cycles through every value of the 2d array and inserts "."
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                gameGrid[i][j] = ".";
            }
        }
    }

    public void placeShip (AbstractBattleShip ship){
        //Place to put coords that will be added to ship at the end
        int[][] tempCoords = new int[3][2];

        Random rnd = new Random();

        //generate random first coordinant and add to temp array
        int x = rnd.nextInt(width - 2);
        int y = rnd.nextInt(height - 2);
        tempCoords[0][0] = x;
        tempCoords[0][1] = y;


        if(ship.shipOrientation == "horizontal"){
            //make the next two coordinants for this BattleShip on the horizontal axis
            tempCoords[1][0] = x + 1;
            tempCoords[1][1] = y;

            tempCoords[2][0] = x + 2;
            tempCoords[2][1] = y;
        }
        if(ship.shipOrientation == "vertical"){
            //make the next two coordinants for this BattleShip on the vertical axis
            tempCoords[1][0] = x;
            tempCoords[1][1] = y + 1;

            tempCoords[2][0] = x;
            tempCoords[2][1] = y + 2;
        }
        //update the ships coordinants with the values generated
        ship.setShipCoordinates(tempCoords);
        
        //add this ships coordinants to the game grid
        for(int i = 0; i < 3; i++){
            /* UNCOMMENT THESE PRINT STATEMENTS FOR DEBUGGING
            System.out.println(ship.name);
            System.out.println(tempCoords[i][0]);
            System.out.println(tempCoords[i][1]);
            */
            gameGrid[tempCoords[i][0]][tempCoords[i][1]] = "*";
            //ship.name.substring(5);
        }
    }

    public void generateShips (int numberOfShips){
        //Create array of ships with the size of the number of ships
        ships = new BattleShip[numberOfShips];

        //For number of ships generate a new ship object and name it using its number in list
        for(int i = 0; i < numberOfShips; i++){
            BattleShip newShip = new BattleShip("Ship " + Integer.toString(i+1));
            ships[i] = newShip;
        }

    }

    public String[][] getGameGrid(){
        return this.gameGrid;
    }
}