import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';

        while (true) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", enter row (1-3) and column (1-3): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("⚠️ Spot already taken! Try again.");
            }
        }
    }

    private static void printBoard() {
        System.out.println("\n  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
