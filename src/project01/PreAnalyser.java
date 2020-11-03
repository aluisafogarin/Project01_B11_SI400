package project01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class PreAnalyser {
    private final String pathFile;
    private final String fileName;

    public PreAnalyser( String fileName) {
        this.fileName = fileName;
        this.pathFile = System.getProperty("user.dir") + File.separator + this.fileName;
    }

    protected boolean classManager() throws IOException {

        String rawText = TextManipulator.getContentFile(this.pathFile);
        String lowerText = TextManipulator.lowerCase(rawText);
        ArrayList<String> preProcessedText = TextManipulator.removeCharacters(lowerText);
        ArrayList<String> keyValues = TextManipulator.textProcess(preProcessedText);

        if (OutputManager.recordOutputFile(keyValues, pathFile)); {
            return true;
        }
    }

    public String getPathFile() {
        return pathFile;
    }
    
    public String getFileName() {
        return fileName;
    }
}
