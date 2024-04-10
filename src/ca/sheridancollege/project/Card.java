
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
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
    
    private final int value;
    
    Value(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
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