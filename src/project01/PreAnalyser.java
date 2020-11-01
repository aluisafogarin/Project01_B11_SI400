package project01;

import java.io.IOException;

public class PreAnalyser {
    private final String pathFile;

    public PreAnalyser(String pathFile) {
        System.out.println("PATH" + pathFile);
        this.pathFile = pathFile;
	}

	protected void classManager() throws IOException {
        //getFileName();
        String rawText = TextManipulator.getContentFile(this.pathFile);
        String lowerText = TextManipulator.lowerCase(rawText);
        String preProcessedText = TextManipulator.removeCharacters(lowerText);
    }

    public void teste() {
        char[] caracteres = {'á','à','â','ã','é','è','ê','ó','ò','ô','õ','í','ì','î','ú','ù','û'};
        
        for (char c : caracteres) {
            System.out.println(c + ":" + (int) c);
        }
        
    }
    public String getPathFile() {
        return this.pathFile;
    }
   
}
