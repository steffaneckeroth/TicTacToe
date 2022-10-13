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

public class MultiplayerNamesController {
    public TextField Player1;
    public TextField Player2;
    public Button btnMultiLetsPlay;

    public static Stage stage = new Stage();

    @FXML
    private void btnHandleMultiLetsPlay(ActionEvent actionEvent) throws IOException {
        IntroViewController.player1 = Player1.getText();
        IntroViewController.player2 = Player2.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/TicTacView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
        closeView();
    }

    //closes namePopUp ann introview.
    private void closeView(){
        Stage namePopUp = (Stage) IntroViewController.stage;
        namePopUp.close();
        Stage introView = (Stage) TicTacToe.st.getScene().getWindow();
        introView.close();
    }
}
