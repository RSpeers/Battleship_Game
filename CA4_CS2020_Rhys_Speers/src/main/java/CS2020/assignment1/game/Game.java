package CS2020.assignment1.game;

public class Game implements GameControls{
    protected PlayerGameGrid playerGrid;
    protected OpponentGameGrid opponentGrid;

    Game(int width, int height, int noOfShips){
        playerGrid = new PlayerGameGrid(width, height, noOfShips);
        opponentGrid =new OpponentGameGrid(width, height, noOfShips);
    }

    public void playRound (String input){

    }
	
	public boolean checkVictory (){
        return true;
    }
	
	public void exitGame (String input){
        
    }

    public AbstractGameGrid getPlayersGrid (){
        return playerGrid;
    }
	
	public AbstractGameGrid getOpponentssGrid (){
        return opponentGrid;
    }
}