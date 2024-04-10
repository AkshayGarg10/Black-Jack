
package ca.sheridancollege.project;

/**

 * @author gaksh (Modified for Blackjack)
 */
public class Card {

    
    private Value value;
    private Suit suit;

    public enum Suit {
        Hearts, Diamonds, Spades, Clubs
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Returns a String representation of a card.
     *
     * @return a String representation of a card.
     */
    @Override
    public String toString() {
        return value + " of " + suit;
    }
}