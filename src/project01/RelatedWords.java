package project01;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RelatedWords {
    private String key;
    private String pairWords;

    // Constructor
    public RelatedWords(String key, String cleanOutPut) {
        this.key = key;
        this.pairWords = cleanOutPut.replaceAll(" ", ",");
    }

    public String orderPairWords(String cleanOutPut) {
        List<String> myList = new ArrayList<String>(Arrays.asList(this.pairWords.split(",")));
        Collections.sort(myList, Collator.getInstance());
        return myList.toString();
        //System.out.println(myList);
    }

    public String getKeys() {
        return this.key;
    }

    public String getPairWords() {
        return this.pairWords;
    }

    public String getLine() {
        orderPairWords(this.pairWords);
        return this.key + "," + this.pairWords;
    }
}
