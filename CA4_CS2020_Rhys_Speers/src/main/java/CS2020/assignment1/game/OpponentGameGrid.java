package CS2020.assignment1.game;

public class OpponentGameGrid extends GameGrid{
    OpponentGameGrid(int height, int width, int noOfShips){
        super(height, width, noOfShips);
    }
    
    public void printGrid(){
        System.out.println("Opponent Grid");
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(gameGrid[i][j] == "." || gameGrid[i][j] == "*"){
                    System.out.print(".");
                }
                else{
                    System.out.print(gameGrid[i][j]);
                }
                
            }
            System.out.println("");
        }
    }
}