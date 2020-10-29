package project01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.String;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map; */


public class TextManipulator {
    private static String rawText;
    private static String clearText;
    
    public static String getContentFile(String filePath) throws IOException {

        StringBuilder content = new StringBuilder();
        BufferedReader buffRead = new BufferedReader(new FileReader(filePath));
        String ls = System.getProperty("line.separator");
        String line = "";
        
        while( ( line = buffRead.readLine() ) != null ) {
            content.append(line);
            content.append(ls);
        }

        buffRead.close();
        return content.toString();
    }

    public static void filterAscii(String filePath) throws IOException {
    
        BufferedReader obj = new BufferedReader(new FileReader(filePath));
    

        char[] seuArrayList = removeAccent(((String) obj.readLine())).toCharArray();
        for (char caractere : seuArrayList ) {
            //System.out.println((int)caractere);
            if (((int) caractere == 45) || 
                ((int) caractere >= 65 && (int) caractere <= 90) ||  
                ((int) caractere >= 97 && (int) caractere <= 122)) {
                System.out.println(caractere);
            }
        }
        obj.close();
        //System.out.println(seuArrayList);
    }

    public static String removeAccent(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        //System.out.println(clearText);
    }

    public void lowerCase() {

    }

    public void textProcess() {

    }

}
