import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class App extends JFrame{
    JFrame f;

    JButton[][] gridArea = 
    {{new JButton("Space"), new JButton("Space"), new JButton("Space")}, 
    {new JButton("Space"), new JButton("Space"),new JButton("Space")}, 
    {new JButton("Space"), new JButton("Space"),new JButton("Space")}};
    
    String selectiveChar = "X";

    App(){            
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++ ){
                gridArea[i][j].setBounds(i*100+100, j*100+100, 100, 100);
                JButton gameInput = gridArea[i][j];
                add(gameInput);
                gridArea[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //if (gameInput.getText().equals("X") && !gameInput.getText().equals("O")){
                            gameInput.setText(selectiveChar);
                            if(selectiveChar == "X"){
                                selectiveChar = "O";                            
                            }
                            else if (selectiveChar == "O"){
                                selectiveChar = "X";
                            }
                        }
                    }
               // }

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
