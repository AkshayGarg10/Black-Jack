package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author gaksh
 */
public class main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players (2-5): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();// for handling \n in input buffer

        while (!(numPlayers >= 2 && numPlayers <= 5)) {
            System.out.println("Invalid number of players. Please enter a number between 2 and 5.");
            numPlayers = scanner.nextInt();
            scanner.nextLine();// for handling \n in input buffer
        }

        PlayerList playerList = new PlayerList();
        BlackjackGame game = new BlackjackGame();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            playerList.addPlayer(new BlackjackPlayer(name, game));
        }

        game.setPlayers(playerList.getAllPlayers());
        game.play();
    }
}