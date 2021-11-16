/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoListControllerTest
{
  
  @Test
  void addToList()
  {
    TodoListController controller = new TodoListController();
    controller.itemList = new ItemList("List");
    controller.addToList("Test", "2021-11-12", true);
    Item actual = controller.itemList.getItem().get(0);
    assertEquals("Test", actual.getDesc());
    assertEquals("2021-11-12", actual.getDate());
    assertTrue(actual.isComplete());
  }

  @Test
  void removeFromList()
  {
    TodoListController controller = new TodoListController();
    ItemList original = new ItemList("List");
    Item item1 = new Item("Test1", "Date1", false);
    Item item2 = new Item("Test2", "Date2", true);
    Item item3 = new Item("Test3", "Date3", false);
    original.addItem(item1);
    original.addItem(item2);
    original.addItem(item3);
    controller.itemList = new ItemList("List");
    controller.itemList.setItem(FXCollections.observableArrayList(original.getItem()));
    controller.removeFromList(item3);
    original.removeItem(item3);
    for (int i = 0; i < original.getItem().size(); i++) {
      assertEquals(original.getItem().get(i), controller.itemList.getItem().get(i));
    }
  }

  @Test
  void updateItem()
  {
    TodoListController controller = new TodoListController();
    controller.itemList = new ItemList("List");
    controller.addToList("Test", "2021-11-12", false);
    Item actual = controller.itemList.getItem().get(0);
    assertEquals("Test", actual.getDesc());
    assertEquals("2021-11-12", actual.getDate());
    assertFalse(actual.isComplete());
    controller.updateItem(actual, null, null, true);
    assertTrue(actual.isComplete());
  }

  @Test
  void sortComplete()
  {
    TodoListController controller = new TodoListController();
    controller.itemList = new ItemList("List");
    Item itemA = new Item("Test1", "Date1", false);
    Item itemB = new Item("Test2", "Date2", true);
    Item itemC = new Item("Test3", "Date3", false);
    controller.itemList.addItem(itemA);
    controller.itemList.addItem(itemB);
    controller.itemList.addItem(itemC);
    controller.showComplete();
    for (Item i: controller.filter) {
      assertTrue(i.isComplete());
    }
  }

  @Test
  void sortIncomplete()
  {
    TodoListController controller = new TodoListController();
    controller.itemList = new ItemList("List");
    Item item1 = new Item("Test1", "Date1", false);
    Item item2 = new Item("Test2", "Date2", true);
    Item item3 = new Item("Test3", "Date3", false);
    controller.itemList.addItem(item1);
    controller.itemList.addItem(item2);
    controller.itemList.addItem(item3);
    controller.showIncomplete();
    for (Item i: controller.filter) {
      assertFalse(i.isComplete());
    }
  }

  @Test
  void setName()
  {
    TodoListController controller = new TodoListController();
    controller.itemList = new ItemList("List");
    controller.setName("New Name!");
    assertEquals("New Name!", controller.itemList.getName());
  }

  @Test
  void clearList()
  {

    TodoListController controller = new TodoListController();
    controller.itemList = new ItemList("List");
    controller.addToList("This will be removed", "2021-11-12", true);
    controller.clearList();
    assertEquals(0, controller.itemList.getItem().size());
  }
}