/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SaveNLoadTest {

  @Test
  void saveList()
  {
    ItemList list = new ItemList("TestOut");
    list.addItem(new Item("Testing", "2021-11-12", false));
    SaveNLoad.saveList(list, getClass().getResource("./").getPath());
    assertTrue(new File(getClass().getResource("TestOut.json").getPath()).exists());
  }

  @Test
  void loadList()
  {
    ItemList list = SaveNLoad.loadList(getClass().getResource("TestIn.json").getPath());
    assertEquals("Testing", list.getItem().get(0).getDesc());
    assertEquals("2021-11-12", list.getItem().get(0).getDate());
    assertTrue(list.getItem().get(0).isComplete());
  }

  @Test
  void saveAndLoadList()
  {
    ItemList list = new ItemList("TestOut");
    list.addItem(new Item("Testing", "2021-11-12", false));
    SaveNLoad.saveList(list, getClass().getResource("./").getPath());
    assertTrue(new File(getClass().getResource("TestOut.json").getPath()).exists());
    ItemList newList = SaveNLoad.loadList(getClass().getResource("TestOut.json").getPath());
    assertEquals(list.getName(), newList.getName());
    assertEquals(list.getItem().get(0).getDesc(), newList.getItem().get(0).getDesc());
    assertEquals(list.getItem().get(0).getDate(), newList.getItem().get(0).getDate());
    assertEquals(list.getItem().get(0).isComplete(), newList.getItem().get(0).isComplete());
  }
}