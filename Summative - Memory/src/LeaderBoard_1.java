import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program displays a leader board to show the players the different scores
 * 
 * @author Nicole Droi
 * @date June 10 2019
 */
public class LeaderBoard_1 extends JFrame implements ActionListener{
    
    private JTextArea leaderBoard;
    private JButton start;
    private String[] leader;
    private int length = 0;
    private String board = "";
    private JLabel title;
    
    /**
     * This method displays the Leader Board
     * It accesses the file where all the previous peoples scores have been stored
     * @param score stores the number of moves it took to solve the puzzle, it's passed from win
     * @param name stores the name of the user, it's passed from win
     * @param gridLength stores the size of the grid, it's passed from win
     */
    public LeaderBoard_1(int score, String name, int gridLength) {
        super("Leader Board");
        setSize(700, 700);
        
        if(name.equals("")){
            name = "player";
        } // end if
        
        name.toLowerCase();
        IO.createOutputFile("LEADERBOARD", true);
        IO.println(name + " Score:" + score + " Grid Size:" + gridLength + " x " + gridLength);
        IO.closeOutputFile();
        
        IO.openInputFile("LEADERBOARD");
        String line = IO.readLine();
        while(line != null){
            length++;
            line = IO.readLine();
        } // end while
        IO.closeInputFile();
        
        IO.openInputFile("LEADERBOARD");
        leaderBoard = new JTextArea();
        leader = new String[length];
        for(int i = 0; i < leader.length; i++){
            leader[i] = IO.readLine();
        } // end for
        IO.closeInputFile();
        
        bSort(leader);
        
        for(int j = 0; j < leader.length; j++){
            board += leader[j] + "\n";
        }// end for
        
        leaderBoard.setFont(new Font("Times New Roman", Font.BOLD, 20));
        leaderBoard.setText(board);
        leaderBoard.setBounds(90, 50, 500, 400);
        leaderBoard.setBackground(Color.black);
        leaderBoard.setForeground(Color.white);
        
        title = new JLabel("Leader Board");
        title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        title.setBounds(235, 50, 200, 100);
        
        start = new JButton("START");
        start.addActionListener(this);
        start.setBounds(235, 470, 200, 100);
        start.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        Container o = getContentPane();
        o.setLayout(null);
        o.setBackground(new Color(0, 153, 0));
        o.add(leaderBoard);
        o.add(start);
        o.add(title);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    } // end method LeaderBoard
    
    /**
     * This method sorts the given string by alphabet
     * It is using bubble sort
     * @param string is the array that's given, it will be the array of names and scores which is passed  
     */
    public static void bSort(Comparable[] string) {
        Comparable temp;
        for (int i = 0; i < (string.length - 1); i++) {
            for (int j = 0; j < (string.length - 1 - i); j++) {
                if (string[j].compareTo(string[j + 1]) > 0){
                    temp = string[j];
                    string[j] = string[j + 1];
                    string[j + 1] = temp;
                } // end if
            } // end for
        } // end for
    } // end bSort

    /**
     * This method checks if the buttons are clicked
     * The button is the start button to see if the user wants to play the game again
     * @param e is checking if the buttons are clicked
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            new StartGUI();
            dispose();
        } // end if
    } // end method actionPerformed
    
} // end class LeaderBoard