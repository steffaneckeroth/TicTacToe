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
 *
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
            if (game.getGameMode() == 2) {
                if (game.player(c, r)) {
                    if (game.isGameOver()) {
                        Button btn = (Button) event.getSource();
                        String xOrO = player == 0 ? "X" : "O";
                        btn.setText(xOrO);
                        String winner = game.getWinner();
                        displayWinner(winner);
                        Stage stage1 = (Stage) MultiplayerNamesController.stage;
                        stage1.close();


                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/HighscoreView.fxml"));
                        Parent root = loader.load();
                        stage.setScene(new Scene(root));
                        stage.show();


                    } else {
                        Button btn = (Button) event.getSource();
                        String xOrO = player == 0 ? "X" : "O";
                        btn.setText(xOrO);
                        setPlayer();
                    }
                    //singleplayer
                } else if (game.getGameMode() == 1) {
                    
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard(IntroViewController.gameMode, IntroViewController.player1, IntroViewController.player2);
        setPlayer();
    }

    private void setPlayer()
    {
        lblPlayer.setText(TXT_PLAYER + game.getNextPlayerName());
    }

    private void displayWinner(String winner)
    {
        String message = "";
        message = winner + ":  wins";
        lblPlayer.setText(message);
    }

    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }

}
