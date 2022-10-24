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
        return false;
    }
	
	public String getName(){
        return "";
    }

	public int getHits() {
        return 0;
    }
	
	public String getShipOrientation(){
        return shipOrientation;
    } 
	
	public void setHits(int numberOfHits){
       
    } 
	
	public int[][] getShipCoordinates(){
        return null;
    } 
	
	public void setShipCoordinates(int [][] coordinates){
        
    } 

}