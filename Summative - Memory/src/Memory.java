/**
 * This program is where all the logic lies. It's where it checks if the pictures are the same and ect.
 * 
 * @author Nicole Droi
 * @date June 5, 2019
 */
public class Memory {

    private int click1;
    private int click2;
    private static int numTurns = 0;
    private static int same = 0;
    private String[] images;

    /**
     * This constructor sets the clicks(of the buttons) and sets the label string
     * It also adds the number of turns because every time it comes here it means the user has had another turn
     * @param c1 is the first button clicked passed from MemoryGUI
     * @param c2 is the second button clicked passed from MemoryGUI
     * @param img is an array that stores the different elements of the theme
     */
    public Memory(int c1, int c2, String[] img) {
        click1 = c1;
        click2 = c2;
        images = img;
        numTurns++;
    } // end constructor Memory

    /**
     * This method sets the buttons that are being clicked
     * @param c1 is the first button clicked
     * @param c2 is the second button clicked
     */
    public void setClick(int c1, int c2) {
        click1 = c1;
        click2 = c2;
    } // end method setClick

    /**
     * This method returns the first button that was clicked
     * @return click1 which is the first button clicked
     */
    public int getClick1() {
        return click1;
    } // end method getClick1
    
    /**
     * This method returns the second button that was clicked
     * @return click2 which is the second button clicked
     */
    public int getClick2(){
        return click2;
    } // end method getClick2

    /**
     * This method returns the number of turns that the user has had throughout the game
     * @return numTurns is the number turns the user has had
     */
    public static int getNumTurns() {
        return numTurns;
    } // end method 

    /**
     * This method checks if the theme behind the buttons that are clicked are the same
     * It uses the images array that stores the different elements of the theme
     * Also it uses the clicks to find where each label is
     * @return either false or true
     * False if it's not the same
     * True if it is the same
     */
    public boolean isSame() {
        if(images[click1].equals(images[click2])){
            same++;
            return true;
        } // end if
        return false;
    } // end method isSame

    /**
     * This method checks if the user has finished the game and won
     * If they did it sets all the variables back to 0 because if they want to play again everything will have to be reset
     * @param gL is the size of the grid
     * @return true or false
     * True if they did win
     * False if they didn't win
     */
    public boolean isWin(int gL) {
        if(same == gL*gL/2){
            same = 0;
            numTurns = 0;
            return true;
        } // end if
        return false;
    } // end method isWin
    
    

} // end class Memory