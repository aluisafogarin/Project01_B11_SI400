package project01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.io.IOException;

public class TextManipulator {
    private static String rawText;
    private static String directory = System.getProperty("user.dir");

    public static void readFile(String file) throws IOException {
        
        String path = directory + File.separator + file;
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String line = "";
        while (true) {
            if (rawText == null) {
                rawText = line;
            }
            
            if (line != null) {
                rawText = rawText + line;
            }
            else
                break;
            line = buffRead.readLine();
        }

        System.out.println(rawText);
        buffRead.close();
    }

    private void RemoveCaracteres() {

    }

    private void lowerCase() {

    }

    private void textProcess() {

    }

/*     public List get() {
        return rawText;
    } */

}
