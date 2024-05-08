import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends JFrame{

    static JLabel l;
    static JLabel l2;
    static JLabel l3;
    static JButton replay;

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
                gridArea[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                //Makes the boxes from grid area interactable
                JButton gameInput = gridArea[i][j];
                //Adding clickable boxes to the screen
                add(gameInput);
                 //Function from library to allow for action/change to happen if something happens to the boxe
                gridArea[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        l2.setText("Player X Wins: " + countX);
                        l3.setText("Player O Wins: " + countO);
                        gameInput.setFont(new Font("Arial", Font.PLAIN, 40)); 
                        //If gameInput does not equal X or O make it equal to selective character variable
                        if (!gameInput.getText().equals("X") && !gameInput.getText().equals("O")&& !gameWon){
                            gameInput.setText(selectiveChar);
                            //selectiveChar changes if the most recent turn was X, so the variable is now set to O
                            if(selectiveChar == "X"){
                                selectiveChar = "O";
                                gameInput.setForeground((Color.RED));                                       
                            }
                            //selectiveChar changes if the most recent turn was O, so the variable is now set to X
                            else if (selectiveChar == "O"){
                                selectiveChar = "X";
                                gameInput.setForeground((Color.BLUE)); 
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
                            l3.setText("Player O Wins: " + countO);
                        }
                        else if((player == "X" & gameWon == true)){
                            countX++;
                            l2.setText("Player X Wins: " + countX);
                        }
                    }

                    }
                }

                );
            }
        }
        setLayout(null);
        setVisible(true);
        l = new JLabel("Player X Go");
        l.setBounds(210,20,200,15);
        l.setFont(new Font("Verdana", Font.BOLD, 14));
        JPanel p = new JPanel();  
        p.setLayout(null);

        l2 = new JLabel("Player X Wins: " + countX);
        l2.setBounds(100,425,200,15);
        l2.setFont(new Font("Verdana", Font.BOLD, 14));

        l3 = new JLabel("Player O Wins: " + countO);
        l3.setBounds(300, 425, 200, 15);
        l3.setFont(new Font("Verdana", Font.BOLD, 14));

        replay = new JButton("Play Again?");
        replay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                for(int i = 0; i<3; i++){
                    for(int j = 0; j<3; j++ ){
                        gridArea[i][j].setText(" ");
                    }
                }
                gameWon = false;
            }});
        replay.setBounds(160, 450, 200, 20);
        replay.setFont(new Font("Verdana", Font.BOLD, 14));



        setLayout(new BorderLayout());
        pack();
        setSize(600,600);
        setVisible(true);
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        p.add(l); 
        p.add(l2);         
        p.add(l3);
        p.add(replay);
        add(p);
}}