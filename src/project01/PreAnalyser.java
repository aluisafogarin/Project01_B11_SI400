package Project01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Controls execution of the program.
 * 
 */
public class PreAnalyser {
    private final String pathFile;
    private final String fileName;

    /**
     * Gets the path to file.
     * 
     * @param fileName File name inserted by the user.
     */
    public PreAnalyser(String fileName) {
        this.fileName = fileName;
        this.pathFile = System.getProperty("user.dir") + File.separator + this.fileName;
    }

    /**
     * Makes all requisitions to other classes of the program.
     * 
     * @return To control success of recording the output file.
     * @throws IOException In case it can't read the input file.
     */
    public boolean classManager() throws IOException {

        String rawText = TextManipulator.getContentFile(this.pathFile);
        String lowerText = TextManipulator.lowerCase(rawText);
        ArrayList<String> preProcessedText = TextManipulator.removeCharacters(lowerText);
        ArrayList<String> keyValues = TextManipulator.textProcess(preProcessedText);

        if (OutputManager.recordOutputFile(keyValues, pathFile))
            ;
        {
            return true;
        }
    }

    /**
     * Gets path file.
     * 
     * @return Path to file.
     */
    public String getPathFile() {
        return pathFile;
    }

    /**
     * Gets file name.
     * 
     * @return Name of the input file.
     */
    public String getFileName() {
        return fileName;
    }
}
