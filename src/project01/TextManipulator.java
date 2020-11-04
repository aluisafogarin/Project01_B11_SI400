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

/** Does all proceedments related to the text processing.
 */
public class TextManipulator {

    /** Reads input file.
     * 
     * @param filePath Path to input file.
     * @return The content from the input file.
     * @throws IOException Exception control, in case it can't read the file.
     */
    public static String getContentFile(String filePath) throws IOException {

        StringBuilder content = new StringBuilder();
        BufferedReader buffRead = new BufferedReader(new FileReader(filePath));
        String line = "";

        while ((line = buffRead.readLine()) != null) {
            content.append(line);
            content.append(" ");
        }

        buffRead.close();

        return content.toString();
    }

    /** Convert all the text from text to lower case letters.
     * 
     * @param rawText Text as it is on input file.
     * @return Text in lower case letters.
     */
    public static String lowerCase(String rawText) {
        return rawText.toLowerCase();
    }

    /** Removes special characters from the text.
     * 
     * @param text Text withou capital letters.
     * @return New array with text without special characters.
     */
    public static ArrayList<String> removeCharacters(String text) {
        ArrayList<String> arrayText = new ArrayList<String>(Arrays.asList(text.split(" ")));
        ArrayList<String> preProcessedText = new ArrayList<String>();

        /* Sends every word to removeCharactersFromWord to be processed individually */
        for (String word : arrayText) {
            String newWord = removeCharactersFromWords(word);
            /* Prevents for getting empty word */
            if (!(newWord == ""))
                { preProcessedText.add(newWord); }
        }

        return preProcessedText;
    }

    /** Removes special characters from each word individually.
     * @param word Word from the text.
     * @return Word without special characters.
     */
    public static String removeCharactersFromWords(String word) {
        int[] validCharacter = {45, 36, 37, 231}; // -, $, #, ç
        int[] accentedVowels = {224, 225, 226, 227, // Accented A 
                                232, 233, 234,      // Accented I
                                236, 237, 238,      // Accented E
                                242, 243, 244, 245, // Accented O                                
                                249, 250, 251};     // Accented U

        char[] arrayWord = word.toCharArray();
        String noSpecialCharacter= "";

        /* Process each character individually to verify if it is valid */
        for (char character : arrayWord) {
            for (int num : validCharacter) {
                if ((int) character == num) 
                    noSpecialCharacter = noSpecialCharacter + character;
            }

            for (int num : accentedVowels) {
                if ((int) character == num) 
                    noSpecialCharacter = noSpecialCharacter + character;
            }

            if (((int) character != 32) &&
                ((int) character >= 48 && (int) character <= 57) ||     //Numbers 0 to 9
                ((int) character >= 97 && (int) character <= 122)) {    //Letters a to z            
                noSpecialCharacter = noSpecialCharacter + character;
            }
        }
        return noSpecialCharacter;
    }

   /** Removes repeated words from the text.
    * 
    * @param preProcessedText Text without special characters and in lowercase letters.
    * @return Each word without replication - the key words from output.
    */
    public static Set<String> removeRepeatedWordsInput(ArrayList<String> preProcessedText) {
        Set<String> keyWords = new TreeSet<>(preProcessedText);
        keyWords.addAll(keyWords);
        return keyWords;
    }

    /** Removes repeated words after all text processation.
     * 
     * @param outPut Related word array.
     * @return Words related to each key withou replications.
     */
    public static String[] removeRepeatedWordsOutPut(String[] outPut) {
        for (int i = 0; i < outPut.length; i++) {
            outPut[i] = Arrays.stream(outPut[i].split(",")).distinct().collect(Collectors.joining(" "));
        }
        return outPut;
    }

    /** Process text making relationships between each word and the next word
     * @param preProcessedText Text without special characters and in lowercase letters.
     * @return Each word and all related words.  
     */
    public static ArrayList<String> textProcess(ArrayList<String> preProcessedText) {
        String nextWord = ""; 

        /* Remove repeated words and get key words */
        Set<String> keyWords = new TreeSet<>(removeRepeatedWordsInput(preProcessedText));
        ArrayList<String> keyWordsArray = new ArrayList<String>(keyWords);

        String[] relatedWords = new String[keyWords.size()];

        for (int i = 0; i < preProcessedText.size(); i++) {
            int position = keyWordsArray.indexOf(preProcessedText.get(i));

            /* When it is on the last word */
            if (i != (preProcessedText.size())-1) 
                nextWord = preProcessedText.get(i+1);
            
            /* First execution of the loop */
            if (nextWord == null)  
                relatedWords[position] = nextWord;
            else { 
                String listWords = relatedWords[position];
                if (listWords != null) /* When already exists at leat one word related to the key */
                    listWords = listWords + "," + nextWord; 
                else /* When the word is the first related to the key */
                    listWords = nextWord;
                relatedWords[position] = listWords;
            }
        }
        
        /* Creates an array to get the related words withou replications */
        String[] cleanOutPut = new String[keyWords.size()];
        cleanOutPut = removeRepeatedWordsOutPut(relatedWords);

        /* Array to get each word and all related to it */
        ArrayList<String> keyValue = new ArrayList<String>();

        /* Instantiate an object of OutputManager to relate each key to the related words */
        for (int i=0; i < keyWordsArray.size(); i++) {
            RelatedWords relateWords = new RelatedWords(keyWordsArray.get(i), cleanOutPut[i]);
            keyValue.add(i, relateWords.getLine());
        }
        return keyValue;
    }

}
