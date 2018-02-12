package edu.iis.mto.similarity;

import java.util.ArrayList;
import java.util.List;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher {

    private int counter = 0;
    private List<Integer> keys = new ArrayList<Integer>();

    public int getCounter() {
        return counter;
    }

    public List<Integer> getKeys() {
        return keys;
    }

    public SearchResult search(int key, int[] seq) {
        counter++;
        keys.add(key);
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == key) {
                return new SearchResultDubler(true, i);
            }
        }
        return new SearchResultDubler(false, -1);
    }

}
