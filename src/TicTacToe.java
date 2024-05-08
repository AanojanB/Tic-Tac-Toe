import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends JFrame{

    static JLabel l;
    static JLabel textLine2;
    static JLabel l2;

    //Creating a 3x3 grid area which is clickable and has the text "Space" inside
    JButton[][] gridArea = 
    {{new JButton(" "), new JButton(" "), new JButton(" ")}, 
    {new JButton(" "), new JButton(" "),new JButton(" ")}, 
    {new JButton(" "), new JButton(" "),new JButton(" ")}};

    //The input of your click
    String selectiveChar = "X";
    //Variable for ending the gae
    boolean gameWon = false;

    int countO = 0;
    int countX = 0;

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
                        
                        
                        if ((player == "O" & gameWon == true)){
                            countO++;
                        }
                        else if((player == "X" & gameWon == true)){
                            countX++;
                        }
                                            
                    }

                    }
                }

                );
            }
        }
        setVisible(true);
        l = new JLabel("Player X Go");
        //l.setBounds(10,10,200,100);

        l.setVerticalAlignment(JLabel.CENTER_ALIGNMENT);

        JPanel p = new JPanel(); 
        p.setLayout(null);
        setLayout(new BorderLayout());
        
        l2 = new JLabel("Player t Go");
        l2.setBounds(10,100,200,100);
        JPanel p3 = new JPanel(); 
        p3.setLayout(null);
        p3.add(l2);
        add(p3);
        
        //

        pack();
        setSize(500,500);
        setVisible(true);
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.add(l);
        add(p);
        
        
        

        /*JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c. gridy = 0;
        panel.add(new JLabel("Label 1:"), c);
        c.gridx = 1 ;
        c.gridy = 0;
        panel.add()*/
}}