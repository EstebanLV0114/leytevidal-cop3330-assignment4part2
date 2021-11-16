/*
 *  UCF COP3330 Fall 2021 Assignment 4 Part 2 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.function.Predicate;

public class TodoListController
{
  @FXML
  public Button addAction;
  @FXML
  public Button updateAction;
  @FXML
  public Button removeAction;
  @FXML
  public Button clearList;
  @FXML
  public CheckBox completeBox;
  @FXML
  public Button saveButton;
  @FXML
  public Button sortDate;
  @FXML
  public Button showAll;
  @FXML
  public Button showComplete;
  @FXML
  public Button showIncomplete;
  @FXML
  public Button loadButton;
  @FXML
  public Button setName;
  @FXML
  public ListView<Item> itemShow;
  @FXML
  public TextField listName;
  @FXML
  public TextField dateBox;
  @FXML
  public TextField descBox;
  @FXML
  public TextField pathBox;

  public ItemList itemList;
  public ObservableList<Item> filter;

  @FXML
  public void initialize()
  {
    itemList = new ItemList("List");
    itemShow.setItems(itemList.getItem());
    removeAction.disableProperty().bind(itemShow.getSelectionModel().selectedItemProperty().isNull());
    updateAction.disableProperty().bind(itemShow.getSelectionModel().selectedItemProperty().isNull());
    ref();
  }

  @FXML
  public void ref()
  {

    if (descBox.isEditable())
      descBox.setText(null);
    else
      descBox.setEditable(true);

    if (dateBox.isEditable())
      dateBox.setText(null);
    else
      dateBox.setEditable(true);

    if (pathBox.isEditable())
      pathBox.setText(null);
    else
      pathBox.setEditable(true);

    completeBox.setSelected(false);
  }

  @FXML
  public void addActionClicked(ActionEvent actionEvent)
  {
    addToList(descBox.getText(), dateBox.getText(), completeBox.isSelected());
    ref();
  }

  @FXML
  public void removeActionClicked(ActionEvent actionEvent)
  {
    removeFromList(itemShow.getSelectionModel().getSelectedItem());
    ref();
  }

  @FXML
  public void updateActionClicked(ActionEvent actionEvent)
  {
    updateItem(itemShow.getSelectionModel().getSelectedItem(),
            descBox.getText(), dateBox.getText(), completeBox.isSelected());
    ref();
  }

  @FXML
  public void saveClicked(ActionEvent actionEvent)
  {
    save();
    ref();
  }

  @FXML
  public void loadClicked(ActionEvent actionEvent)
  {
    load();
    ref();
  }

  @FXML
  public void sortDateClicked(ActionEvent actionEvent)
  {
    itemList.sortDate();
    ref();
  }

  @FXML
  public void showAllClicked(ActionEvent actionEvent)
  {
    itemShow.setItems(itemList.getItem());
  }

  @FXML
  public void showCompleteClicked(ActionEvent actionEvent)
  {
    showComplete();
    itemShow.setItems(filter);
    ref();
  }



  @FXML
  public void showIncompleteClicked(ActionEvent actionEvent)
  {
    showIncomplete();
    itemShow.setItems(filter);
    ref();
  }

  @FXML
  public void setNameClicked(ActionEvent actionEvent)
  {
    setName(listName.getText());
    ref();
  }


  @FXML
  public void clearClicked(ActionEvent actionEvent)
  {
    clearList();
    itemShow.setItems(itemList.getItem());
    ref();
  }


  public void updateItem(Item i, String description, String date, boolean flag)
  {
    itemList.removeItem(i);
    if (!CheckInput.Null(description) && description.length() != 0)
    {
      if (CheckInput.checkDesc(description))
      {
        i.setDesc(description);
      }
      else
      {
        descBox.setText("ERR: Invalid description entered, make sure its less than 256 characters");
        descBox.setEditable(false);
      }
    }
    if (!CheckInput.Null(date) && date.length() != 0)
    {
      if (CheckInput.checkDate(date))
      {
        i.setDate(date);
      }
      else
      {
        dateBox.setText("ERR: Invalid date entered, please provide an accurate date");
        dateBox.setEditable(false);
      }
    }
    i.setComplete(flag);
    itemList.addItem(i);
  }

  public void save()
  {
    if (CheckInput.checkPath(pathBox.getText()))
    {
      SaveNLoad.saveList(itemList, pathBox.getText());
    }
    else
    {
      pathBox.setText("ERR: Invalid path entered, please make sure that the path exists and try again");
      pathBox.setEditable(false);
    }
  }

  public void addToList(String description, String date, boolean flag)
  {

    boolean check = true;
    if (CheckInput.Null(description))
    {
      descBox.setText("ERR: No description entered");
      descBox.setEditable(false);
      check = false;
    }
    else
    {
      if (!CheckInput.checkDesc(description))
      {
        descBox.setText("ERR: Invalid string entered for description");
        descBox.setEditable(false);
        check = false;
      }
    }
    if (CheckInput.Null(date))
    {
      dateBox.setText("ERR: No date entered");
      dateBox.setEditable(false);
      check = false;
    }
    else {
      if (!CheckInput.checkDate(date))
      {
        dateBox.setText("ERR: Invalid string entered, please enter an accurate date");
        dateBox.setEditable(false);
        check = false;
      }
    }
    if (check)
    {
      Item i = new Item(description, date, flag);
      itemList.addItem(i);
    }
  }

  public void load()
  {
    if (CheckInput.checkPath(pathBox.getText()))
    {
      itemList = SaveNLoad.loadList(pathBox.getText());
      itemShow.setItems(itemList.getItem());
    }
    else {
      pathBox.setText("ERR: Invalid path entered, please make sure that the path exists and try again");
      pathBox.setEditable(false);
    }
  }

  public void showComplete()
  {
    filter = itemList.getItem().filtered(Item::isComplete);
  }

  public void showIncomplete()
  {
    filter = itemList.getItem().filtered(Predicate.not(Item::isComplete));
  }

  public void removeFromList(Item i)
  {
    itemList.removeItem(i);
  }

  public void setName(String title)
  {
    itemList.setName(title);
  }

  public void clearList()
  {
    ObservableList<Item> emptyList = FXCollections.observableArrayList();
    itemList.setItem(emptyList);
  }
}
