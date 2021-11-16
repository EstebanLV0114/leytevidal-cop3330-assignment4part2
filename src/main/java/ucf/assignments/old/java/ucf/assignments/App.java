/* package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class App extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            Parent start = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
            Scene newscene = new Scene(start);
            primaryStage.setScene(newscene);
            primaryStage.setTitle("Welcome");
            primaryStage.show();
            FXMLLoader load = new FXMLLoader();
            load.setController(new Home(primaryStage));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

*/