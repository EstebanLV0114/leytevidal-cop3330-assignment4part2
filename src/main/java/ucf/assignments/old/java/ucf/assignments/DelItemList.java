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

public class DelItemList {

    public static Stage DeleteItemListStage;
    private Stage current = new Stage();

    public DelItemList(Stage current) {
        this.current = current;
        DeleteItemListStage = this.current;
    }
    public DelItemList(){}

    @FXML
    private Button delete_Item;

    @FXML
    private Button delete_List;

    @FXML
    void DelItem(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SelectItem.fxml")));
        Scene newscene = new Scene(parent);
        current.setScene(newscene);
        current.show();
        DeleteItemListStage.close();
        FXMLLoader load = new FXMLLoader();
        load.setController(new SelectItem(current));

    }

    @FXML
    void DelList(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SelectList.fxml")));
        Scene newscene = new Scene(parent);
        current.setScene(newscene);
        current.show();
        DeleteItemListStage.close();
        FXMLLoader load = new FXMLLoader();
        load.setController(new NewItemList(current));
    }

}

 */