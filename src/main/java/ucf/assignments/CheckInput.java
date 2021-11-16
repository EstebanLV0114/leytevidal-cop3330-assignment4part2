/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import java.io.File;

public class CheckInput
{
  public static boolean Null(String input)
  {
    return input == null;
  }
  public static boolean checkDesc(String desc)
          // Desc cant be longer than 256 characters
  {
    return (desc.length() <= 256 && desc.length() >= 1);
  }
  public static boolean checkDate(String date)
    /*
Check each character in the string.
Check that the first four characters are numbers, then check that the day and month are two characters (numbers as well).
Make sure they are separated using a dash (-).
Check that the dates are valid in the calendar.
!>> Special exception for February because of its days.
If everything matches up and true, continue. If anything is false, provide error.
 */
  {
    int i = 0;
    if (date.length() != 10)
    {
      return false;
    }
    while (i < 4)
    {
      if (!Character.isDigit(date.charAt(i)))
      {
        return false;
      }
      i++;
    }
    if (date.charAt(i) != '-')
      return false;
    i++;
    while (i < 7)
    {
      if (!Character.isDigit(date.charAt(i)))
      {
        return false;
      }
      i++;
    }
    if (date.charAt(i) != '-')
      return false;
    i++;
    while (i < 10)
    {
      if (!Character.isDigit(date.charAt(i)))
      {
        return false;
      }
      i++;
    }
    if (Integer.parseInt(date.substring(5, 7)) < 1 || Integer.parseInt(date.substring(5, 7)) > 12)
    {
      return false;
    }
    if (Integer.parseInt(date.substring(8, 10)) < 1 || Integer.parseInt(date.substring(8, 10)) > 31)
    {
      return false;
    }

    if (Integer.parseInt(date.substring(5, 7)) == 2)
    {
      if (Integer.parseInt(date.substring(0, 4)) % 4 != 0 && Integer.parseInt(date.substring(8, 10)) > 28)
      {
        return false;
      }
      else if (Integer.parseInt(date.substring(8, 10)) > 29)
      {
        return false;
      }
    }
    return (Integer.parseInt(date.substring(5, 7)) != 4
            && Integer.parseInt(date.substring(5, 7)) != 6
            && Integer.parseInt(date.substring(5, 7)) != 9
            && Integer.parseInt(date.substring(5, 7)) != 11)
            || Integer.parseInt(date.substring(8, 10)) != 31;
  }
  public static boolean checkPath(String path)
  {
    // This will create a file for the path, return true if it is a path or false if not.
    File file = new File(path);
    return file.isDirectory() || file.isFile();
  }
}
