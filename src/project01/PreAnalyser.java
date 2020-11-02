package project01;

import java.io.IOException;
import java.util.ArrayList;
public class PreAnalyser {
    private final String pathFile;

    public PreAnalyser(String pathFile) {
        System.out.println("PATH" + pathFile);
        this.pathFile = pathFile;
    }

    protected void classManager() throws IOException {

        String rawText = TextManipulator.getContentFile(this.pathFile);
        String lowerText = TextManipulator.lowerCase(rawText);
        ArrayList<String> preProcessedText = TextManipulator.removeCharacters(lowerText);

        ArrayList<String> keyValue = TextManipulator.textProcess(preProcessedText);
        
    }

    public String getPathFile() {
        return this.pathFile;
    }
   
        /* public void teste() {
        char[] caracteres = {'á','à','â','ã','é','è','ê','ó','ò','ô','õ','í','ì','î','ú','ù','û'};
        
        for (char c : caracteres) {
            System.out.println(c + ":" + (int) c);
        }
        
    } */
}
