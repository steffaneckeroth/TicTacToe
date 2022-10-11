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


    public void btnHandleScoreboard(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/HighscoreView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void btnHandleMultiplayer(ActionEvent actionEvent) throws IOException {
        gameMode = 10;
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/MultiplayerNamesView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void btnHandleSingleplayer(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/SingleplayerNameView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

