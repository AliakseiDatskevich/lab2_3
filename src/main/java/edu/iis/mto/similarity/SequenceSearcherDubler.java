package edu.iis.mto.similarity;

import java.util.ArrayList;
import java.util.Arrays;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher {

    public SearchResult search(int key, int[] seq) {
        boolean found = false;
        int position = -1;
        for (int s : seq) {
            if (key == s) {
                found = true;
                position = new ArrayList<int[]>(Arrays.asList(seq)).indexOf(s);
                break;
            }
        }
        System.out.println(found);
        return new SearchResultDubler(found, position);
    }
}
