public class Main {
    public static void main(String[] args) {

        Tictactoe tictactoe = new Tictactoe();
        do {
            tictactoe.erase();
            tictactoe.xOrO();
            do {
                tictactoe.inputTic();
                tictactoe.outputTic();
                if (tictactoe.gameOverCheck()) {
                    break;
                }
                tictactoe.gameWin();
                if (tictactoe.gameOver) {
                    break;
                }
                tictactoe.robot();
                tictactoe.gameWin();
                if (tictactoe.gameOver) {
                    break;
                }
                tictactoe.gameOverCheck();
            } while (!tictactoe.gameOver);
            //tictactoe.playAgain();
        }while(tictactoe.playAgain());
    }
}

