
public class Card {
	private short rank, suit;

    private static String[] suits = { "coeur", "pique", "carreau", "trefle" };
    private static String[] ranks  = { "As", "2", "3", "4", "5", "6", "7", 
                                       "8", "9", "10", "Valet", "Dame", "Roi" };

    public static String rankAsString( int __rank ) {
        return ranks[__rank];
    }

    Card(short suit, short rank)
    {
        this.rank=rank;
        this.suit=suit;
    }

    public @Override String toString()
    {
          return ranks[rank] + " of " + suits[suit];
    }

    public short getRank() {
         return rank;
    }

    public short getSuit() {
        return suit;
    }
}
