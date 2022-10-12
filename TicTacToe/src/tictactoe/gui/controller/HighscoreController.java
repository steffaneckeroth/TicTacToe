package tictactoe.gui.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tictactoe.bll.IGameModel;

import java.io.IOException;

public class HighscoreController extends Application {

    public Button btnMenu;
    public Button btnRetry;

    public Button btnMultiplayer;

    private IGameModel game;
    public TextField winnerDisplay;



    @Override
    public void start(Stage primaryStage) {
    }
    public HighscoreController(){
    }

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


    }

}
