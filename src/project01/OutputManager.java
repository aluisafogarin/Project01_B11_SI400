package Project01;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * Records output file on CSV format.
 * 
 */
public class OutputManager {

    /**
     * Gets output file path.
     * 
     * @param pathFile Path to input file.
     * @return Path to output file.
     */
    public static String outputFilePath(String pathFile) {
        return pathFile.substring(0, pathFile.length() - 4) + ".csv";
    }

    /**
     * Creates and record output file.
     * 
     * @param data     Text after processment - key and all related words.
     * @param pathFile Path to input file.
     * @exception FileNotFoundException In case it can't creates output file.
     * @return Status of the record operation.
     */
    public static boolean recordOutputFile(ArrayList<String> data, String pathFile) throws FileNotFoundException {
        String outputFilePath = outputFilePath(pathFile);

        PrintWriter writeFile = new PrintWriter(new File(outputFilePath));
        for (String line : data) {
            writeFile.println(line);
        }
        writeFile.close();
        JOptionPane.showMessageDialog(null, "Output file recorded with success!");

        return true;
    }
}