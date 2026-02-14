package org.example;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void printBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public static boolean haveWon(char[][] board, char player){
//    check for row
        for (int i = 0; i < board.length; i++){
            if(board[i][0] == player && board[i][1] == player &&  board[i][2] == player){
                return true;
            }
        }
//    check for col
        for (int i = 0; i < board.length; i++){
            if(board[0][i] == player && board[1][i] == player &&  board[2][i] == player){
                return true;
            }
        }
//    check for diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player "+ player + "Enter: ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println("player " + player + " has won!");
                } else {
                    player = (player == 'X')? 'O': 'X';
                }
            }
            else{
                System.out.println("Invalid move");
            }
        }
        printBoard(board);
    }
}