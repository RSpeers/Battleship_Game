package CS2020.assignment1.game;

public class PlayerGameGrid extends GameGrid{
    PlayerGameGrid(int height, int width, int noOfShips){
        super(height, width, noOfShips);
    }

    public void printGrid(){
        System.out.println("Players Grid");
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                System.out.print(gameGrid[i][j]);
            }
            System.out.println("");
        }
    }
}