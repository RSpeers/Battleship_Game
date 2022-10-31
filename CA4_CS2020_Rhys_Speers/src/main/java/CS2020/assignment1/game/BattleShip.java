package CS2020.assignment1.game;
import java.util.Random;

public class BattleShip extends AbstractBattleShip{

    BattleShip(String shipName){
        name = shipName;
        Random rnd = new Random();
        int randomOrientation = rnd.nextInt(2);
        System.out.println(randomOrientation);
        if (randomOrientation == 0){
            shipOrientation = "vertical";
        }
        else{
            shipOrientation = "horizontal";
        }
    }

    public String GetName(){
        return name;
    }

    public boolean checkAttack (int row,int column){
        if(shipCoordinates[0][0] == row && shipCoordinates[0][1] == column && hits < 3){
            hits++;
            return true;
        }
        else{
            return false;
        }

    }
	
	public String getName(){
        return name;
    }

	public int getHits() {
        return hits;
    }
	
	public String getShipOrientation(){
        return shipOrientation;
    } 
	
	public void setHits(int numberOfHits){
       hits = numberOfHits;
    } 
	
	public int[][] getShipCoordinates(){
        return shipCoordinates;
    } 
	
	public void setShipCoordinates(int [][] coordinates){
        shipCoordinates = coordinates;
    } 

}