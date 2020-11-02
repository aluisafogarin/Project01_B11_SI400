package project01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputManager {
    private final String outPutFileName;

    public OutputManager(String fileName) {
        this.outPutFileName = fileName.substring(0, fileName.length() - 4) + ".csv";
    }

    protected void recordOutputFile(ArrayList<String> data) throws IOException {
    
    }

    public String outPutFileName() {
        return this.outPutFileName;
    }
}
