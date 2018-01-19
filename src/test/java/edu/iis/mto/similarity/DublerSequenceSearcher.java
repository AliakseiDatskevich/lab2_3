package edu.iis.mto.similarity;

import java.util.ArrayList;
import java.util.List;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class DublerSequenceSearcher implements SequenceSearcher {

    private static int counter;
    private boolean[] found;
    private List<Integer> keys;

    DublerSequenceSearcher(boolean... found) {
        counter = 0;
        this.found = found;
        keys = new ArrayList<Integer>();
    }

    public SearchResult search(int key, int[] seq) {
        keys.add(key);
        DublerSearchResult result = new DublerSearchResult(found[counter]);
        counter++;
        return result;
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
