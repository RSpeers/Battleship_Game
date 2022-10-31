package CS2020.assignment1.game;

public class GameGrid extends AbstractGameGrid{
    protected int width = 0;
    protected int height = 0;
    protected int noOfShips = 0;

    GameGrid(int width, int height, int noOfShips){
        this.width = width;
        this.height = height;
        this.noOfShips = noOfShips;

        initializeGrid();
    }

    public void initializeGrid (){
        gameGrid = new String[width][height];
        for(int i = 0; 1 < width; i++){
            for(int j = 0; j < height; j++){
                gameGrid[i][j] = ".";
            }
        }
    }

    public void placeShip (AbstractBattleShip ship){

    }

    public void generateShips (int numberOfShips){

    }
}