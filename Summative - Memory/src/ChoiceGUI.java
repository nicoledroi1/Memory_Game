import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The page where the user will see the different choices
 *
 * @author Nicole Droi
 * @date May 30, 2019
 */
public class ChoiceGUI extends JFrame implements ActionListener {

    private JButton next;
    private JRadioButton[] gridChoice;
    private JRadioButton[] imgChoice;
    private String[] imgChoices = {"NUMBERS", "ANIMALS", "COLOURS"};
    private int gridC;
    private String themeC;

    /**
     * This method is just here so I can start the program from here
     * Also to start this class
     * @param args an array
     */
    public static void main(String[] args) {
        new ChoiceGUI();
    } // end main method 

    /**
     * This constructor is where all of the GUI elements are
     * It displays all the buttons and radio buttons
     * It's used to find out the grid and theme choice from the user
     */
    public ChoiceGUI() {
        super("THE CHOICE");
        setSize(650, 400);

        Container o = getContentPane();
        o.setLayout(null);
        o.setBackground(new Color(0, 153, 0));

        int y = 50;
        int grid = 4;
        gridChoice = new JRadioButton[3];
        imgChoice = new JRadioButton[3];
        ButtonGroup grids = new ButtonGroup();
        ButtonGroup images = new ButtonGroup();

        for (int i = 0; i < gridChoice.length; i++) {
            gridChoice[i] = new JRadioButton(grid + " X " + grid);
            gridChoice[i].addActionListener(this);
            gridChoice[i].setBounds(125, y, 200, 100);
            gridChoice[i].setBackground(new Color(0, 153, 0));
            gridChoice[i].setFont(new Font("Times New Roman", Font.BOLD, 20));
            grid++;
            grids.add(gridChoice[i]);
            o.add(gridChoice[i]);

            imgChoice[i] = new JRadioButton(imgChoices[i]);
            imgChoice[i].addActionListener(this);
            imgChoice[i].setBounds(350, y, 200, 100);
            imgChoice[i].setBackground(new Color(0, 153, 0));
            imgChoice[i].setFont(new Font("Times New Roman", Font.BOLD, 20));
            images.add(imgChoice[i]);
            o.add(imgChoice[i]);

            y += 70;
        } // end for

        next = new JButton("NEXT");
        next.addActionListener(this);
        next.setBounds(180, 300, 200, 50);
        next.setFont(new Font("Times New Roman", Font.BOLD, 20));
        o.add(next);

        JLabel choose = new JLabel("CHOOSE THE YOUR GRID LEVEL AND THE THEME YOU WOULD LIKE: ");
        choose.setBounds(50, 20, 600, 50);
        choose.setForeground(Color.black);
        choose.setFont(new Font("Times New Roman", Font.BOLD, 15));
        o.add(choose);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    } // end method RulesGUI

    /**
     * This method is checking which buttons are pressed
     * Its setting the theme and grid length and passing it to MemoryGUI
     * @param e is checking if the buttons are clicked
     */
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < gridChoice.length; i++) {
            if (e.getSource() == gridChoice[i]) {
                gridC = i + 4;
            } // end if
        }// end for
        
        for (int j = 0; j < imgChoice.length; j++) {
            if (e.getSource() == imgChoice[j]) {
                themeC = imgChoices[j];
            } // end if
        } // end for   

        if (e.getSource() == next) {
            new MemoryGUI(gridC, themeC);
            dispose();
        } // end if
    } // end actionPerformed

} // end clss ChoiceGUI