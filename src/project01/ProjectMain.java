package project01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ProjectMain {
    public static void main(String[] args) {
        ProjectMain execution = new ProjectMain(); 
        try {
            execution.start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "File not found!");
            JOptionPane.showMessageDialog(null, "Shutting down the program...");
        }
    }

    /* Get current directory, separator based on OS and requests the file to the user */
    public String getFileName() {
        String fileName = JOptionPane.showInputDialog("Insert file name:");

        if (!fileName.contains("txt")) {
            fileName = fileName + ".txt";
        }
        System.out.println(fileName);
        return fileName;
    }

    public void start() throws IOException {
        JOptionPane.showMessageDialog(null, "Starting the program...");

        PreAnalyser preAnalyser = new PreAnalyser(this.getFileName());
        if (preAnalyser.classManager()) {
            ProjectMain execution = new ProjectMain(); 
            execution.finish();
        } else {
            JOptionPane.showMessageDialog(null, "Something happened during the process. Please, try again.");
            ProjectMain execution = new ProjectMain(); 
            execution.finish();
        }
    }

    public void finish() {
        JOptionPane.showMessageDialog(null, "Shutting down the program...");
    }
}
