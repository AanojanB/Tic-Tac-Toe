import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class App extends JFrame{
    JFrame f;

    JButton[][] gridArea = 
    {{new JButton("Space"), new JButton("Space"), new JButton("Space")}, 
    {new JButton("Space"), new JButton("Space"),new JButton("Space")}, 
    {new JButton("Space"), new JButton("Space"),new JButton("Space")}};

    String[][] playerMove = {{"0,0","0,1","0,2"},
                            {"1,0","1,1","1,2"},
                            {"2,0","2,1","2,2"}}; 

    App(){            
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++ ){
                gridArea[i][j].setBounds(i*100+100, j*100+100, 100, 100);
                add(gridArea[i][j]);
                gridArea[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (!textField.getText()){

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
        while(true){
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++ ){
                    app.gridArea[i][j].setText(app.playerMove[i][j]);
                }
            }
        }
    }
}
