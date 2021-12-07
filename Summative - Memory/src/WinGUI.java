import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nicole Droi
 * @date June 7, 2019
 */
public class WinGUI extends JFrame implements ActionListener {
    private JLabel youWin;
    private JTextArea congrats;
    private JButton start;
    private JButton leaderBoard;
    private int score;
    
    /**
     * This method shows the message that the user won 
     * There are two buttons that allow the user to either start the game again or see the Leader Board
     * @param s is the score and is passes here so that it can be passed to leader board
     */
    public WinGUI(int s){
        super("MEMORY");
        setSize(600, 600);
        
        score = s;
        
        youWin = new JLabel("YOU WIN!");
        youWin.setFont(new Font("Times New Roman", Font.BOLD, 100));
        youWin.setBounds(50, 70, 600, 160);
        youWin.setForeground(Color.black);
        
        congrats = new JTextArea("CONGRATULATIONS ON YOUR WIN. IT ISN'T EASY, WELL DEPENDING ON THE LEVEL. IF YOU WOULD LIKE TO MOVE A LEVEL UP GO AND START AGAIN. OR IF YOU WOULD LIKE TO CHOSE A DIFFERENT THEME YOU CAN GO AND START AGAIN. HOPE YOU ENJOYED. BYE!");
        congrats.setFont(new Font("Times New Roman", Font.BOLD, 20));
        congrats.setLineWrap(true);
        congrats.setWrapStyleWord(true);
        congrats.setForeground(Color.white);
        congrats.setBackground(Color.black);
        congrats.setBounds(40, 250, 500, 150);
        congrats.setEditable(false);
        
        start = new JButton("START AGAIN");
        start.setFont(new Font("Times New Roman", Font.BOLD, 20));
        start.setBounds(180, 410, 200, 70);
        start.addActionListener(this);
        
        leaderBoard = new JButton("LEADER BOARD");
        leaderBoard.setFont(new Font("Times New Roman", Font.BOLD, 20));
        leaderBoard.setBounds(180, 490, 200, 70);
        leaderBoard.addActionListener(this);
        
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(0, 153, 0));
        c.add(youWin);
        c.add(congrats);
        c.add(start);
        c.add(leaderBoard);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    } // end WinGUI

    /**
     * This method checks if the buttons are clicked
     * The buttons that can be clicked are to start the game again and to get to the leader board
     * @param e is checking if the buttons are clicked
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            new StartGUI();
            dispose();
        } // end if
        else if(e.getSource() == leaderBoard){
            String name = JOptionPane.showInputDialog("What is your name?");
            int gL = MemoryGUI.getGridLength();
            new LeaderBoard_1(score, name, gL);
            dispose();
        } //end else if
    } // end method actionPerformed
    
} // end Win