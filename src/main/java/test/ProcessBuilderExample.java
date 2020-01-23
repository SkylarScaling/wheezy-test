package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderExample
{
  public ProcessBuilderExample()
  {
    try
    {
      String outputLineFromCommand;

      List<String> commands = new ArrayList<>();
      commands.add("bash");
      commands.add("-c");
      commands.add("ansible-playbook");

      ProcessBuilder builder = new ProcessBuilder(commands);
      
      Process process = builder.start();

      // Capture the output
      BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
      BufferedReader errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));

      // Get the output of the process
      while ((outputLineFromCommand = inputStream.readLine()) != null)
      {
        // This will be displayed in the console...
        System.out.println(outputLineFromCommand);
      }
      inputStream.close();

      // Same for errors, if any
      while ((outputLineFromCommand = errorStream.readLine()) != null)
      {
        System.out.println(outputLineFromCommand);
      }
      errorStream.close();
      process.waitFor();

      System.out.println("Process finished");

    }
    catch (Exception err)
    {
      err.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    // Open the console
    new Console();

    try
    {
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    // Run a process
    new ProcessBuilderExample();

    try
    {
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    // Run a process
    new ProcessBuilderExample();
  }
}
