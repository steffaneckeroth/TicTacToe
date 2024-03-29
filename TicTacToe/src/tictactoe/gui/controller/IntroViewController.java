package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class IntroViewController {
    public Button btnSingleplayer;
    public Button btnMultiplayer;
    public Button btnScoreboard;

    public static int gameMode;
    public static String player1 = "player1";
    public static String player2 = "player2";

    public static Stage stage = new Stage();


    /**
     * Shows the scoreboard
     *
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void btnHandleScoreboard(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/HighscoreView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * when the multiplayer buttom is pressed the name popup will start.
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void btnHandleMultiplayer(ActionEvent actionEvent) throws IOException {
        gameMode = 2;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/MultiplayerNamesView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();

    }
    /**
    * when the singleplayer buttom is pressed the name popup will start.
     *
    * @param actionEvent
    * @throws I
    */
    @FXML
    private void btnHandleSingleplayer(ActionEvent actionEvent) throws IOException {
        gameMode = 1;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/SingleplayerNameView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

