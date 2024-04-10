package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
*
* @author gaksh
*/
public class PlayerList {

   private ArrayList<Player> listOfPlayers = new ArrayList<>();

   public PlayerList() {
   }

   public ArrayList<Player> getAllPlayers() {
       return listOfPlayers;
   }

   public void addPlayer(Player p) {
       this.listOfPlayers.add(p);
   }

   public int getNumPlayers() {
       return this.listOfPlayers.size();
   }
}   