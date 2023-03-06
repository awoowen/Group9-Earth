package crm;
import java.util.Scanner;

//Change to non-static if needed
public class Menu {
    //Scanner object to get user input
    static Scanner scn = new Scanner(System.in);
    static int playerCount = 0;

    public static void beginScreen()
    {
        //Match names to GitHub names and add group number
        //Make title screen

        //Even though we were told to limit the amount of System.out.println(), the code just wouldn't look nice if I did it another way
        System.out.println("=======================================================================");
        System.out.println("Earth game prototype.");
        System.out.println("Andrew Nguyen : awoowen");
        System.out.println("Austin Ly     : Falenheart");
        System.out.println("Derek Trinh   : tcderk");
        System.out.println("Joseph Kim    : JoeyAlphaBBQ");
        System.out.println("=======================================================================");









        do {
            System.out.println("How many players are playing?");
            //Only 1-5 people can play
            //Can still produce an error if user inputs a string or char
            playerCount = scn.nextInt();
            scn.nextLine();
        } while (playerCount < 1 || playerCount > 5);
    }

    public static void endGame()
    {

    }

    //More of the game mechanics here
    //REMEMBER to change the return types later to match the cards

    public static void pickIsland()
    {
        System.out.println("Pick your island card: ");
    }

    public static void pickClimate()
    {
        System.out.println("Pick your climate card: ");
    }

    public static void pickEcosystem()
    {
        System.out.println("Pick your ecosystem card");
    }
}
