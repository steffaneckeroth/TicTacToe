package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SingleplayerNameController {

    public TextField Player1;
    public Button btnSingleLetsPlay;
    public TextField SinglePlayerName;


    @FXML
    private void btnHandleSingleplayer(ActionEvent actionEvent) throws IOException {
        IntroViewController.player1 = "   AI";
        IntroViewController.player2 = SinglePlayerName.getText();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/TicTacView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();

    }
}
