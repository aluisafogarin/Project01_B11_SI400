package project01;

import java.io.IOException;
import java.util.Scanner;
import org.w3c.dom.Text;

public class ProjectMain {

    public static void main(String[] args) {
        ProjectMain execution = new ProjectMain();
        try {
            execution.start();
            // execution.print();
        } catch (Exception exceptionValue) {
            System.out.println("File not found.");
        }
    }

    public String getFileName() {
        System.out.println("Insert file name:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        String pathDirectory = System.getProperty("user.dir");
        return pathDirectory + fileName;
    }

    private void start() throws IOException {
        System.out.println("Starting the program...");

        PreAnalyser preAnalyser = new PreAnalyser(this.getFileName());
        preAnalyser.classManager();
    }
}
