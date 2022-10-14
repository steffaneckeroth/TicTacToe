package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tictactoe.gui.TicTacToe;

import java.io.IOException;

public class SingleplayerNameController {

    public TextField Player1;
    public Button btnSingleLetsPlay;
    public TextField SinglePlayerName;
    public static Stage stage = new Stage();

    /**
     * saves name of player and launches gameboard
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void btnHandleSingleplayer(ActionEvent actionEvent) throws IOException {
        IntroViewController.player1 = "   AI";
        IntroViewController.player2 = SinglePlayerName.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/TicTacView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
        Stage stage1 = (Stage) IntroViewController.stage;
        stage1.close();
        Stage stage2 = (Stage) TicTacToe.st.getScene().getWindow();
        stage2.close();

    }
}
