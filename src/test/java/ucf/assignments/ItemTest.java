/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest
{

  @Test
  void getSetDesc()
  {
    Item testItem = new Item("TestDesc", "TestDate", false);
    assertEquals("TestDesc", testItem.getDesc());
    testItem.setDesc("NewDesc");
    assertEquals("NewDesc", testItem.getDesc());
  }

  @Test
  void getSetDate()
  {
    Item testItem = new Item("TestDesc", "TestDate", false);
    assertEquals("TestDate", testItem.getDate());
    testItem.setDate("NewDate");
    assertEquals("NewDate", testItem.getDate());
  }

  @Test
  void isComplete()
  {
    Item testItem = new Item("TestDesc", "TestDate", false);
    assertFalse(testItem.isComplete());
    testItem.setComplete(true);
    assertTrue(testItem.isComplete());
  }

  @Test
  void testIncomplete()
  {
    Item testItem = new Item("Testing the program", "2021-11-12", false);
    String expected = "On 2021-11-12: Testing the program";
    assertEquals(expected, testItem.toString());
  }

  @Test
  void testComplete()
  {
    Item testItem = new Item("Testing the program", "2021-11-12", true);
    String expected = "On 2021-11-12: Testing the program (COMPLETE)";
    assertEquals(expected, testItem.toString());
  }
}