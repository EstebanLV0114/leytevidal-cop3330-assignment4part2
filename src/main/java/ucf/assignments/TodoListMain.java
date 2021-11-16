/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.stage.Stage;


public class TodoListMain extends Application
{

  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage firstStage)
  {
    try
    {
      Parent start = FXMLLoader.load(getClass().getResource("TodoList.fxml"));
      Scene newscene = new Scene(start);
      firstStage.setScene(newscene);
      firstStage.setTitle("To Do List");
      firstStage.show();
    } catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
