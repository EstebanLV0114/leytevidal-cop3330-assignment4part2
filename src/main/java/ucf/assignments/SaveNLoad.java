/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;

public class SaveNLoad
{
  public static void saveList(ItemList list, String path)
  {

    File file = new File(path);
    if (file.isDirectory())
    {
      path = path + "/" + list.getName() + ".json";
    }
    try
    {
      Gson gson = new Gson();
      FileWriter write = new FileWriter(path);
      gson.toJson(list.getItem(), write);
      write.flush();
      write.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public static ItemList loadList(String path)
  {
    ItemList list = new ItemList((new File(path).getName()).replaceFirst("[.][^.]+$", ""));
    try
    {
      Gson gson = new Gson();
      FileReader read = new FileReader(path);
      ArrayList<Item> item = gson.fromJson(read, new TypeToken<ArrayList<Item>>() {}.getType());
      list.setItem(FXCollections.observableArrayList(item));
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    return list;
  }
}
