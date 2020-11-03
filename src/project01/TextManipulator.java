package project01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.String;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class TextManipulator {

    /* Read input file */
    public static String getContentFile(String filePath) throws IOException {

        StringBuilder content = new StringBuilder();
        BufferedReader buffRead = new BufferedReader(new FileReader(filePath));
        //String ls = System.getProperty("line.separator");
        String line = "";

        while ((line = buffRead.readLine()) != null) {
            content.append(line);
            content.append(" ");
        }

        buffRead.close();

        return content.toString();
    }

    public static String lowerCase(String rawText) {
        return rawText.toLowerCase();
    }

    public static String RemoveCharactersFromWords(String word) {
        int[] validCharacter = {45, 36, 37};
        int[] accentedVowels = {224, 225, 226, 227, // Accented A 
                                232, 233, 234,      // Accented I
                                236, 237, 238,      // Accented E
                                242, 243, 244, 245, // Accented O                                
                                249, 250, 251};     // Accented U

        char[] arrayWord = word.toCharArray();
        String noSpecialCharacter= "";

        for (char character : arrayWord) {

            for (int num : validCharacter) {
                if ((int) character == num)
                    { noSpecialCharacter = noSpecialCharacter + character; };
            }

            for (int num : accentedVowels) {
                if ((int) character == num) 
                    { noSpecialCharacter = noSpecialCharacter + character; };
            }

            if (((int) character != 32) &&
                ((int) character >= 48 && (int) character <= 57) ||     //Numbers
                ((int) character >= 97 && (int) character <= 122)) {    //a until z            
                noSpecialCharacter = noSpecialCharacter + character;
            }
        }
        return noSpecialCharacter;
    }

    /* Transforms String into ArrayList, and remove characters from each word before returning the new array */
    public static ArrayList<String> removeCharacters(String text) {
        ArrayList<String> arrayText = new ArrayList<String>(Arrays.asList(text.split(" ")));
        ArrayList<String> preProcessedText = new ArrayList<String>();

        for (String word : arrayText) {
            String newWord = RemoveCharactersFromWords(word);
            /* Prevents for getting empty word */
            if (!(newWord == ""))
                { preProcessedText.add(newWord); }
        }

        return preProcessedText;
    }

    public static Set<String> removeRepeatedWordsInput(ArrayList<String> preProcessedText) {
        Set<String> keyWords = new TreeSet<>(preProcessedText);
        keyWords.addAll(keyWords);
        return keyWords;
    }

    public static String[] removeRepeatedWordsOutPut(String[] outPut) {
        for (int i = 0; i < outPut.length; i++) {
            outPut[i] = Arrays.stream(outPut[i].split(",")).distinct().collect(Collectors.joining(" "));
        }
        return outPut;
    }

    public static ArrayList<String> textProcess(ArrayList<String> preProcessedText) {
        String nextWord = ""; 

        /* Remove repeated words and get key words */
        Set<String> keyWords = new TreeSet<>(removeRepeatedWordsInput(preProcessedText));
        ArrayList<String> keyWordsArray = new ArrayList<String>(keyWords);

        String[] relatedWords = new String[keyWords.size()];

        for (int i = 0; i < preProcessedText.size(); i++) {
            int position = keyWordsArray.indexOf(preProcessedText.get(i));

            if (i != (preProcessedText.size())-1) 
                nextWord = preProcessedText.get(i+1);
            
            if (nextWord == null) {
                relatedWords[position] = nextWord;

            } else {
                String listWords = relatedWords[position];
                if (listWords != null)
                    listWords = listWords + "," + nextWord; 
                else 
                    listWords = nextWord;
                relatedWords[position] = listWords;
            }
        }
        
        String[] cleanOutPut = new String[keyWords.size()];
        cleanOutPut = removeRepeatedWordsOutPut(relatedWords);
        ArrayList<String> keyValue = new ArrayList<String>();

        for (int i=0; i < keyWordsArray.size(); i++) {
            RelatedWords relateWords = new RelatedWords(keyWordsArray.get(i), cleanOutPut[i]);
            keyValue.add(i, relateWords.getLine());
        }
        return keyValue;
    }
}
