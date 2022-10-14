/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import java.util.Objects;

public class GameBoard implements IGameModel {

    public GameBoard(int mode, String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private String player1;
    private String player2;
    private int currentPlayer = 0;
    private String[][] board = new String[3][3];
    private String winner;

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer() {
        return currentPlayer;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean player(int col, int row) {

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

    /**
     *checks if the game is over and returns a boolean, if the game is over
     *
     * @return
     */
    public boolean isGameOver(){
        if (Objects.equals(getWinner(), player1) || Objects.equals(getWinner(), player2)) {
            return true;
        }
        //checks if there is anymore moves possible
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == null) {
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
    public String getWinner() {
        //checks for vertical win
        for (int row = 0; row < board.length; row++) {
            String outcome = board[row][0] + board[row][1] + board[row][2];
            if (outcome.equals("xxx")) {
                winner = player1;
                return player1;
            } else if (outcome.equals("ooo")) {
                winner = player2;
                return player2;
            }
        }
        //cheks for horizontal win
        for (int col = 0; col < board.length; col++) {
            String outcome = board[0][col] + board[1][col] + board[2][col];
            if (outcome.equals("xxx")) {
                winner = player1;
                return player1;
            } else if (outcome.equals("ooo")) {
                winner = player2;
                return player2;
            }
        }

        String cross1 = board[0][0] + board[1][1] + board[2][2];
        String cross2 = board[0][2] + board[1][1] + board[2][0];
        if (cross1.equals("xxx") || cross2.equals("xxx")) {
            winner = player1;
            return player1;
        } else if (cross1.equals("ooo") || cross2.equals("ooo")) {
            winner = player2;
            return player2;
        }

        return "draw";
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame() {
        //clears the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = null;
            }
        }
    }

    /**
     * returns the name of the current player as a string
     * @return
     */

    public String getNextPlayerName() {

        if (currentPlayer == 0) {
            return player1;
        } else {
            return player2;
        }
    }

    /**
     * gets the first possiblemove and return an int, for the button that needs to be set in TicTacViewController
     * @return
     */
    public int randomMove() {
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (player(col, row)) {
                    if (row == 0 && col == 0) {
                        board[col][row] = "x";
                        return 1;
                    } else if (col == 1 && row == 0) {
                        board[col][row] = "x";
                        return 2;
                    } else if (col == 2 && row == 0) {
                        board[col][row] = "x";
                        return 3;
                    } else if (col == 0 && row == 1) {
                        board[col][row] = "x";
                        return 4;
                    } else if (col == 1 && row == 1) {
                        board[col][row] = "x";
                        return 5;
                    } else if (col == 2 && row == 1) {
                        board[col][row] = "x";
                        return 6;
                    } else if (col == 0 && row == 2) {
                        board[col][row] = "x";
                        return 7;
                    } else if (col == 1 && row == 2) {
                        board[col][row] = "x";
                        return 8;
                    } else if (col == 2 && row == 2) {
                        board[col][row] = "x";
                        return 9;
                    }
                }
            }
        }
        return 0;
    }
}


