import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Rules page where the user will see the rules and understand them
 *
 * @author Nicole Droi
 * @date May 30, 2019
 */
public class RulesGUI extends JFrame implements ActionListener {

    private JButton start;
    private JTextArea rule;
    
    /**
     * This method is just here so I can start the program from here
     * Also to start this class
     * @param args an array
     */
    public static void main(String[] args) {
        new RulesGUI();
    } // end main method 

    /**
     * This method creates the GUI of rules
     * It displays the rules and has a button if the user would like to start the game
     */
    public RulesGUI() {
        super("THE RULES");
        setSize(600, 600);

        rule = new JTextArea("WELCOME TO MEMORY. THIS IS A FUN FILLED GAME THAT HELPS YOU WITH YOUR MEMORY SKILLS. THERE ARE NOT TO MANY RULES SO LETS GET INTO THEM.\n\nTHERE WILL BE A GRID OF BUTTONS. EACH WITH DIFFERENT OBJECTS ACCORDING TO THE THEME YOU CHOOSE UNDERNEATH THEM. BUT THERE ARE PAIRS. YOU WILL HAVE TO FIND THOSE PAIRS. ONCE YOU PRESS A BUTTON YOU WILL SEE WHAT'S UNDER IT. THEN YOU CAN PRESS ANOTHER ONE. YOU CAN ONLY PRESS TWO. AFTER YOU FINISH REMEMBERING WHAT WAS UNDER THOSE BUTTONS YOU PRESS NEXT AND THE OBJECTS ARE COVERED AGAIN. YOU HAVE TO FIND EVERY PAIR TO WIN.\n\nYOU ALWAYS HAVE TO PRESS NEXT TO CONTINUE EVEN IF YOU FIND A PAIR. ALSO WHEN YOU FIND THE LAST PAIR YOU MUST PRESS NEXT. WHEN FINDING A PAIR THOSE TWO PAIRS WILL REMAIN UNCOVERED.");
        rule.setBounds(100, 100, 400, 300);
        rule.setLineWrap(true);
        rule.setWrapStyleWord(true);
        rule.setForeground(Color.WHITE);
        rule.setBackground(Color.BLACK);
        rule.setEditable(false);

        start = new JButton("START");
        start.addActionListener(this);
        start.setFont(new Font("Times New Roman", Font.BOLD, 20));
        start.setBounds(225, 450, 150, 80);

        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(0, 153, 0));
        c.add(rule);
        c.add(start);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    } // end method RulesGUI

    /**
     * This method checks if the button is pressed
     * The button is a start button to start the game
     * It goes to ChoiceGUI
     * @param e is checking if the buttons are clicked
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            new ChoiceGUI();
            dispose();
        } // end if
    } // end actionPerformed

} // end class RulesGUI