package crm;
//Group 9: Andrew Nguyen(awoowen), Austin Ly(Falenheart), Derek Trinh(tcderk), Joseph Kim(JosephAlphaBBQ)
import java.util.Scanner;

public class TestDriver {
	public static Player[] playerList = new Player[5];
	
    public static void main(String[] args){
    	Scanner input = new Scanner(System.in);
        EarthDeck earthDeck = new EarthDeck();
        System.out.println("Earth Deck: " + earthDeck);
        EarthDeck.shuffleEarth();

        Player p1 = new Player(earthDeck);
        playerList[0] = p1;
        p1.setFirstPlayer(true);
        p1.setActivePlayer(true);

        while (p1.isActivePlayer()) {
        	plantingAction(p1, earthDeck, input);
            p1.playCard(p1.hand.remove(0), 1, 1);
            if(p1.hand.size() == 0) {
                System.out.println("No cards in hand.");
                break;
            }
        }
    }
    
    public static void plantingAction(Player activePlayer, EarthDeck gameDeck,/* Player[] otherPlayers,*/ Scanner input) {
    	int numPlant = -1;
    	int row = -1;
    	int col = -1;
    	int counter;
    	Card temp;
    	Card[] tempHand = new Card[4];
    	
    	//Plant up to 2 cards, one at a time, into your tableau by paying soil
    	//Active player chooses whether to plant 0-2 cards.
    	System.out.print("Choose the number of cards to plant (0-2): ");
    	numPlant = input.nextInt();
    	if(numPlant == 2) {
    		System.out.println("Choose the card to plant:");
    		ToScreen.displayHand(activePlayer);
    		System.out.println();
    		temp = activePlayer.hand.get(input.nextInt() - 1);
    		
    		System.out.println("Choose the row and column you want to plant in (4x4 grid):");
    		System.out.print("Row (1-4): ");
    		row = input.nextInt();
    		System.out.print("Column (1-4): ");
    		col = input.nextInt();
    		
    		activePlayer.playCard(temp, row, col);
    		while(!activePlayer.playCard(temp, row, col)) {
    			//Ask to choose new row and col
    			activePlayer.playCard(temp, row, col);
    		}
    		
    		System.out.println("Choose the card to plant:");
    		ToScreen.displayHand(activePlayer);
    		System.out.println();
    		temp = activePlayer.hand.get(input.nextInt() - 1);
    		
    		System.out.println("Choose the row and column you want to plant in (4x4 grid):");
    		System.out.print("Row (1-4): ");
    		row = input.nextInt();
    		System.out.print("Column (1-4): ");
    		col = input.nextInt();
    		
    		activePlayer.playCard(temp, row, col);
    		while(!activePlayer.playCard(temp, row, col)) {
    			System.out.println("Choose the row and column you want to plant in (4x4 grid):");
        		System.out.print("Row (1-4): ");
        		row = input.nextInt();
        		System.out.print("Column (1-4): ");
        		col = input.nextInt();
        		
        		activePlayer.playCard(temp, row, col);
    		}
    	} else if(numPlant == 1) {
    		System.out.println("Choose the card to plant:");
    		ToScreen.displayHand(activePlayer);
    		System.out.println();
    		temp = activePlayer.hand.get(input.nextInt() - 1);
    		
    		System.out.println("Choose the row and column you want to plant in (4x4 grid):");
    		System.out.print("Row (1-4): ");
    		row = input.nextInt();
    		System.out.print("Column (1-4): ");
    		col = input.nextInt();
    		
    		activePlayer.playCard(temp, row, col);
    		while(!activePlayer.playCard(temp, row, col)) {
    			System.out.println("Choose the row and column you want to plant in (4x4 grid):");
        		System.out.print("Row (1-4): ");
        		row = input.nextInt();
        		System.out.print("Column (1-4): ");
        		col = input.nextInt();
        		
    			activePlayer.playCard(temp, row, col);
    		}
    	}
    	
    	//Draw 4 cards, choose 1 to keep and discard the rest into the discard pile
    	//Players do not need to have planted a card to draw a card
    	for(int i = 0; i < 4; i++) {
    		tempHand[i] = gameDeck.dealTopEarthCard();
    	}
    	
    	System.out.println("Choose a card to keep and discard the rest:");
    	counter = 0;
		for(int j = 0; j < 4; j++) {
			counter += 1;
			System.out.println(counter + ": " + tempHand[counter - 1].getName());
		}
    	temp = tempHand[input.nextInt() - 1];
    	for(int i = 0; i < 4; i++) {
    		if(activePlayer.hand.get(activePlayer.hand.size() - 1) != temp) {
    	    	//Note: the discarded cards are NOT put into the compost pile
    			gameDeck.discardCard(activePlayer.hand.remove(activePlayer.hand.size() - 1));
    		}
    	}
    	
    	//all other players may plant 1 card in their tableau by paying soil and draw 1 card
    	//Temporarily not within the scope of the assignment
    	/*for(int i = 0; i < otherPlayers.length; i++) {
    		//Ask other players to choose 0-1 card to plant
    		if(numPlant == 1) {
    			//Ask to choose card to plant
    			//Ask to choose row and col
    			otherPlayers[i].playCard(temp, row, col);
    			while(!otherPlayers[i].playCard(temp, row, col)) {
    				//Ask to choose new row and col
    				otherPlayers[i].playCard(temp, row, col);
    			}
    		}
    		otherPlayers[i].drawCard(gameDeck);
    	}*/
    	
    	//finally, all players activate the green abilities on their cards
    	//Placeholder
    }
    
    public void compostingAction(Player activePlayer) {
    	//gain 5 soil and take 2 cards from the draw pile and place them in your compost pile without looking at them
    	//all other players may gain 2 soil OR compost 2 cards from the draw pile
    	//finally, all players will activate the red and multicolored abilities on their cards
    	//you will score 1 VP per card in your compost pile at the end of the game
    }
    
    public void wateringAction(Player activePlayer) {
    	//gain up to 6 sprouts, immediately placing them on any of your flora with empty sprout spaces, then gain 2 soil
    	//all other players may either gain up to 2 sprouts OR gain 2 soil
    	//finally, all players activate the blue and multicolored abilities on their cards
    	//you will score 1 VP per sprout on your tableau at the end of the game
    	//sprouts can be converted to soil at a ratio of 3 sprouts to 2 soil at any time during the game except while gaining them during the watering action or in the middle of a card's ability
    	//you can repeat the sprout to soil conversion (one way) as many times as you want
    }
    
    public void growingAction(Player activePlayer) {
    	//draw 4 cards from the earth deck and place them in your hand
    	//place up to 2 growth on any of your flora with room on their growth space
    	//all other players may either draw 2 cards OR place up to 2 growth on their flora
    	//finall, all players active the yellow and multicolored abilities on their cards
    	//you will score 1 VP per growth on your tableau at the end of the game
    	//any flora that have reached max growth will instead earn their canopy completion VP
    }
}