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

        gameGrid = new String[width][height];

        initializeGrid();
        generateShips(noOfShips);

        for(int i = 0; i < noOfShips; i++){
            placeShip(ships[i]);
        }
        System.out.println("TESTTESTTEST");
        

    }

    public void initializeGrid (){
        
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
        int x = rnd.nextInt(width - 1);
        int y = rnd.nextInt(height - 2);
        tempCoords[0][0] = x;
        tempCoords[0][1] = y;
        if(ship.shipOrientation == "horizontal"){
            tempCoords[1][0] = x + 1;
            tempCoords[1][1] = y;

            tempCoords[2][0] = x + 2;
            tempCoords[2][1] = y;
        }
        if(ship.shipOrientation == "vertical"){
            tempCoords[1][0] = x;
            tempCoords[1][1] = y + 1;

            tempCoords[2][0] = x;
            tempCoords[2][1] = y + 2;
        }

        ship.setShipCoordinates(tempCoords);
        
        for(int i = 0; i < 3; i++){
            System.out.println(ship.name);
            System.out.println(tempCoords[i][0]);
            System.out.println(tempCoords[i][1]);
            gameGrid[tempCoords[i][0]][tempCoords[i][1]] = "*";
            //ship.name.substring(5);
        }
    }

    public void generateShips (int numberOfShips){
        ships = new BattleShip[numberOfShips];
        for(int i = 0; i < numberOfShips; i++){
            BattleShip newShip = new BattleShip("Ship " + Integer.toString(i+1));
            ships[i] = newShip;
        }

    }

    public String[][] getGameGrid(){
        return this.gameGrid;
    }
}