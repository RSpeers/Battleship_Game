package CS2020.assignment1.game;
import java.util.Random;

public class Game implements GameControls{
    protected PlayerGameGrid playerGrid;
    protected OpponentGameGrid opponentGrid;
    
    Game(int width, int height, int noOfShips){
        //instantiating new gamegrid objects using values passed in
        playerGrid = new PlayerGameGrid(width, height, noOfShips);
        opponentGrid =new OpponentGameGrid(width, height, noOfShips);
    }

    public void playRound (String input){
        //splits input into the two distict coords
        int x = Integer.parseInt(input.substring(0,1));
        int y = Integer.parseInt(input.substring(2,3));

        //player's shot first
        if(opponentGrid.gameGrid[x][y] == "*"){
            //Shot hit
            opponentGrid.gameGrid[x][y] = "X";
            System.out.print("HIT ");
            for(int i = 0; i < opponentGrid.noOfShips; i++){
                if(opponentGrid.ships[i].checkAttack(x, y)){
                    System.out.println(opponentGrid.ships[i].name + "!!!");
                }
            }
        }
        else{
            //Player's shot missed
            opponentGrid.gameGrid[x][y] = "%";
            System.out.println("MISS!!!");
        }
        //print updated version of opponent's grid
        opponentGrid.printGrid();

        //Opponents shot is the same as players but coords are random
        Random rnd = new Random();
        x = rnd.nextInt(playerGrid.width - 2);
        y = rnd.nextInt(playerGrid.height - 2);

        if(playerGrid.gameGrid[x][y] == "*"){
            //opponent shot hit
            playerGrid.gameGrid[x][y] = "X";
            System.out.print("HIT ");
            for(int i = 0; i < playerGrid.noOfShips; i++){
                if(opponentGrid.ships[i].checkAttack(x, y)){
                    System.out.println(playerGrid.ships[i].name + "!!!");
                }
            }
        }
        else{
            //opponent's shot missed
            playerGrid.gameGrid[x][y] = "%";
            System.out.println("MISS!!!");
            }
            //print updated version of player's grid
            playerGrid.printGrid();
    }

	//checks for victory conditions and prints message
    //returns true if anyone wins
	public boolean checkVictory (){
        int noOfSunkShips = 0;
        boolean opponentWins = false;
        boolean playerWins = false;

        //check if all opponents ships have been destroyed eg. player wins
        for(int i = 0; i < opponentGrid.noOfShips; i++){
            if(opponentGrid.ships[i].getHits() >= 3){
                noOfSunkShips++;
            }
        }
        if(noOfSunkShips >= opponentGrid.noOfShips){
            playerWins = true;
        }
        
        noOfSunkShips = 0;
        //Check if all player ships have been destroyed
        for(int i = 0; i < playerGrid.noOfShips; i++){
            if(playerGrid.ships[i].getHits() >= 3){
                noOfSunkShips++;
            }
        }
        if(noOfSunkShips >= playerGrid.noOfShips){
            opponentWins = true;
        }
        
        //print win condition output and return correct boolean
        if(opponentWins == true){
            System.out.println("You have lost!");
            return true;
        }
        else if(playerWins == true){
            System.out.println("You have won!");
            return true;
        }
        else{
            return false;
        }
    }
	
	public void exitGame (String input){
        //exits the java program if passed in correct string
        if(input == "exit"){
            System.out.println("Exiting game – thank you for playing");
            System.exit(0);
        }
         
    }

    public AbstractGameGrid getPlayersGrid (){
        return playerGrid;
    }
	
	public AbstractGameGrid getOpponentssGrid (){
        return opponentGrid;
    }
}