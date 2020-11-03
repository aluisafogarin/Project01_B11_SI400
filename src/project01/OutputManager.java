package project01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class OutputManager {

    public static boolean recordOutputFile(ArrayList<String> data, String pathFile) throws FileNotFoundException {
        String outPutFilePath = pathFile.substring(0, pathFile.length() - 4) + ".csv";
        System.out.println(outPutFilePath);
        PrintWriter writeFile = new PrintWriter(new File(outPutFilePath));
        for (String line : data) {
            writeFile.println(line);
        }
        writeFile.close();
        JOptionPane.showMessageDialog(null, "Output file recorded with success!");

        return true;
    }
}