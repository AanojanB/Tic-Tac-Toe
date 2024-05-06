import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends JFrame{
    //static JFrame f = new JFrame();;
    static JTextField t;
    static JLabel l;

    //Creating a 3x3 grid area which is clickable and has the text "Space" inside
    JButton[][] gridArea = 
    {{new JButton(" "), new JButton(" "), new JButton(" ")}, 
    {new JButton(" "), new JButton(" "),new JButton(" ")}, 
    {new JButton(" "), new JButton(" "),new JButton(" ")}};

    //The input of your click
    String selectiveChar = "X";
    //Variable for ending the gae
    boolean gameWon = false;

    String player = "";
    //Function
    void createGrid(){
        //Creating the 3x3 box
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++ ){
                //Setting the size of the grid boxes
                gridArea[i][j].setBounds(i*100+100, j*100+100, 100, 100);
                //Makes the boxes from grid area interactable
                JButton gameInput = gridArea[i][j];
                //Adding clickable boxes to the screen
                add(gameInput);
                 //Function from library to allow for action/change to happen if something happens to the boxe
                gridArea[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //If gameInput does not equal X or O make it equal to selective character variable
                        if (!gameInput.getText().equals("X") && !gameInput.getText().equals("O")&& !gameWon){
                            gameInput.setText(selectiveChar);
                            //selectiveChar changes if the most recent turn was X, so the variable is now set to O
                            if(selectiveChar == "X"){
                                selectiveChar = "O";                            
                            }
                            //selectiveChar changes if the most recent turn was O, so the variable is now set to X
                            else if (selectiveChar == "O"){
                                selectiveChar = "X";
                            }
                        //Checks if there is three in row in the y-axis/there is vertical row of matching characters 
                        for(int y =0; y<3; y++){
                            if(gridArea[y][0].getText().equals(gridArea[y][1].getText()) && gridArea[y][0].getText().equals(gridArea[y][2].getText())){
                                if (gridArea[y][0].getText().equals("X")){
                                    gameWon = true; //gameWon to true so that there are no more inputs once there is three in a row
                                    player = "X";
                                }
                                else if(gridArea[y][0].getText().equals("O")){
                                    gameWon = true;
                                    player = "O";
                                }
                            }
                        }//Checks if there is three in row in the x-axis/there is horizontal row of matching characters
                        for(int x =0; x<3; x++){
                            if(gridArea[0][x].getText().equals(gridArea[1][x].getText()) && gridArea[0][x].getText().equals(gridArea[2][x].getText())){
                                if (gridArea[0][x].getText().equals("X")){
                                    gameWon = true;
                                    player = "X";
                                }
                                else if(gridArea[0][x].getText().equals("O")){
                                    gameWon = true;
                                    player = "O";
                                }
                            }
                        }
                        //Checks if there is three in row in a diagonal line
                        if(gridArea[0][0].getText().equals(gridArea[1][1].getText())&& gridArea[0][0].getText().equals(gridArea[2][2].getText())){
                            if (gridArea[0][0].getText().equals("X")){
                                gameWon = true;
                                player = "X";
                            }
                            else if(gridArea[1][1].getText().equals("O")){
                                gameWon = true;
                                player = "O";
                            }
                        }
                        //Checks if there is three in row in a diagonal line
                        if(gridArea[2][0].getText().equals(gridArea[1][1].getText())&& gridArea[0][2].getText().equals(gridArea[2][0].getText())){
                            if (gridArea[1][1].getText().equals("X")){
                                gameWon = true;
                                player = "X";
                            }
                            else if (gridArea[2][0].getText().equals("O")){
                                gameWon = true;
                                player = "O";
                            }
                        }
                        if(gameWon == true){
                            JOptionPane.showMessageDialog(null, "Player " + player + " has won");
                        }                    
                    }

                    }
                }

                );
            }
        }
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        l = new JLabel("nothing entered");
        t = new JTextField(16);
        Font fo = new Font("Serif", Font.BOLD, 20);
        t.setFont(fo);
        JPanel p = new JPanel();
        p.add(t);   
        setLayout(null);
        setVisible(true);
        add(l);
        add(p);   
}}