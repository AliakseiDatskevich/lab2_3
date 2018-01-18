package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MockSequenceSearcher implements SequenceSearcher {

    private int counter = 0;

    public SearchResult search(int key, int[] seq) {
        counter++;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == key) {
                return new MockSearchResult(true, i);
            }
        }
        return new MockSearchResult(false, -1);
    }

    public int getCounter() {
        return counter;
    }
}
