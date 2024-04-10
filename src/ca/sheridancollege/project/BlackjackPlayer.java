package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**

 * @author gaksh 
 */
public class BlackjackPlayer extends Player {

    private ArrayList<Card> hand;
    private boolean isBusted;
    private BlackjackGame game;
    
    private Scanner scanner = new Scanner(System.in);

    public BlackjackPlayer(String name, BlackjackGame game) {
        super(name);
        hand = new ArrayList<>();
        isBusted = false;
        this.game = game;
    }

    public void dealInitialCards() {
        hand.add(game.deck.remove(0));
        hand.add(game.deck.remove(0));
}

   @Override
   public void play() {
       System.out.println("Player " + getName() + "'s turn:");
       printHand();

       while (!isBusted && shouldHit()) {
           hit();
           printHand();
       }

       if (isBusted) {
           System.out.println("Player " + getName() + " busted!");
       }
   }

   private void hit() {
       hand.add(game.deck.remove(0));
       if (evaluateScore() > 21) {
           isBusted = true;
       }
   }
   

   public int evaluateScore() {
       int score = 0;
       int numAces = 0;

       for (Card card : hand) {
           switch (card.getValue()) {
               case ACE:
                   numAces++;
                   score += 11;
                   break;
               case JACK:
               case QUEEN:
               case KING:
                   score += 10;
                   break;
               default:
                   score += card.getValue().getValue();
           }
       }

       while (score > 21 && numAces > 0) {
           score -= 10;
           numAces--;
       }

       return score;
   }

   private void printHand() {
       System.out.print("Hand: ");
       for (Card card : hand) {
           System.out.print(card + " ");
       }
       int score = evaluateScore();
       System.out.println("\nScore: " + (score > 21 ? "Busted" : score));
   }

   private boolean shouldHit() {
    System.out.print("Hit? (y/n) ");
    String input = scanner.nextLine();
    return input.equals("y");

}
}
