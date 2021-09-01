import java.util.Random;
import java.util.Scanner;

public class Tictactoe {

    char[][] tic = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    char choice;
    char opchoice;
    boolean gameOver;

    public void erase(){
     for(int i=0;i< tic.length;i++){
         for(int j=0;j< tic[i].length;j++){
             tic[i][j]='-';
         }
     }
    }
    public void xOrO(){
        boolean input;
        System.out.println("X or O?");
        do{
           choice = scanner.next().charAt(0);
           choice = Character.toUpperCase(choice);
            if(choice == 'X' || choice == 'O'){
                input = true;
            }
                else{
                    System.out.println("Wrong Input. Try Again");
                    input = false;
                }
        }while(!input);
        if(choice == 'X'){
            opchoice = 'O';
        }
        else
            opchoice = 'X';
    }

    public void inputTic() {
        int row = 0;
        int column = 0;
        boolean input = true;
        System.out.println("Your Turn!!");
        do {
            do {
                System.out.println("Row: ");
                row = scanner.nextInt();
                row = row - 1;
                System.out.println("Column");
                column = scanner.nextInt();
                column = column - 1;
                if (row >= 0 && row <= 3 && column >= 0 && column <= 3) {
                    input = true;
                }
                 else {
                    System.out.println("Wrong Input!!");
                    input = false;
                }
            }while (!input);
            if (tic[row][column] == '-') {
                tic[row][column] = choice;
                input = true;
            } else {
                System.out.println("Wrong Input. Try Again!!");
                input = false;
            }
        } while (!input);
    }

    public void outputTic() {
        for (int i = 0; i < tic.length; i++) {
            for (int j = 0; j < tic[i].length; j++) {
                System.out.print(tic[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public void robot() {
        System.out.println("Opponent's Turn!!");
        int exitCode = 0;
        while (exitCode == 0) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (tic[x][y] != choice & tic[x][y] != opchoice) {
                tic[x][y] = opchoice;
                exitCode = 1;
            }
        }
        outputTic();
    }

    public boolean gameOverCheck() {
        gameOver = true;
        for (int i = 0; i < tic.length; i++) {
            for (int j = 0; j < tic[i].length; j++) {
                if (tic[i][j] == '-') {
                    gameOver = false;
                }
            }
        }
        return gameOver;
    }
    public void gameWin(){
        boolean opGameWin = false;
        boolean gameWin = false;
        gameOver = false;
        //opponent result check
        if(tic[0][0] == opchoice & tic[0][1] == opchoice & tic[0][2] == opchoice){
        opGameWin = true;}
        if(tic[1][0] == opchoice & tic[1][1] == opchoice & tic[1][2] == opchoice){
            opGameWin = true;}
        if(tic[2][0] == opchoice & tic[2][1] == opchoice & tic[2][2] == opchoice){
            opGameWin = true;}
        if(tic[0][0] == opchoice & tic[1][0] == opchoice & tic[2][0] == opchoice){
            opGameWin = true;}
        if(tic[0][1] == opchoice & tic[1][1] == opchoice & tic[2][1] == opchoice){
            opGameWin = true;}
        if(tic[0][2] == opchoice & tic[1][2] == opchoice & tic[2][2] == opchoice){
            opGameWin = true;}
        if(tic[0][0] == opchoice & tic[1][1] == opchoice & tic[2][2] == opchoice){
            opGameWin = true;}
        if(tic[0][2] == opchoice & tic[1][1] == opchoice & tic[2][0] == opchoice){
            opGameWin = true;}

        //your result check
        if(tic[0][0] == choice & tic[0][1] == choice & tic[0][2] == choice){
            gameWin = true;}
        if(tic[1][0] == choice & tic[1][1] == choice & tic[1][2] == choice){
            gameWin = true;}
        if(tic[2][0] == choice & tic[2][1] == choice & tic[2][2] == choice){
            gameWin = true;}
        if(tic[0][0] == choice & tic[1][0] == choice & tic[2][0] == choice){
            gameWin = true;}
        if(tic[0][1] == choice & tic[1][1] == choice & tic[2][1] == choice){
            gameWin = true;}
        if(tic[0][2] == choice & tic[1][2] == choice & tic[2][2] == choice){
            gameWin = true;}
        if(tic[0][0] == choice & tic[1][1] == choice & tic[2][2] == choice){
            gameWin = true;}
        if(tic[0][2] == choice & tic[1][1] == choice & tic[2][0] == choice){
            gameWin = true;}

        if(gameWin) {
            System.out.println("Congratulations!! You win!!");
            gameOver = true;
        }
        if(opGameWin) {
            System.out.println("You Lost!!");
            gameOver = true;
        }
    }
    public boolean playAgain(){
        char play;
        boolean playagain;
        System.out.println("Play Again? (y/n)");
        play = scanner.next().charAt(0);
        if(play == 'y'){
            playagain = true;
        }
        else
            playagain = false;
        return playagain;
    }
}

