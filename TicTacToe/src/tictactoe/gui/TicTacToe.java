/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.gui.controller.IntroViewController;

/**
 *
 * @author Stegger
 */
public class TicTacToe extends Application
{
    public static Stage st = new Stage();
    @Override
    public void start(Stage stage) throws Exception
    {
     
        
        Parent root = FXMLLoader.load(getClass().getResource("views/IntroView.fxml"));

        Scene scene = new Scene(root);
        st.setScene(scene);
        st.setResizable(false);
        st.setTitle("Tic Tac Toe");
        st.centerOnScreen();
        st.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
