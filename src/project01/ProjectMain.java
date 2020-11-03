package project01;

import java.io.IOException;
import javax.swing.JOptionPane;
/** Main class of the project
 * @author Group B11
 * @author Ana Luísa Fogarin - 193948
 * @author Vinicius Lourenço - 225314
 * @author Larissa Correia - 219765
 * @author Verussa de Alencar - 206453
 */

public class ProjectMain {

/** Initial point of execution
 * 
 * @param args Arguments for main method.
 */
    public static void main(String[] args) {
        ProjectMain execution = new ProjectMain(); 
        try {
            execution.start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "File not found!");
            JOptionPane.showMessageDialog(null, "Shutting down the program...");
        }
    }

/**  Requests file name to the user.
 * 
 * @return The file name.
 */
    public String getFileName() {
        String fileName = JOptionPane.showInputDialog("Insert file name:");

        if (!fileName.contains("txt")) {
            fileName = fileName + ".txt";
        }
        System.out.println(fileName);
        return fileName;
    }

/** Starts the program.
 * 
 * @throws IOException Exception control, in case it can't find the file.
 */
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

/** Shuts down the program.
 * 
 */
    public void finish() {
        JOptionPane.showMessageDialog(null, "Shutting down the program...");
    }
}
