package tictactoe.gui.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import tictactoe.bll.GameBoard;
import tictactoe.bll.IGameModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HighscoreController implements Initializable {

    public Button btnMenu;
    public Button btnRetry;

    public Button btnMultiplayer;
    public TextArea winnerDisplay;


    public void Menu(ActionEvent actionEvent)throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/IntroView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();


        Stage stage1 = (Stage) TicTacViewController.stage;
        stage1.close();
    }
    public void Retry(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tictactoe/gui/views/TicTacView.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();

        Stage stage1 = (Stage) TicTacViewController.stage;
        stage1.close();
        Stage stage2 = TicTacViewController.stage;
        stage2.close();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(TicTacViewController.winner);
        winnerDisplay.setText(TicTacViewController.winner);
    }
}
