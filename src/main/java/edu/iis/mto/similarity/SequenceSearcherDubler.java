package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher {

    public SearchResult search(int key, int[] seq) {
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == key) {
                return new SearchResultDubler(true, i);
            }
        }
        return new SearchResultDubler(false, -1);
    }

}
