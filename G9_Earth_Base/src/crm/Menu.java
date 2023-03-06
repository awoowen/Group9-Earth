package crm;
import java.util.Scanner;

//Change to non-static if needed
public class Menu {
    //Scanner object to get user input
    static Scanner scn = new Scanner(System.in);
    static int playerCount = 0;

    public static void beginScreen()
    {
        do {
            System.out.println("How many players are playing?");
            //Only 1-5 people can play
            //Can still produce an error if user inputs a string or char
            playerCount = scn.nextInt();
            scn.nextLine();
        } while (playerCount < 1 && playerCount > 5);
    }

    public static void endGame()
    {

    }
}
