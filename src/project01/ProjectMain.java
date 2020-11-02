package project01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProjectMain {
    public static void main(String[] args) {
        ProjectMain execution = new ProjectMain(); 
        try {
            execution.start();
            // execution.print();
        } catch (Exception exceptionValue) {
            System.out.println(exceptionValue);
        }
    }

    /* Get current directory, separator based on OS and requests the file to the user */
    public String getFileName() {
        //String pathDirectory = System.getProperty("user.dir");
        //String separator = File.separator;

        System.out.println("Insert file name:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        //String path = pathDirectory + separator + fileName;
        return fileName;
    }

    private void start() throws IOException {
        System.out.println("Starting the program...");

        PreAnalyser preAnalyser = new PreAnalyser(this.getFileName());
        preAnalyser.classManager();
    }
}
