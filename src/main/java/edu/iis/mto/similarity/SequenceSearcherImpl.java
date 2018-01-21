package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Lukasz on 2018-01-21.
 */
public class SequenceSearcherImpl implements SequenceSearcher{

    public SearchResult search(int key, int[] seq) {
        for (int k = 0; k < seq.length; k++) {
            if (seq[k] == key) {
                return new SearchResultImpl(true, k);
            }
        }
        return new SearchResultImpl(false, -1);
    }
}
