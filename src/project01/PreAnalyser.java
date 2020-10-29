package project01;

import java.io.IOException;

public class PreAnalyser {
    private final String pathFile;

    public PreAnalyser(String pathFile) {
        this.pathFile = pathFile;
	}

	protected void classManager() throws IOException {
        //getFileName();
        String conteudo = TextManipulator.getContentFile(this.pathFile);
        
        //TextManipulator.readFile(fileName); 
        //TextManipulator.removeAccent();
    }

    public String getPathFile() {
        return this.pathFile;
    }
   
}
