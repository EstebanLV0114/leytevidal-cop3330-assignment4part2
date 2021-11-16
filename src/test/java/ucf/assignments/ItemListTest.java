/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemListTest
{

  @Test
  void getAndSetTitle()
  {
    ItemList list = new ItemList("List1");
    assertEquals("List1", list.getName());
    list.setName("List2");
    assertEquals("List2", list.getName());
  }

  @Test
  void getAndSetItems()
  {
    ItemList list = new ItemList("List");
    assertEquals(FXCollections.observableArrayList(), list.getItem());
    ObservableList<Item> items = FXCollections.observableArrayList();
    items.add(new Item("Item1", "Date1", false));
    list.setItem(items);
    assertEquals(items, list.getItem());
  }

  @Test
  void addItem()
  {
    ItemList list = new ItemList("Test");
    ObservableList<Item> expectedItems = FXCollections.observableArrayList();
    Item item1 = new Item("Item1", "Date1", false);
    Item item2 = new Item("Item2", "Date2", true);
    expectedItems.add(item1);
    expectedItems.add(item2);
    list.addItem(item1);
    list.addItem(item2);
    assertArrayEquals((expectedItems.toArray(new Item[0])), list.getItem().toArray(new Item[0]));
  }

  @Test
  void removeItem()
  {
    ItemList list = new ItemList("Test");
    ObservableList<Item> expectedItems = FXCollections.observableArrayList();
    Item item1 = new Item("Item1", "Date1", false);
    Item item2 = new Item("Item2", "Date2", true);
    expectedItems.add(item1);
    expectedItems.add(item2);
    Item item3 = new Item("Item3", "Date3", false);
    list.addItem(item3);
    list.addItem(item1);
    list.addItem(item2);
    list.removeItem(item3);
    assertArrayEquals((expectedItems.toArray(new Item[0])), list.getItem().toArray(new Item[0]));
  }

  @Test
  void dateSort()
  {
    ItemList list = new ItemList("Test");
    ObservableList<Item> expectedItems = FXCollections.observableArrayList();
    Item item1 = new Item("Item1", "Date1", false);
    Item item2 = new Item("Item2", "Date2", true);
    Item item3 = new Item("Item3", "Date3", false);
    expectedItems.add(item1);
    expectedItems.add(item2);
    expectedItems.add(item3);
    list.addItem(item2);
    list.addItem(item1);
    list.addItem(item3);
    list.sortDate();
    assertArrayEquals((expectedItems.toArray(new Item[0])), list.getItem().toArray(new Item[0]));
  }
}