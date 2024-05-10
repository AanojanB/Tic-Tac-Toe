//creating the App class that will run the game
public class App{
    //main method
    public static void main(String[] args) throws Exception {
        //creating a new instance of the TicTacToe game
        TicTacToe gameTemplate = new TicTacToe();
        //calling the playGame method of the TicTacToe object
        gameTemplate.playGame();
    }
}