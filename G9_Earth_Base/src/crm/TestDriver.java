package crm;
//Group 9: Andrew Nguyen, Austin Ly, Derek Trinh, Joseph Kim
//import java.util.Scanner;

public class TestDriver {
	public static Player[] playerList = new Player[5];
	
    public static void main(String[] args){
        Menu menu = new Menu();
        menu.beginScreen();


    	//Scanner inputScanner = new Scanner(System.in);
        EarthDeck earthDeck = new EarthDeck();
        System.out.println("Earth Deck: " + earthDeck);
        EarthDeck.shuffleEarth();

        Player p1 = new Player(earthDeck);
        playerList[0] = p1;
        p1.setFirstPlayer(true);
        p1.setActivePlayer(true);

        while (p1.isActivePlayer()) {
            p1.playCard(p1.hand.remove(0), 1, 1);
            if(p1.hand.size() == 0) {
                System.out.println("No cards in hand.");
                break;
            }

        }

    }
    
    public void plantingAction(Player activePlayer, EarthDeck gameDeck, Player[] otherPlayers) {
    	//plant up to 2 cards, one at a time, into your tableau by paying soil
    	//draw 4 cards, choose 1 to keep and discard the rest into the discard pile
    	//Note: the discarded cards are NOT put into the compost pile
    	//all other players may plant 1 card in their tableau by paying soil and draw 1 card
    	//players do not need to have planted a card to draw a card
    	//finally, all players activate the green abilities on their cards

    	int numPlant = -1;
    	int row = -1;
    	int col = -1;
    	Card temp = activePlayer.hand.get(0); //Use this to ask players to choose cards
    	
    	//Active player chooses whether to plant 0-2 cards.
    	if(numPlant == 2) {
    		//Ask to choose 1st card to plant
    		//Ask to choose row and col
    		activePlayer.playCard(temp, row, col);
    		while(!activePlayer.playCard(temp, row, col)) {
    			//Ask to choose new row and col
    			activePlayer.playCard(temp, row, col);
    		}
    		//Ask to choose 2nd card to plant
    		//Ask to choose row and col
    		activePlayer.playCard(temp, row, col);
    		while(!activePlayer.playCard(temp, row, col)) {
    			//Ask to choose new row and col
        		activePlayer.playCard(temp, row, col);
    		}
    	} else if(numPlant == 1) {
    		//Ask to choose card to plant
    		//Ask to choose row and col
    		activePlayer.playCard(temp, row, col);
    		while(!activePlayer.playCard(temp, row, col)) {
    			//Ask to choose new row and col
    			activePlayer.playCard(temp, row, col);
    		}
    	}
    	for(int i = 0; i < 4; i++) {
    		activePlayer.DrawCard(gameDeck);
    	}
    	//Ask player to choose card to keep
    	//temp = chosen card;
    	for(int i = 0; i < 4; i++) {
    		if(activePlayer.hand.get(activePlayer.hand.size() - 1) != temp) {
    			gameDeck.discardCard(activePlayer.hand.remove(activePlayer.hand.size() - 1));
    		}
    	}
    	
    	
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