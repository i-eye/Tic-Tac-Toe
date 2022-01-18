package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // initialization variables
        Scanner sc = new Scanner(System.in);
        char turn = 'X';
        char[][] gameBoard = {{'\u0020','\u0020','\u0020'},{'\u0020','\u0020','\u0020'},{'\u0020','\u0020','\u0020'}};
        int[] target = new int[2];



        System.out.println("Hey, if you don't win this match of Tic-Tac-Toe i'm gonna write Nathan's library on all the pieces of paper in your home");
        // a while true loops that takes input from the two players
        // it checks for a win every loop and breaks when it finishes.
        while(true) {
            printArray(gameBoard);
            while (true) {
                System.out.print("Player " + turn + ", Enter a row(0,1,2): ");
                target[0] = sc.nextInt();
                System.out.print("Player "+  turn + ", Enter a column(0,1,2): ");
                target[1] = sc.nextInt();
                if (gameBoard[target[0]][target[1]] == '\u0020'){
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
            // swaps player after every turn
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
        }


    }
    // A method that prints the board of the game
    public static void printArray(char[][] gameBoard){
        for(int i = 0;i<=2;i++){
            System.out.println("-------------");
            System.out.println("| "+gameBoard[i][0]+" | "+gameBoard[i][1]+" | "+gameBoard[i][2]+" |");
        }
        System.out.println("-------------");
    }
    // checks to see if there is a win in all four directions -- vertically, horizontally, and the two diagonals
    public static boolean checkForWin(char[][] gameBoard){
        for(int i = 0;i<=2;i++){
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