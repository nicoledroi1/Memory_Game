import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * First page where the user will to either chose to start or see the rules
 *
 * @author Nicole Droi
 * @date May 30, 2019
 */
public class StartGUI extends JFrame implements ActionListener {

    private JButton play, rules;
    private JLabel memory;

    /**
     * This method is just here so I can start the program from here
     * Also to start this class
     * @param args an array
     */
    public static void main(String[] args) {
        new StartGUI();
    } // end main method

    /**
     * This constructor makes the GUI element
     * It sets all the buttons and the label to the right size
     */
    public StartGUI() {
        super("MEMORY");
        setSize(600, 600);

        play = new JButton("PLAY");
        play.addActionListener(this);
        play.setFont(new Font("Times New Roman", Font.BOLD, 24));
        play.setBounds(170, 280, 200, 70);

        rules = new JButton("RULES");
        rules.addActionListener(this);
        rules.setFont(new Font("Times New Roman", Font.BOLD, 24));
        rules.setBounds(170, 390, 200, 70);

        memory = new JLabel("MEMORY");
        memory.setFont(new Font("Times New Roman", Font.BOLD, 100));
        memory.setBounds(50, 100, 600, 160);
        memory.setForeground(Color.black);

        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(0, 153, 0));
        c.add(play);
        c.add(rules);
        c.add(memory);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    } // end constructor method

    /**
     * This method checks to see if the buttons are clicked
     * The buttons that could be clicked are play and rules
     * Play is used to start the game
     * Rules is used to pass the game to the rules
     * @param e is checking if the buttons are clicked
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {
            new ChoiceGUI();
            dispose();
        } // end if
        else if (e.getSource() == rules) {
            new RulesGUI();
            dispose();
        } // end else if
    } // end actionPerformed method

} // end StartGui