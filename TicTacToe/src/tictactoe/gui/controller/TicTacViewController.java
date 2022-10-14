/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tictactoe.bll.GameBoard;
import tictactoe.bll.IGameModel;

/**
 * @author Stegger
 */
public class TicTacViewController implements Initializable
{
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    @FXML
    private Label lblPlayer;
    @FXML
    private GridPane gridPane;
    private static final String TXT_PLAYER = "Player: ";
    private IGameModel game;
    public static Stage stage = new Stage();
    public static String winner;

    /**
     * here most of the game runs
     * first it checks for what gamemode you are playing, after that it checks if the move is possible.
     * if it is the move will be shown on the button and it is the next players turn
     * @param event
     */
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            int player = game.getNextPlayer();
            //multiplayer
            if (IntroViewController.gameMode == 2) {
                if (game.player(c, r)) {
                    if (!game.isGameOver()) {
                        Button btn = (Button) event.getSource();
                        String xOrO = player == 0 ? "X" : "O";
                        btn.setText(xOrO);
                        setPlayer();
                    } else {
                        winner = game.getWinner();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/HighscoreView.fxml"));
                        Parent root = loader.load();
                        stage.setScene(new Scene(root));
                        stage.show();
                        MultiplayerNamesController.stage.close();
                    }
                }
            }
            //singleplayer
            else if (IntroViewController.gameMode == 1) {
                if (game.player(c, r)){
                    Button btn = (Button) event.getSource();
                    String xOrO = player == 0 ? "X" : "O";
                    btn.setText(xOrO);
                    setPlayer();
                }
                setAiText(game.randomMove());

                if (game.isGameOver()){
                        winner = game.getWinner();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/HighscoreView.fxml"));
                        Parent root = loader.load();
                        stage.setScene(new Scene(root));
                        stage.show();
                        SingleplayerNameController.stage.close();
                        HighscoreController.stage.close();
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * starts a new game
     * @param event
     */
    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
    }

    /**
     * creates a instance of the gameBoard class
     * makes the Ai first move if it is singleplayer
     *
     * @param url
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param rb
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard(IntroViewController.gameMode, IntroViewController.player1, IntroViewController.player2);
        setPlayer();

        //sets the first x if it is singleplayer
        if (IntroViewController.gameMode ==1){
            setAiText(game.randomMove());
        }
    }

    /**
     * sets name of the player int the top of screen
     */
    private void setPlayer()
    {
        lblPlayer.setText(TXT_PLAYER + game.getNextPlayerName());
    }

    /**
     * clear the board ind view.
     */
    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }

    /**
     * sets text for the AI move
     * @param move
     */
    private void setAiText(int move){
        switch (move){
            case 1:
                btn1.setText("x");
                break;
            case 2:
                btn2.setText("x");
                break;
            case 3:
                btn3.setText("x");
                break;
            case 4:
                btn4.setText("x");
                break;
            case 5:
                btn5.setText("x");
                break;
            case 6:
                btn6.setText("x");
                break;
            case 7:
                btn7.setText("x");
                break;
            case 8:
                btn8.setText("x");
                break;
            case 9:
                btn9.setText("x");
                break;

        }
    }

}
