package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Justyna on 25.01.2018.
 */
public class SequenceSearcherDubler implements SequenceSearcher{

    private boolean[] results;
    private int counter = 0;

    public SequenceSearcherDubler(boolean... results) {
        this.results = results;
    }

    public SearchResult search(int i, int[] ints) {
        boolean result = results[counter++];
        return new SearchResultDubler(result);
    }

    public int getCounter() {
        return counter;
    }
}
