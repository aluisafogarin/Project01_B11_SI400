package Project01;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class to manage the word and every word immediately after it.
 * 
 */
public class RelatedWords {
    private String key;
    private String pairWords;

    /**
     * Class contructor.
     * 
     * @param key         Keyword.
     * @param cleanOutPut Words related to the key.
     */
    public RelatedWords(String key, String cleanOutPut) {
        this.key = key;
        this.pairWords = cleanOutPut.replaceAll(" ", ", ");
    }

    /**
     * Order the words.
     * 
     * @param cleanOutPut Words related to the key.
     * @return Words ordered.
     */
    public String orderPairWords(String cleanOutPut) {
        List<String> myList = new ArrayList<String>(Arrays.asList(this.pairWords.split(",")));
        Collections.sort(myList, Collator.getInstance());
        return myList.toString();
    }

    /**
     * Get key word.
     * 
     * @return Key word.
     */
    public String getKeys() {
        return this.key;
    }

    /**
     * Get related words.
     * 
     * @return Related words.
     */
    public String getPairWords() {
        return this.pairWords;
    }

    /**
     * Get both key and related words as one element.
     * 
     * @return Key and related words.
     */
    public String getLine() {
        orderPairWords(this.pairWords);
        return this.key + ", " + this.pairWords;
    }
}
