package project01;

import java.io.IOException;
import java.util.Scanner;

public class ControlClass {
    private String fileName;

    protected void classManager() throws IOException {
        getFileName();
        TextManipulator.readFile(fileName); //Lê arquivo 
    }
    
    public void getFileName() 
    {
        System.out.println("Insert file name:");
        Scanner scanner = new Scanner(System.in);
        fileName = scanner.nextLine();
        scanner.close();
    }


    public void print() {
        System.out.println(fileName);
    }

    public String get() {
        return fileName;
    }
   
}
