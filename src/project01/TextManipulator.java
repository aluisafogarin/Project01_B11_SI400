package project01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.String;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
/* import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map; */


public class TextManipulator {
    private String rawText;
    private String lowerText; 

    /* Read input file */
    public static String getContentFile(String filePath) throws IOException {

        StringBuilder content = new StringBuilder();
        BufferedReader buffRead = new BufferedReader(new FileReader(filePath));
        String ls = System.getProperty("line.separator");
        String line = "";

        while ((line = buffRead.readLine()) != null) {
            content.append(line);
            content.append(ls);
        }

        content.append("\n");
        buffRead.close();

        return content.toString();
    }

    public static String lowerCase(String rawText) {
        return rawText.toLowerCase();
    }
    
    public static String removeCharacters(String lowerText) {
        /*  Special caracteres not removed: -, $, % and Space */
        int[] validCharacter= {45, 36, 37, 32};
        int[] accentedVowels = {224, 225, 226, 227, // Accented A 
                                232, 233, 234,      // Accented I
                                236, 237, 238,      // Accented E
                                242, 243, 244, 245, // Accented O                                
                                249, 250, 251};     // Accented U
        char[] arrayText = lowerText.toCharArray();
        String noSpecialCharacter= "";

        for (char character : arrayText) {

            for (int num : validCharacter) {
                if ((int) character == num)
                    { noSpecialCharacter = noSpecialCharacter + character; };
            }

            for (int num : accentedVowels) {
                if ((int) character == num) 
                    { noSpecialCharacter = noSpecialCharacter + character; };
            }
            
            if (
                ((int) character >= 48 && (int) character <= 57) ||     //Numbers
                ((int) character >= 97 && (int) character <= 122)) {      //a until z            
                noSpecialCharacter = noSpecialCharacter + character;
            }                
        }
        return noSpecialCharacter;
    }

    public static void textProcess(String text) {
        ArrayList<String> newList = new ArrayList<String>(Arrays.asList(text.split(" ")));
        int i = 0;
        String emptyString = " ";
        for (String word : newList) {
            System.out.println(word);
            i = i + 1;
            if (word.equals(emptyString)) {
                newList.remove(i);
                System.out.println(i);
            }
        }

        System.out.println(newList);
    }
}
