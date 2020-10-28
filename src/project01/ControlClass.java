package project01;

import java.util.Scanner;

public class ControlClass 
{

    protected void classManager() {
        TextManipulator.readFile();
    }
    
    protected String getFileName() 
    {
        System.out.println("Insert file name:");
        Scanner scanner = new Scanner(System.in);
        String fileName;

        fileName = scanner.nextLine();
        scanner.close();
        return fileName;
    }

   
}
