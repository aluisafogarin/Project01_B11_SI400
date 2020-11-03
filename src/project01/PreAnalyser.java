package project01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class PreAnalyser {
    private final String pathFile;
    private final String fileName;

    public PreAnalyser( String fileName) {
        //System.out.println("PATH" + pathFile);
        this.fileName = fileName;
        this.pathFile = System.getProperty("user.dir") + File.separator + this.fileName;
    }

    protected void classManager() throws IOException {

        String rawText = TextManipulator.getContentFile(this.pathFile);
        String lowerText = TextManipulator.lowerCase(rawText);
        ArrayList<String> preProcessedText = TextManipulator.removeCharacters(lowerText);

        ArrayList<String> keyValues = TextManipulator.textProcess(preProcessedText);

        OutputManager.recordOutputFile(keyValues, pathFile);
        //System.out.println(outPut.getOut());
        //OutputManager.recordOutputFile(keyValues, this.fileName);
        
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
