package CS2020.assignment1.game;
import CS2020.assignment1.game.Game;
import java.util.Scanner;

public class RunGame{
    public static void main(String[] args) { //int height, int width, int noOfShips
        //These hava been hardcoded because of issue with 
       int height = 10; 
       int width  = 10;
       int noOfShips = 3;

       Game thisGame = new Game(height, width, noOfShips);
       Scanner input = new Scanner(System.in);
       String userInput = "";

        while (thisGame.checkVictory() == false){
            System.out.println("Please enter the position you wish to attack: Format: x,y ");
            try{
                userInput = input.nextLine(); 
                thisGame.exitGame(userInput);   
        
                thisGame.playRound(userInput);
            }
            catch(Exception | Error e){
                System.out.println("Sorry, invalid input. Please run program again");
                System.exit(0);
            }
            
        }

        System.out.println("Exiting game – thank you for playing");
        System.exit(0);
        
    }
}