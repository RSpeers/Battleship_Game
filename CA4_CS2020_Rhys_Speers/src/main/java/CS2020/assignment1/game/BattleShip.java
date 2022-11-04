package CS2020.assignment1.game;
import java.util.Random;

public class BattleShip extends AbstractBattleShip{

    BattleShip(String shipName){
        name = shipName;

        //Generate a random number and assign ship orientation based on it
        Random rnd = new Random();
        int randomOrientation = rnd.nextInt(2);//50/50 chance

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

    //return true if attack hits ship and updates this ships hitcount accordingly
    public boolean checkAttack (int row,int column){
        //hit registers if values passed in match the ships coordinates and the ship hasnt already sunk(Been hit three times)
        for(int i = 0; i < 3; i++){
            if(shipCoordinates[i][0] == row && shipCoordinates[i][1] == column && hits < 3){
                hits++;
                return true;
            }
            else{
                return false;
            }
        }
        return false;
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