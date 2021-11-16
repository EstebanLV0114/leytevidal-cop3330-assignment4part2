/*
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.Objects;

public class Home
{

    @FXML
    private Button CreateListItem;

    @FXML
    private Button ViewLists;

    @FXML
    private Button DelListItem;

    public static Stage StartupStage;
    private Stage current = new Stage();

    public Home(Stage current)
    {
        this.current = current;
        StartupStage = this.current;
    }
    public Home()
    {

    }

    @FXML
    void CreateItemOrList(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateItemList.fxml")));

        Scene newscene = new Scene(parent);
        current.setScene(newscene);
        current.show();
        FXMLLoader load = new FXMLLoader();
        load.setController(new NewItemList(current));
        StartupStage.close();
    }

    @FXML
    void DelItemOrList(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DelItemList.fxml")));

        Scene scene = new Scene(root);
        current.setScene(scene);
        current.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new DelItemList(current));
        StartupStage.close();
    }

    @FXML
    void ViewList(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Actions.fxml")));
        Scene newscene = new Scene(parent);
        current.setScene(newscene);
        current.setTitle("To Do List");
        current.show();
        FXMLLoader load = new FXMLLoader();
        load.setController(new NewItemList(current));
        StartupStage.close();
    }

}

 */
