package it.unibo.es3;

/**
 * This interface is responsible for the logic behind the implementation of the GUI and its elements.
 */
public interface Logics {

    /**
     * This method handles the button presses from the GUI.
     * 
     * @return a boolean representing if the hit has been successfull.
     */
    Boolean hit();

    /**
     * This method is used to check if the game has ended, in this case when the matrix is full of true states.
     * 
     * @return a boolean that is true if the game should end, false otherwise.
     */
    Boolean end();

    /**
     * This method is used to get the value of a specific element in the matrix.
     * 
     * @param pair the coordinates of the desired value.
     * @return the boolean representing the value.
     */
    Boolean getPair(Pair<Integer, Integer> pair);
}
