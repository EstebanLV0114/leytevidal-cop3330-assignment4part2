/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

public class Item
{
  private String description;
  private String date;
  private boolean completion;

  public Item(String desc, String date, boolean complete)
  {
    this.description = desc;
    this.date = date;
    this.completion = complete;
    // The three above will set each of the strings respective to what was given.
  }

  public String getDesc()
  {
    return description;
  }
  public void setDesc(String desc)
  {
    this.description = desc;
  }
  public String getDate()
  {
    return date;
  }
  public void setDate(String date)
  {
    this.date = date;
  }
  public boolean isComplete()
  {
    return completion;
  }
  public void setComplete(boolean complete)
  {
    this.completion = complete;
  }

  @Override
  public String toString()
  {
    // This is what will actually show up on the list when an item is added
    // It will put the date first then what the description says
    StringBuilder out = new StringBuilder();
    out.append(date).append(": ").append(description);
    if (isComplete())
      out.append(" (COMPLETE)");
    return out.toString();
  }
}
