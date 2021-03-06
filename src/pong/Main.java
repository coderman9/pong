package pong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("field.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Pong");
        Pong p = loader.getController();
        p.startRound(root);
        primaryStage.setScene(new Scene(root, 1211, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
