/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.gui.controller.MultiplayerNamesController;

import java.io.IOException;
import java.util.Objects;

//hey
public class GameBoard implements IGameModel
{

    public GameBoard(int mode, String player1, String player2){
    gameMode= mode;
    this.player1 = player1;
    this.player2 = player2;
    }
    private String player1;
    private String player2;
    private int currentPlayer = 0;
    private int gameMode = 1;
    private String[][] board = new String[3][3];
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        return currentPlayer;
    }

    public void setGameMode(int mode){
        gameMode = mode;
        System.out.println("Det virker");
    }

    public int getGameMode(){ return gameMode;}

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean player(int col, int row)
    {

        if (board[col][row] == null) {//checks if the spot is free

            if (currentPlayer == 0) {//checks if its it is x turn,
                currentPlayer = 1; //changes current player to o
                board[col][row] = "x"; //saves x in the chosen spot
            } else if (currentPlayer == 1) {
                currentPlayer = 0;
                board[col][row] = "o";

            }
            return true;
        } else {
            return false; //returns false if the spot is taken
        }
    }

    public int[] ai()
    {
        int[] field = new int[2];//saves return input

        //field[0] = 1;


        return field; //returns false if the spot is taken

    }

    public boolean isGameOver() throws IOException
    {
        if (Objects.equals(getWinner(), player1) || Objects.equals(getWinner(), player2)) {
            return true;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col] == null){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public String getWinner()
    {
        //checks for vertical win
        for (int row = 0;  row < board.length; row++){
            String outcome = board[row][0] + board[row][1] + board[row][2];
            if (outcome.equals("xxx")){
                return player1;
            } else if (outcome.equals("ooo")) {
                return player2;
            }
        }
        //cheks for horizontal win
        for (int col = 0; col < board.length; col++) {
            String outcome = board[0][col] + board[1][col] + board[2][col];
            if (outcome.equals("xxx")) {
                return player1;
            } else if (outcome.equals("ooo")) {
                return player2;
            }
        }

        String cross1 = board[0][0] + board[1][1] + board[2][2];
        String cross2 = board[0][2] + board[1][1] + board[2][0];
        if (cross1.equals("xxx") || cross2.equals("xxx")){
            return player1;
        } else if (cross1.equals("ooo") || cross2.equals("ooo")) {
            return player2;
        }

        return "draw";
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        //clears the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = null;
            }
        }
    }
    public String getNextPlayerName() {

        if (currentPlayer == 0) {
            return player1;
        }
        else {
            return player2;
        }
    }

    private int[] bestMove(){
        double bestScore = -Double.POSITIVE_INFINITY;
        int[] move = new int[2];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col] == null){
                    board[row][col] = "x";
                    int score = minimax(board, 0, false);
                    board[row][col] = null;
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = row;
                        move[1] = col;
                    }
                }
            }
        }
        board[move[0]][move[1]] = "x";
        return move;
    }

    public int minimax(String[][] board , int depth , boolean isMaximaxing ){
        return 1;
    }
}

