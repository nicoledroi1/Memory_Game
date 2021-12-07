import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program will display the game and all the changes that happen
 *
 * @author Nicole Droi
 * @date June 3, 2019
 */
public class MemoryGUI extends JFrame implements ActionListener {

    private JButton next;
    private JButton[] cover;
    private JTextArea numTurns;
    private JLabel[] image;
    private String[] pics;
    private int num = 0;
    private String bChoice = "";
    private int click1, click2;
    private static int gL;
    private JTextArea numT;
    private int score;
    
    /**
     * This constructor is passing the choices
     * if the user did not press any of the radio buttons
     * It chooses 4X4 grid and Number theme
     */
    public MemoryGUI(){
        this(4, "NUMBERS");
    } // end constructor MemoryGUI
    
    /**
     * This constructor is passed the theme choice but not the grid length
     * It chooses 4X4 grid length
     * @param imgChoice is the theme choice passed from ChoiceGUI
     */
    public MemoryGUI(String imgChoice){
        this(4, imgChoice);
    } // end constructor MemoryGUI
    
    /**
     * This constructor is passed the grid length but no the theme choice
     * It chooses Numbers as the theme
     * @param gLChoice is the grid length passed from ChoiceGUI
     */
    public MemoryGUI(int gLChoice){
        this(gLChoice, "NUMBERS");
    } // end constructor MemoryGUI

    /**
     * This constructor is passed both the grid length and theme choice
     * It uses them to create the buttons and the font size depending on the size
     * It also uses the theme choice to chose which file to open
     * @param gLChoice is the grid length passed from ChoiceGUI
     * @param imgChoice is the theme choice passed from ChoiceGUI
     */
    public MemoryGUI(int gLChoice, String imgChoice) {
        super("MEMORY GAME TIME");
        setSize(700, 700);
        
        setGridLength(gLChoice);
        gL = gLChoice;
        
        Container o = getContentPane();
        o.setLayout(null);
        o.setBackground(new Color(0, 153, 0));

        cover = new JButton[gLChoice * gLChoice];
        image = new JLabel[gLChoice * gLChoice];
        setPictureArray(imgChoice, gLChoice);

        int buttonSize = 0;
        int y = 50;
        int x = 50;
        int addX = 0;
        int addY = 0;
        int font = 0;

        if (gLChoice == 4) {
            buttonSize = 100;
            addX = 120;
            addY = addX;
            font = 18;
        } // end if
        else if (gLChoice == 5) {
            buttonSize = 80;
            addX = 100;
            addY = addX;
            font = 15;
        } // end else if
        else if (gLChoice == 6) {
            buttonSize = 70;
            addX = 80;
            addY = addX;
            font = 13;
        } // end else if
        
        for (int i = 0; i < image.length - 1; i++) {
            image[i] = new JLabel(pics[i]);
            image[i].setBounds(x, y, buttonSize, buttonSize);
            image[i].setFont(new Font("Times New Roman", Font.BOLD, font));
            image[i].setVisible(false);
            o.add(image[i]);
            for (int j = i + 1; j < i + gLChoice; j++) {
                x += addX;
                image[j] = new JLabel(pics[j]);
                image[j].setBounds(x, y, buttonSize, buttonSize);
                image[j].setFont(new Font("Times New Roman", Font.BOLD, font));
                image[j].setVisible(false);
                o.add(image[j]);
            } // end for
            y += addY;
            x = 50;
            i += gLChoice - 1;
        } // end for

        y = 50;
        x = 50;
        for (int i = 0; i < cover.length; i++) {
            cover[i] = new JButton();
            cover[i].setBounds(x, y, buttonSize, buttonSize);
            cover[i].addActionListener(this);
            o.add(cover[i]);
            for (int j = i + 1; j < i + gLChoice; j++) {
                x += addX;
                cover[j] = new JButton();
                cover[j].setBounds(x, y, buttonSize, buttonSize);
                cover[j].addActionListener(this);
                o.add(cover[j]);
            } // end for
            y += addY;
            x = 50;
            i += gLChoice - 1;
        } // end for

        next = new JButton("NEXT");
        next.addActionListener(this);
        next.setBounds(200, 560, 200, 50);
        next.setFont(new Font("Times New Roman", Font.BOLD, 20));
        o.add(next);
        
        numTurns = new JTextArea();
        numTurns.setBackground(Color.black);
        numTurns.setForeground(Color.white);
        numTurns.setBounds(560, 220, 100, 150);
        numTurns.setEditable(false);
        numTurns.setFont(new Font("Times New Roman", Font.BOLD, 70));
        o.add(numTurns);
        
        numT = new JTextArea("NUMBER OF TURNS");
        numT.setBounds(560, 150, 100, 50);
        numT.setFont(new Font("Times New Roman", Font.BOLD, 20));
        numT.setBackground(new Color(0, 153, 0));
        numT.setForeground(Color.black);
        numT.setLineWrap(true);
        numT.setWrapStyleWord(true);
        numT.setEditable(false);
        o.add(numT);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    } // end constructor MemoryGUI

    /**
     * This method sets the button array
     * It's given the grid length to set the size of the array
     * The array is the buttons that cover the theme
     * @param grid is the grid size
     */
    public void setButtonArray(int grid) {
        cover = new JButton[grid * grid];
    } // end setButtonArray method

    /**
     * This method returns the button array
     * @return cover (the button array)
     */
    public JButton[] getButtonArray() {
        return cover;
    } // end method getButtonArray

    /**
     * This method sets the label array
     * The label array is the theme that will be behind the buttons
     * @param img is the array of the theme
     */
    public void setLabelArray(JLabel[] img) {
        image = img;
    }  // end method setLabelArray

    /**
     * This method returns the label array
     * @return image which is the label array
     */
    public JLabel[] getLabelArray() {
        return image;
    } // end getLabelArray method
    
    /**
     * This method sets the grid length
     * The grid length is the size of the grid
     * @param gridL is the size of the grid but its the two being multiplied
     */
    public static void setGridLength(int gridL){
        gL = gridL;
    } // end method setGridLength
    
    /**
     * This method returns the grid length
     * @return gL which is the gridLength
     */
    public static int getGridLength(){
        return gL;
    } // end method getGridLength

    /**
     * This method sets the picture array
     * It accesses MemoryProgram which accesses the files that corespond with the theme choice
     * It randomizes the array which has the theme in it 
     * It does this because if it wasn't randomized then the game would be too easy
     * @param img is the theme choice
     * @param gL is the size of the grid 
     */
    public void setPictureArray(String img, int gL) {
        MemoryProgram mP = new MemoryProgram(img, gL, pics);
        pics = mP.makeArray();
        for (int i = 0; i < pics.length; i++){
            double randomPosition = Math.random();
            randomPosition = (int)(randomPosition*gL*gL - 1);
            String temp = pics[i];
            pics[i] = pics[(int)randomPosition];
            pics[(int)randomPosition] = temp;
	} // end for
    } // end method setPictureArray

    /**
     * This method returns the array that has the theme words in it
     * @return pics which is the array that stores the theme words
     */
    public String[] getPictureArray() {
        return pics;
    } // end method getPictureArray

    /**
     * This method checks which of the buttons in the grid are pressed it also makes sure they only press two buttons
     * The buttons are the grid and the next button which is if they are ready to move on
     * It accesses the Memory class to check is the labels are the same and if they have finished the game
     * It stores the clicks to pass to Memory through bChoice
     * It also constantly checks if the user has won or not
     * @param e is checking if the buttons are clicked
     */
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < cover.length; i++) {
            if (num == 2) {
                break;
            } // end if
            if (e.getSource() == cover[i]) {
                cover[i].setVisible(false);
                image[i].setVisible(true);
                bChoice += i + " ";
                num++;
            } // end if 
        } // end for 

        if (e.getSource() == next) {
            if(bChoice == ""){
                
            } // end if
            else{
                for (int i = 0; i < bChoice.length(); i++) {
                  if (bChoice.charAt(i) == ' ') {
                    click1 = Integer.parseInt(bChoice.substring(0, i));
                    click2 = Integer.parseInt(bChoice.substring(i + 1, bChoice.length() - 1));
                    break;
                  } // end if
                }// end for
                Memory m = new Memory(click1, click2, pics);
                if (m.isSame() == true) {
                    num = 0;
                    bChoice = "";
                } // end if
                else {
                    cover[click1].setVisible(true);
                    image[click1].setVisible(false);
                    cover[click2].setVisible(true);
                    image[click2].setVisible(false);
                    num = 0;
                    bChoice = ""; 
                } // end else
                if(m.isWin(gL) == true){
                    new WinGUI(score);
                    dispose();
                } // end if
                
                score = m.getNumTurns();
                numTurns.setText(m.getNumTurns() + "");

              } // end if  
            
            } // end else if
            
    } // end actionPerformed method

} // end MemoryGUI