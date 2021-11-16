/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckInputTest
{

  @Test
  void isNull()
  {
    assertTrue(CheckInput.Null(null));
    assertFalse(CheckInput.Null("Hello!"));
  }

  @Test
  void descriptionValidator()
  {
    assertFalse(CheckInput.checkDesc(""));
    assertTrue(CheckInput.checkDesc("This is a description"));
  }

  @Test
  void dateValidator()
  {
    assertFalse(CheckInput.checkDate("2999-99-99"));
    assertTrue(CheckInput.checkDate("2021-11-12"));
  }

  @Test
  void pathValidator()
  {
    assertFalse(CheckInput.checkPath("What you expected something here?"));
    assertTrue(CheckInput.checkPath(getClass().getResource("TestIn.json").getPath()));
  }
}