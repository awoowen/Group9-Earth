package crm;
//Group 9: Andrew Nguyen(awoowen), Austin Ly(Falenheart), Derek Trinh(tcderk), Joseph Kim(JosephAlphaBBQ)
import java.util.Scanner;

public class TestDriver {
	public static Player[] playerList = new Player[5];
	
    public static void main(String[] args){


		Menu.beginScreen();

    	Scanner input = new Scanner(System.in);

		// This just does one round of plantingAction
		EarthDeck earthDeck = new EarthDeck();
		Player tester = new Player();
		tester.drawCard(earthDeck);
		tester.drawCard(earthDeck);
		tester.drawCard(earthDeck);

		while (!tester.getTableu().isFull()) {
			plantingActionRedo(tester, earthDeck, input);		// Rewritten version of plantingAction
			ToScreen.displayTableu(tester.getTableu());
		}

		Menu.endScreen();
		return;
    }

	//Returns true if at least 1 card was played. Returns false if canceled without playing; let the player choose another action.
	public static void plantingActionRedo(Player activePlayer, EarthDeck gameDeck, Scanner input) {		// DT redoing
		// Ask player for number of cards they wish to play.
		// Play cards from hand, one after another. Stop early if the player can no longer play any cards.
		// Draw card

		int numToPlay = ToScreen.plantingPrep(activePlayer, input);

		for (int i = 1; i <= numToPlay; i++) {
			System.out.println("\nPlaying card " + i + " of " + numToPlay);
			int toPlayFromHand = ToScreen.chooseFromHand(activePlayer, input);

			toPlayFromHand = checkEventPlantRedo(toPlayFromHand, activePlayer, input);

			if (toPlayFromHand == -1) break;	// Stop playing cards
			while (activePlayer.hand.get(toPlayFromHand).getSoilCost() > activePlayer.getSoil())
				toPlayFromHand = ToScreen.chooseFromHandExpensive(activePlayer, input);
			int spotToPlay = ToScreen.plantCoord(activePlayer, input);
			activePlayer.playCard(activePlayer.hand.get(toPlayFromHand), spotToPlay);
		}

		Card[] tempHand = new Card[4];

		System.out.println("\nDrawing 4 cards from draw pile...");
		for (int i = 0; i < 4; i++) {
			tempHand[i] = gameDeck.dealTopEarthCard();
		}

		activePlayer.addToHand(tempHand[ToScreen.chooseFromStack(tempHand, input)]);

		ToScreen.displayHand(activePlayer);
 	}
    

    public static void plantingAction(Player activePlayer, EarthDeck gameDeck,/* Player[] otherPlayers,*/ Scanner input) {
    	int numPlant = -1;
    	int row = -1;
    	int col = -1;
    	int counter;
    	Card temp = null;
    	Card[] tempHand = new Card[4];
    	boolean errorFlag = false;
    	Card cardCheck;
		int nonEventCount = 0;

    	ToScreen.displayTableu(activePlayer.getTableu());
    	
    	//Plant up to 2 cards, one at a time, into your tableau by paying soil
    	//Active player chooses whether to plant 0-2 cards.
    	do {
			ToScreen.displayHand(activePlayer);

//			for(int r = 0; r < activePlayer.hand.size(); r++ ) {				// check if the player has at least two non Event cards on hand.
//				cardCheck = activePlayer.hand.get(r);
//				if(!cardCheck.getType().equals("Event")) {
//					nonEventCount++;
//					if(nonEventCount >= 2) {
//						break;
//					}
//				}
//			}
//			if(nonEventCount == 0) {
//				break;
//			}

    		System.out.print("Choose the number of cards to plant (0-2): ");
    		numPlant = input.nextInt();
    		if(numPlant > activePlayer.hand.size()) {
    			System.out.println("Not enough cards to plant.");
    			System.out.println("You have " + activePlayer.hand.size() + " cards in your hand.");
    			errorFlag = true;
    		} else {
    			errorFlag = false;
    		}
    	} while(errorFlag == true);

    	if(numPlant == 2) {
    		System.out.print("Choose the first card to plant:");
//    		ToScreen.displayHand(activePlayer);
//    		temp = activePlayer.hand.get(input.nextInt() - 1);

			temp = checkEventPlant(activePlayer, input);	// checks if the player selected in Event card.

    		System.out.println("Choose the row and column you want to plant in (4x4 grid):");
    		System.out.print("Row (1-4): ");
    		row = input.nextInt();
    		System.out.print("Column (1-4): ");
    		col = input.nextInt();
    		
    		//ToScreen.displayTableu(activePlayer.playerTableu);
    		//System.out.println("test1");
    		while(activePlayer.playCard(temp, row, col) == false) {
    			System.out.println("Choose the row and column you want to plant in (4x4 grid):");
        		System.out.print("Row (1-4): ");
        		row = input.nextInt();
        		System.out.print("Column (1-4): ");
        		col = input.nextInt();
        		//System.out.println("test2");
        		ToScreen.displayTableu(activePlayer.playerTableu);
    		}

			ToScreen.displayHand(activePlayer);
    		System.out.print("Choose the second card to plant:");
//    		temp = activePlayer.hand.get(input.nextInt() - 1);

			temp = checkEventPlant(activePlayer, input);	// checks if the player selected in Event card.
    		
    		System.out.println("Choose the row and column you want to plant in (4x4 grid):");
    		System.out.print("Row (1-4): ");
    		row = input.nextInt();
    		System.out.print("Column (1-4): ");
    		col = input.nextInt();
    		
    		//ToScreen.displayTableu(activePlayer.playerTableu);
    		//System.out.println("test3");
    		while(activePlayer.playCard(temp, row, col) == false) {
    			System.out.println("Choose the row and column you want to plant in (4x4 grid):");
        		System.out.print("Row (1-4): ");
        		row = input.nextInt();
        		System.out.print("Column (1-4): ");
        		col = input.nextInt();
        		//System.out.println("test4");
        		ToScreen.displayTableu(activePlayer.playerTableu);
    		}
    	} else if(numPlant == 1) {
    		System.out.print("Choose the card to plant:");
//    		ToScreen.displayHand(activePlayer);
//    		temp = activePlayer.hand.get(input.nextInt() - 1);

			temp = checkEventPlant(activePlayer, input); 	// player selects a card to plant
																// and checks if it's an Event card.

    		System.out.println("Choose the row and column you want to plant in (4x4 grid):");
    		System.out.print("Row (1-4): ");
    		row = input.nextInt();
    		System.out.print("Column (1-4): ");
    		col = input.nextInt();
    		
    		//ToScreen.displayTableu(activePlayer.playerTableu);
    		//System.out.println("test5");
    		while(activePlayer.playCard(temp, row, col) == false) {
    			System.out.println("Choose the row and column you want to plant in (4x4 grid):");
        		System.out.print("Row (1-4): ");
        		row = input.nextInt();
        		System.out.print("Column (1-4): ");
        		col = input.nextInt();
        		//System.out.println("test6");
    			ToScreen.displayTableu(activePlayer.playerTableu);
    		}
    		//ToScreen.displayTableu(activePlayer.playerTableu);
    	}
//		else if(numPlant == -1) {
//
//		}

    	ToScreen.displayTableu(activePlayer.getTableu());
    	
    	ToScreen.displayHand(activePlayer);
    	
    	//Draw 4 cards, choose 1 to keep and discard the rest into the discard pile
    	//Players do not need to have planted a card to draw a card
    	for(int i = 0; i < 4; i++) {
    		tempHand[i] = gameDeck.dealTopEarthCard();
    	}
    	
    	System.out.println("Choose a card to keep and discard the rest:");
		for(int j = 0; j < 4; j++) {
			System.out.println((j + 1) + ": " + tempHand[j].getName());
		}
		counter = input.nextInt();
    	temp = tempHand[counter - 1];
    	for(int i = 0; i < 4; i++) {
    		if(i != (counter - 1)) {
    	    	//Note: the discarded cards are NOT put into the compost pile
    			gameDeck.discardCard(tempHand[i]);
    			//System.out.println("Discarded card successfully.");
    		} else {
    			activePlayer.hand.add(temp);
    			gameDeck.discardCard(tempHand[i]);
        		ToScreen.displayHand(activePlayer);
        		//System.out.println("Added card to hand successfully.");
    		}
    	}
    	
    	ToScreen.displayHand(activePlayer);
    	
    	//All other players may plant 1 card in their tableau by paying soil and draw 1 card
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
    	
    	//Finally, all players activate the green abilities on their cards
    }

	// Event cards cannot be placed on to the player's Tableau.
	// This is to check if a player selected an Event card to plant
	// and instructs them choose a different card.
	public static int checkEventPlantRedo(int choice, Player activePlayer, Scanner input) {		//Redo for plantingActionRedo
		int selection = choice;
		Card temp = activePlayer.hand.get(selection);

		while (temp.getType().equals("Event")) {
//			ToScreen.cannotPlantEvent();
			System.out.print("Cannot plant an Event card. Choose a Flora or Terrain card: ");
			selection = input.nextInt() - 1;
			if (selection >= 0 && selection < activePlayer.hand.size()){
				temp = activePlayer.hand.get(selection);
				if (!temp.getType().equals("Event")) {
					break;
				}
			}
			else if(selection == -1) {
				return -1;
			}
			else if (selection < 0 || selection >= activePlayer.hand.size()){
				continue;
			}
		}
		return (selection);
	}

	public static Card checkEventPlant(Player activePlayer, Scanner input) {	// this one for plantingAction
		int selection;
		Card temp = activePlayer.hand.get(input.nextInt() - 1);

		while (temp.getType().equals("Event")) {
			ToScreen.cannotPlantEvent();
			selection = input.nextInt();
			if (selection > 0 && selection <= activePlayer.hand.size()){
				temp = activePlayer.hand.get(selection - 1);
				if (!temp.getType().equals("Event")) {
					break;
				}
			}
		}
		return temp;
	}
    
    public static void compostingAction(Player activePlayer, EarthDeck gameDeck/*, Player[] otherPlayers*/) {
    	Card temp;
    	//int choice;
    	
    	//Gain 5 soil and take 2 cards from the draw pile and place them in your compost pile without looking at them
    	activePlayer.addSoil(5);
    	ToScreen.playerChanges("Player 1", 0, 5);
    	temp = gameDeck.dealTopEarthCard();
    	activePlayer.compostCard(temp);
    	activePlayer.adjustVP(1);
    	temp = gameDeck.dealTopEarthCard();
    	activePlayer.compostCard(temp);
    	activePlayer.adjustVP(1);

    	//All other players may gain 2 soil OR compost 2 cards from the draw pile
    	//Temporarily not within the scope of the assignment
    	/*for(int i = 0; i < otherPlayers.length; i++) {
    		//Ask other players to choose 0 to gain soil or 1 to compost
    		if(choice == 0) {
    			otherPlayers[i].addSoil(2);
    			ToScreen.playerChanges("Player #", 0, 2);
    			}
    		} else if(choice == 1) {
    			temp = gameDeck.dealTopEarthCard();
    			otherPlayers[i].compostCard(temp);
    			otherPlayers[i].adjustVP(1);
    			temp = gameDeck.dealTopEarthCard();
    			otherPlayers[i].compostCard(temp);
    			otherPlayers[i].adjustVP(1);
    		}
    		otherPlayers[i].drawCard(gameDeck);
    	}*/
    	
    	//Finally, all players will activate the red and multicolored abilities on their cards
    }
    
    public static void wateringAction(Player activePlayer, Scanner input) {
    	int tempSprouts = 6;
    	int locationToWater;		// 1-16 for spot on tableu to water
    	int amountToWater;

    	//Gain up to 6 sprouts, immediately placing them on any of your flora with empty sprout spaces, then gain 2 soil
    	ToScreen.displayTableu(activePlayer.getTableu());

    	//All other players may either gain up to 2 sprouts OR gain 2 soil
    	//Finally, all players activate the blue and multicolored abilities on their cards
    	//you will score 1 VP per sprout on your tableau at the end of the game
    	//sprouts can be converted to soil at a ratio of 3 sprouts to 2 soil at any time during the game except while gaining them during the watering action or in the middle of a card's ability
    	//you can repeat the sprout to soil conversion (one way) as many times as you want
    	
    	// Reset sprout count if not enough vacant spots
    	int maxEmptySpaces = activePlayer.getTableu().countEmptySprouts();
    	if (maxEmptySpaces < tempSprouts) tempSprouts = maxEmptySpaces;
    	
    	while (tempSprouts > 0) {
    		System.out.println("Number of sprouts to grow: " + tempSprouts);
    		// Select spot to water
    		locationToWater = ToScreen.waterCoord(activePlayer, input);
    		while (!activePlayer.getTableu().chooseCard((locationToWater - 1) / 4, (locationToWater - 1) % 4).getType().equals("Flora")) {
    			System.out.println("\nYou must choose a plant card\n");
    			locationToWater = ToScreen.waterCoord(activePlayer, input);
    		}
    	
    		amountToWater = ToScreen.waterAmt(activePlayer, locationToWater, tempSprouts, input);
    	
    		activePlayer.getTableu().chooseCard(locationToWater).addCurrSprouts(amountToWater);
    	
    		tempSprouts -= amountToWater;
    	}
    }
    
    public static void growingAction(Player activePlayer, EarthDeck gameDeck, Scanner input) {
    	int choice;
    	String yesNo;
    	int growthCounter = 2;
    	Card temp;
    	
    	//Player may draw up to 4 cards from the earth deck and place them in their hand
    	choice = ToScreen.requestInt(input, 0);
    	if(choice != 0) {
    		for(int i = 0; i < choice; i++) {
    			activePlayer.drawCard(gameDeck);
    		}
    	}
    	
    	//Place up to 2 growth on any of your flora with room on their growth space
    	while(growthCounter != 0) {
    		yesNo = ToScreen.requestString(input, 0);
    		if(yesNo == "y") {
    			temp = activePlayer.getTableu().chooseCard(ToScreen.growthCoord(activePlayer, input));
    			if(temp.getType().equals("Flora") && temp.getCurrGrowth() < temp.getGrowthMax()) {
    				activePlayer.getTableu().chooseCard(ToScreen.growthCoord(activePlayer, input)).addCurrGrowth(1);
    				growthCounter--;
    			}
    		} else if(yesNo == "n") {
    			growthCounter = 0;
    		}
    	}
    	//All other players may either draw 2 cards OR place up to 2 growth on their flora
    	//Finally, all players active the yellow and multicolored abilities on their cards
    	//You will score 1 VP per growth on your tableau at the end of the game
    	//Any flora that have reached max growth will instead earn their canopy completion VP
    }
    
    public static void initialSetup(Player activePlayer, EcoDeck ecoSetup, ClimateDeck climateSetup, IslandDeck islandSetup) {
    	//Setup and shuffle EarthDeck
    	//Setup Faunaboard
    	//Shuffle and deal each player 2 (1 double sided card) Ecosystem cards of which the players chose one and discard the other
    	//Shuffle and deal each player 1 Island card
    	//Shuffle and deal each player 1 Climate card
    	//Randomly select first player
    }
}