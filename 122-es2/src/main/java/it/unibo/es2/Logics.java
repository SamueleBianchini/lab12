package it.unibo.es2;

/**
 *  This interface defines the logic for the application.
 */
public interface Logics {

    /**
     * This method updates the button when hit.
     * 
     * @param pair the position of the button that got hit.
     * @return the new character that the button has to display.
     */
    String hit(Pair<Integer, Integer> pair);

    /**
     * This method checks if an ending position has been reached.
     * 
     * @return a boolean that is true if the game has reached an ending position, false otherwise.
     */
    Boolean end();
}
