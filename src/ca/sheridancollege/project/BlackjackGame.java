
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;


public class BlackjackGame extends Game {

    protected ArrayList<Card> deck;
    private ArrayList<Card> discardPile;

    public BlackjackGame() {
        super("Blackjack");
        initializeDeck();
        initializeDiscardPile();
    }

    private void initializeDeck() {
        deck = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                deck.add(new Card(value, suit));
            }
        }
    }

    private void initializeDiscardPile() {
        discardPile = new ArrayList<>();
    }

    @Override
    public void play() {
        // Shuffling
        Collections.shuffle(deck);

        // Distributing cards
        for (Player player : getPlayers()) {
            ((BlackjackPlayer) player).dealInitialCards();
        }

        // Play 
        for (Player player : getPlayers()) {
            player.play();
        }

        // Finding winners
        declareWinner();
    }

    @Override
    public void declareWinner() {
        int maxScore = 0;
        ArrayList<Player> winners = new ArrayList<>();

        for (Player player : getPlayers()) {
            int score = ((BlackjackPlayer) player).evaluateScore();
            if (score > maxScore && score <= 21) {
                maxScore = score;
                winners.clear();
                winners.add(player);
            } else if (score == maxScore && score <= 21) {
                winners.add(player);
            }
        }

        if (winners.isEmpty()) {
            System.out.println("No winners this round.");
        } else if (winners.size() == 1) {
            System.out.println("The winner is: " + winners.get(0).getName());
        } else {
            System.out.print("The winners are: ");
            for (Player winner : winners) {
                System.out.print(winner.getName() + " ");
            }
            System.out.println();
        }
    }
}