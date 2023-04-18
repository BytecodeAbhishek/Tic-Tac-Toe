import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // initialising the board
        char[][] board = new char[3][3];
        for(int row=0; row< board.length; row++){
            for(int col=0; col< board.length; col++){
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+player+ " enter : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(board[row][col] == ' '){
                board[row][col] = player; // place the element
                gameOver = haveWon(board,player);
                if(gameOver){
                    printBoard(board);
                    System.out.println("Player "+player+ " has won ");
                }else{
                    // switching the players
                    if(player == 'X'){
                        player = 'O';
                    }else{
                        player = 'X';
                    }
                }
            }else{
                System.out.println("Invalid Move : ");
            }
        }
    }

    private static boolean haveWon(char[][] board, char player) {
        // check the rows
        for(int row=0; row< board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        // check for col
        for(int col=0; col< board.length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        // check the diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board){
        for(int row=0; row< board.length; row++){
            for(int col=0; col< board.length; col++){
                System.out.print(" | "+board[row][col]);
            }
            System.out.print(" | ");
            System.out.println();
        }
    }
}
