import javax.swing.*;

public class App extends JFrame{
    JFrame f;
    App(){

        JButton[][] gridArea = 
        {{new JButton("Space"), new JButton("Space"), new JButton("Space")}, 
        {new JButton("Space"), new JButton("Space"),new JButton("Space")}, 
        {new JButton("Space"), new JButton("Space"),new JButton("Space")}};

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++ ){
                gridArea[i][j].setBounds(i*100+100, j*100+100, 100, 100);
                add(gridArea[i][j]);
            }
        }
        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}
