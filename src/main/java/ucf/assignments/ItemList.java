/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import java.util.Comparator;
import javafx.collections.ObservableList;

public class ItemList
{
  // Set the name of the list and add items as an ObservableArrayList
  private String title;
  private ObservableList<Item> items;
  public ItemList(String name)
  {
    this.title = name;
    this.items = FXCollections.observableArrayList();
  }

  public void sortDate()
  {
    items.sort(Comparator.comparing(Item::getDate));
  }
  public void setName(String name)
  {
    this.title = name;
  }
  public String getName()
  {
    return title;
  }
  public void setItem(ObservableList<Item> itemList)
  {
    items = itemList;
  }
  public ObservableList<Item> getItem()
  {
    return items;
  }
  public void addItem(Item i)
  {
    items.add(i);
  }
  public void removeItem(Item i)
  {
    items.remove(i);
  }

}
