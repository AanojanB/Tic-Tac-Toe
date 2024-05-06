import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends JFrame{

    static JLabel l;

    JButton[][] gridArea = 
    {{new JButton(" "), new JButton(" "), new JButton(" ")}, 
    {new JButton(" "), new JButton(" "),new JButton(" ")}, 
    {new JButton(" "), new JButton(" "),new JButton(" ")}};


    String selectiveChar = "X";
    boolean gameWon = false;
    void createGrid(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++ ){
                gridArea[i][j].setBounds(i*100+100, j*100+100, 100, 100);
                JButton gameInput = gridArea[i][j];
                add(gameInput);
                gridArea[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (!gameInput.getText().equals("X") && !gameInput.getText().equals("O")&& !gameWon){
                            gameInput.setText(selectiveChar);
                    

                        for(int y =0; y<3; y++){
                            if(gridArea[y][0].getText().equals(gridArea[y][1].getText()) && gridArea[y][0].getText().equals(gridArea[y][2].getText())){
                                if (gridArea[y][0].getText().equals("X")||gridArea[y][0].getText().equals("O")){
                                    gameWon = true;
                                    l.setText("Player " + selectiveChar + " Wins!");                         
                                }
                            }
                        }
                        for(int x =0; x<3; x++){
                            if(gridArea[0][x].getText().equals(gridArea[1][x].getText()) && gridArea[0][x].getText().equals(gridArea[2][x].getText())){
                                if (gridArea[0][x].getText().equals("X")||gridArea[0][x].getText().equals("O")){
                                    gameWon = true;
                                    l.setText("Player " + selectiveChar + " Wins!");                         

                                }
                            }
                        }

                        if(!gameWon){
                            if(selectiveChar == "X"){
                                selectiveChar = "O";   
                            }
                            else if (selectiveChar == "O"){
                                selectiveChar = "X";   
                            }
                            l.setText("Player " + selectiveChar + " Go");     
                        }

                        if(gridArea[0][0].getText().equals(gridArea[1][1].getText())&& gridArea[0][0].getText().equals(gridArea[2][2].getText())){
                            if (gridArea[0][0].getText().equals("X")||gridArea[1][1].getText().equals("O")){
                                gameWon = true;
                            }
                        }
                        if(gridArea[2][0].getText().equals(gridArea[1][1].getText())&& gridArea[0][2].getText().equals(gridArea[2][0].getText())){
                            if (gridArea[1][1].getText().equals("X")||gridArea[2][0].getText().equals("O")){
                                gameWon = true;
                            }
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
        JPanel p = new JPanel();  
        setLayout(new BorderLayout());
        pack();
        setSize(500,500);
        setVisible(true);
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.add(l);
        add(p);   
}}
