package crm;

public class TestDriver {

    public static void main(String[] args){
        EarthDeck earthDeck = new EarthDeck();
        System.out.println("Earth Deck: " + earthDeck);
        EarthDeck.shuffleEarth();

        Player p1 = new Player(EarthDeck.dealTopEarthCard());

        while (true) {
            p1.playCard();
            if(p1.hand.size() == 0) {
                System.out.println("No cards in hand.");
                break;
            }

        }

    }
}