/*
Ivan Freeman
January 19, 2022,
The purpose of this program is to be able to successfully run a game of Tic-Tac-Toe with two players, and automatically conclude who wins
 */
package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialization variables
        Scanner sc = new Scanner(System.in);
        char turn = 'X';
        char[][] gameBoard = {{'\u0020','\u0020','\u0020'},{'\u0020','\u0020','\u0020'},{'\u0020','\u0020','\u0020'}};
        int[] target = new int[2];
        int turnNumber=1;

        System.out.println("Hey, if you don't win this match of Tic-Tac-Toe i'm gonna replace all the 1997 Ford Fiestas in your house with Nathan's class");
        // a while true loop that takes input from the two players
        // it checks for a win every loop and breaks when it finishes.
        while(true) {
            printArray(gameBoard);
            while (true) {
                System.out.print("Player " + turn + ", Enter a row(0,1,2): ");
                target[0] = sc.nextInt();
                System.out.print("Player "+  turn + ", Enter a column(0,1,2): ");
                target[1] = sc.nextInt();
                if(0 > target[0] || target[0] > 2 || 0 > target[1] || 2 < target[1]){
                    System.out.println("Invalid Index");
                } else if(gameBoard[target[0]][target[1]] == '\u0020') {
                    break;
                } else {
                    System.out.println("Please repeat, that spot is already taken");
                }
            }
            gameBoard[target[0]][target[1]] = turn;
            if(checkForWin(gameBoard)){
                printArray(gameBoard);
                System.out.println(turn+" wins!!");
                break;
            }
            // checks to see if the board is full: if it is and the win check doesn't come back true, it ends the game with a tie.
            if(turnNumber>=9){
                printArray(gameBoard);
                System.out.println("It is a tie............how typical");
                break;
            }
            // swaps player after every turn and adds to the turn count
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
            turnNumber++;
        }
    }
    // A method that prints the board of the game
    public static void printArray(char[][] gameBoard){
        for (char[] chars : gameBoard) {
            System.out.println("-------------\n" + "| " + chars[0] + " | " + chars[1] + " | " + chars[2] + " |");
        }
        System.out.println("-------------");
    }
    // checks to see if there is a win in all four directions -- vertically, horizontally, and the two diagonals
    public static boolean checkForWin(char[][] gameBoard){
        for(int i = 0;i < gameBoard.length;i++){
            if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2] && gameBoard[i][0] != '\u0020'){
                return true;
            } else if(gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i] && gameBoard[0][i] != '\u0020'){
                return true;
            }
        }
        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != '\u0020'){
            return true;
        }
        return gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0] && gameBoard[0][2] != '\u0020';
    }
}
