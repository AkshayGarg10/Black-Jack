
package ca.sheridancollege.project;

import java.util.ArrayList;


public abstract class Player {

    private String name; // the unique name for this player

   
    public Player(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    /**
     * The method to be overridden when you subclass the Player class with your
     * specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();

}

