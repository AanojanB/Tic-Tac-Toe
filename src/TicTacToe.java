//importing necessary modules
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//creating the TicTacToe class, which extends the JFrame class to allow it to display graphics
public class TicTacToe extends JFrame{

    //JLabel to display to users whether it is player O's turn or player X's turn
    static JLabel displayCurrentPlayer;
    //JLabel to display to tells user the number of times player X has won
    static JLabel playerXWins;
    //JLabel to display to tells user the number of times player O has won
    static JLabel playerOWins;
    //button the users can press to restart the game
    static JButton replay;

    //Creating a 3x3 grid area which is clickable and will allow the users to place their Xs and Os
    JButton[][] gridArea = 
    {{new JButton(" "), new JButton(" "), new JButton(" ")}, 
    {new JButton(" "), new JButton(" "),new JButton(" ")}, 
    {new JButton(" "), new JButton(" "),new JButton(" ")}};


    //This variable keeps track of what character will appear next time you click a square in the grid
    String selectiveChar = "X";
    //This variable keeps track of whether the game has been one yet or not
    boolean gameWon = false;

    //Counts the number of wins for both players
    int countWinsO = 0;
    int countWinsX = 0;

    //Records current player for the purpose of determining which player has won the game
    String player = "";
    //Method to play the TicTacToe game; to be called in App.java
    void playGame(){
        //Creating the 3x3 box
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++ ){
                //Setting the size of the grid boxes
                gridArea[i][j].setBounds(i*100+100, j*100+100, 100, 100);
                gridArea[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                //Adding grid boxes to the JFrame
                JButton gameInput = gridArea[i][j];
                add(gameInput);
                //Function from library to allow for action/change to happen if the box is clicked on
                gridArea[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //setting the text of both Player X wins and Player Y wins to be equal to the variables
                        //containing this information in case it has been updated
                        playerXWins.setText("Player X Wins: " + countWinsX);
                        playerOWins.setText("Player O Wins: " + countWinsO);
                        //Setting the font of the box that has been clicked on so the Xs and Os do not appear too small
                        gameInput.setFont(new Font("Arial", Font.PLAIN, 40)); 
                        //If gameInput does not equal X or O make it equal to selective character variable
                        if (!gameInput.getText().equals("X") && !gameInput.getText().equals("O")&& !gameWon){
                            gameInput.setText(selectiveChar);
                            //selectiveChar changes if the most recent turn was X, so the variable is now set to O
                            if(selectiveChar == "X"){
                                selectiveChar = "O";
                                gameInput.setForeground((Color.RED)); 
                                displayCurrentPlayer.setText("Player O Go");                                      
                            }
                            //selectiveChar changes if the most recent turn was O, so the variable is now set to X
                            else if (selectiveChar == "O"){
                                selectiveChar = "X";
                                gameInput.setForeground((Color.BLUE)); 
                                displayCurrentPlayer.setText("Player X Go");                                      

                            }
                        //Checks if there is three in row in the y-axis/there is vertical row of matching characters 
                        for(int y =0; y<3; y++){
                            if(gridArea[y][0].getText().equals(gridArea[y][1].getText()) && gridArea[y][0].getText().equals(gridArea[y][2].getText())){
                                //check if player X has three in a row
                                if (gridArea[y][0].getText().equals("X")){
                                    //setting gamewon to true so no one can place any more letters
                                    gameWon = true;
                                    //recording that player X won the game 
                                    player = "X";
                                    //displaying to the users that player X won
                                    displayCurrentPlayer.setText("Player X Wins!");                                      

                                }
                                //check if player O has three in a row
                                else if(gridArea[y][0].getText().equals("O")){
                                    //setting gamewon to true so no one can place any more lette
                                    gameWon = true;
                                    //recording that player O won the game
                                    player = "O";
                                    //displaying to the users that player O won
                                    displayCurrentPlayer.setText("Player O Wins!"); 
                                }
                            }
                        }
                        //Checks if there is three in row in the x-axis/there is horizontal row of matching characters
                        for(int x =0; x<3; x++){
                            //check if player X won
                            if(gridArea[0][x].getText().equals(gridArea[1][x].getText()) && gridArea[0][x].getText().equals(gridArea[2][x].getText())){
                                if (gridArea[0][x].getText().equals("X")){
                                    //setting gamewon to true so no one can place any more letters
                                    gameWon = true;
                                    //recording that player X won the game 
                                    player = "X";
                                    //displaying to the users that player X won
                                    displayCurrentPlayer.setText("Player X Wins!");                                        

                                }
                                //check if player O won
                                else if(gridArea[0][x].getText().equals("O")){
                                    //setting gamewon to true so no one can place any more lette
                                    gameWon = true;
                                    //recording that player O won the game
                                    player = "O";
                                    //displaying to the users that player O won
                                    displayCurrentPlayer.setText("Player O Wins");                                   

                                }
                            }
                        }
                        //Checks if there is three in row in a diagonal line
                        if(gridArea[0][0].getText().equals(gridArea[1][1].getText())&& gridArea[0][0].getText().equals(gridArea[2][2].getText())){
                            //check if player X won
                            if (gridArea[0][0].getText().equals("X")){
                                    //setting gamewon to true so no one can place any more letters
                                    gameWon = true;
                                    //recording that player X won the game 
                                    player = "X";
                                    //displaying to the users that player X won
                                    displayCurrentPlayer.setText("Player X Wins!");                                  

                            }
                            //check if player O won
                            else if(gridArea[1][1].getText().equals("O")){
                                    //setting gamewon to true so no one can place any more lette
                                    gameWon = true;
                                    //recording that player O won the game
                                    player = "O";
                                    //displaying to the users that player O won
                                    displayCurrentPlayer.setText("Player O Wins");                                          

                            }
                        }
                        //Checks if there is three in row in a diagonal line
                        if(gridArea[2][0].getText().equals(gridArea[1][1].getText())&& gridArea[0][2].getText().equals(gridArea[2][0].getText())){
                            //check if player X won
                            if (gridArea[1][1].getText().equals("X")){
                                    //setting gamewon to true so no one can place any more letters
                                    gameWon = true;
                                    //recording that player X won the game 
                                    player = "X";
                                    //displaying to the users that player X won
                                    displayCurrentPlayer.setText("Player X Wins!");                                  

                            }
                            //check if player O won
                            else if (gridArea[2][0].getText().equals("O")){
                                    //setting gamewon to true so no one can place any more lette
                                    gameWon = true;
                                    //recording that player O won the game
                                    player = "O";
                                    //displaying to the users that player O won
                                    displayCurrentPlayer.setText("Player O Wins");                                       

                            }
                        }
                        
                        //checking if player O has won the game
                        if ((player == "O" & gameWon == true)){
                            //incrementing the player O win counter by 1
                            countWinsO++;
                            //displaying the current number of player O wins to the user
                            playerOWins.setText("Player O Wins: " + countWinsO);
                            //telling the users that player O has won
                            displayCurrentPlayer.setText("Player O Wins!");                                      

                        }
                        //checking if player X has won the game                        
                        else if((player == "X" & gameWon == true)){
                            //incrementing the player X win counter by 1
                            countWinsX++;
                            //displaying the current number of player X wins to the user
                            playerXWins.setText("Player X Wins: " + countWinsX);
                            //telling the users that player X has won
                            displayCurrentPlayer.setText("Player X Wins!");                                      

                        }
                    }

                    }
                }

                );
            }
        }
        //setting up the current player JLabel
        displayCurrentPlayer = new JLabel("Player X Go");
        displayCurrentPlayer.setBounds(210,20,200,15);
        displayCurrentPlayer.setFont(new Font("Verdana", Font.BOLD, 14));
        //creating a new JPanel to put the JLabel into
        JPanel p = new JPanel();
        //setting the layout of the JPanel to null so that the individual components can be positioned manually
        p.setLayout(null);
        //setting up the player X wins JLabel
        playerXWins = new JLabel("Player X Wins: " + countWinsX);
        playerXWins.setBounds(100,425,200,15);
        playerXWins.setFont(new Font("Verdana", Font.BOLD, 14));
        //setting up the player O wins JLabel
        playerOWins = new JLabel("Player O Wins: " + countWinsO);
        playerOWins.setBounds(300, 425, 200, 15);
        playerOWins.setFont(new Font("Verdana", Font.BOLD, 14));
        //setting up the replay game JButton
        replay = new JButton("Play Again?");
        //adding an action listener so that the button can detect when it has been pressed
        replay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                //looping through each button in the 3x3 grid
                for(int i = 0; i<3; i++){
                    for(int j = 0; j<3; j++ ){
                        //setting each button's text to be blank to get rid of the Xs and Os
                        gridArea[i][j].setText(" ");
                    }
                }
                //setting gameWon to be false so that the players can play again
                gameWon = false;
                //making it player X's turn again
                displayCurrentPlayer.setText("Player X Go");
                selectiveChar = "X";
            }});
        //setting the size, position, and font of the JButton
        replay.setBounds(160, 450, 200, 20);
        replay.setFont(new Font("Verdana", Font.BOLD, 14));

        //creating a new borderlayout for the JFrame
        setLayout(new BorderLayout());
        //packing the JFrame
        pack();
        //setting the size of the JFrame
        setSize(600,600);
        //seting the JFrame to be visible so that the users can see it
        setVisible(true);
        //setting the title of the JFrame
        setTitle("Tic-Tac-Toe");
        //making it so the JFrame closes when you press the X in the top corner
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //adding all labels and buttons to the JPanel
        p.add(displayCurrentPlayer); 
        p.add(playerXWins);         
        p.add(playerOWins);
        p.add(replay);
        //adding the JPanel to the JFrame
        add(p);
}}
