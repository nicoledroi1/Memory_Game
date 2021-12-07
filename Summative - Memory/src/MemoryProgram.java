/**
 * This is where I will open my files and declare the arrays for the images that will be used in memory
 * 
 * @author Nicole Droi
 * @date June 6, 2019
 */

public class MemoryProgram {
    private String imageChoice;
    private int gridLength;
    private String[] pictures;
    
    /**
     * This constructor are passed the variables and sets them
     * @param imgC is the theme choice
     * @param gL is size of the grid
     * @param pics is the array which will store the parts of the theme
     */
    public MemoryProgram(String imgC, int gL, String[] pics){
        imageChoice = imgC;
        gridLength = gL;
        pictures = pics;
    } // end constructor MemoryProgram
    
    /**
     * This method opens the file that is related to the users choice of theme
     * It also uses the grid length to set the size of the area
     * @return pictures which is the array that will have all the words that go with the theme and the size of the grid  
     */
    public String[] makeArray(){
        pictures = new String[gridLength * gridLength];
        if(gridLength == 5){
            pictures = new String[gridLength * gridLength + 1];
        } // end if
        IO.openInputFile(imageChoice);
        for(int i = 0; i < pictures.length - 1; i++){
            pictures[i] = IO.readLine();
            pictures[i+1] = pictures[i];
            i++;
        } // end for
        IO.closeInputFile();
        return pictures;
    } // end method makeArray

    
} // end MemoryProgram 