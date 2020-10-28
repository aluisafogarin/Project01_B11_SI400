package project01;

import java.io.IOException;

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

    private void start() throws IOException {
        System.out.println("Starting the program...");
        ControlClass control = new ControlClass();

        control.classManager();
    }
}
