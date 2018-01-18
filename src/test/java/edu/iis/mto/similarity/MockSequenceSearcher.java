package edu.iis.mto.similarity;

import java.util.ArrayList;
import java.util.List;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MockSequenceSearcher implements SequenceSearcher {

    private int counter = 0;
    private List<Integer> keys = new ArrayList<Integer>();

    public SearchResult search(int key, int[] seq) {
        keys.add(key);
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

    public int[] getKeys() {
        int[] array = new int[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            array[i] = keys.get(i);
        }
        return array;
    }
}
