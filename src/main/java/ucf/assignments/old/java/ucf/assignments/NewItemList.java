
/*
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class NewItemList
{

    public static Stage NewItemListStage;
    private Stage current = new Stage();

    public NewItemList(Stage current)
    {
        this.current = current;
        NewItemListStage = this.current;
    }

    public NewItemList()
    {

    }

    @FXML
    private Button NewItem;

    @FXML
    private Button NewList;

    @FXML
    void NewItem(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewItem.fxml")));
        Scene newscene = new Scene(parent);
        current.setScene(newscene);
        current.show();
        NewItemListStage.close();
        FXMLLoader load = new FXMLLoader();
        load.setController(new SelectItem(current));
    }

    @FXML
    void NewList(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddList.fxml")));
        Scene newscene = new Scene(parent);
        current.setScene(newscene);
        current.show();
        NewItemListStage.close();
        FXMLLoader load = new FXMLLoader();
        load.setController(new SelectItem(current));
    }

}
*/