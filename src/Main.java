import helper.DefaultScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static helper.RootStage.rootStage;
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
        //
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("home/homec.fxml"));
        primaryStage.setTitle("CanteenManager");
        primaryStage.setScene(new Scene(root,800,600));
        primaryStage.show();

    }
}
