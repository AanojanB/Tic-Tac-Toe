import javax.swing.*; //Imported library to use function like JButton have clickable areas as well as having click perform an action of changing the space X or O
import java.awt.event.*;
import java.awt.*;

public class App extends JFrame{
    JFrame f;

    //Creating a 3x3 grid area which is clickable and has the text "Space" inside
    JButton[][] gridArea = 
    {{new JButton("Space"), new JButton("Space"), new JButton("Space")}, 
    {new JButton("Space"), new JButton("Space"),new JButton("Space")}, 
    {new JButton("Space"), new JButton("Space"),new JButton("Space")}};
    
    String selectiveChar = "X"; //The input of your click
    boolean gameWon = false; //intializing gameWon as boolean value and setting it to false, so that it will change when a player wins the game

    App(){     //Creating the 3x3 box       
        for(int i = 0; i<3; i++){ 
            for(int j = 0; j<3; j++ ){
                gridArea[i][j].setBounds(i*100+100, j*100+100, 100, 100); //Setting
                JButton gameInput = gridArea[i][j];
                add(gameInput);
                gridArea[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (!gameInput.getText().equals("X") && !gameInput.getText().equals("O")&& !gameWon){
                            gameInput.setText(selectiveChar);
                            if(selectiveChar == "X"){
                                selectiveChar = "O";                            
                            }
                            else if (selectiveChar == "O"){
                                selectiveChar = "X";
                            }
                        for(int y =0; y<3; y++){
                            if(gridArea[y][0].getText().equals(gridArea[y][1].getText()) && gridArea[y][0].getText().equals(gridArea[y][2].getText())){
                                if (gridArea[y][0].getText().equals("X")||gridArea[y][0].getText().equals("O")){
                                    gameWon = true;
                                }
                            }
                        }
                        for(int x =0; x<3; x++){
                            if(gridArea[0][x].getText().equals(gridArea[1][x].getText()) && gridArea[0][x].getText().equals(gridArea[2][x].getText())){
                                if (gridArea[0][x].getText().equals("X")||gridArea[0][x].getText().equals("O")){
                                    gameWon = true;
                                }
                            }
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
        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        App app = new App();     
    }
}
