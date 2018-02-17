package edu.iis.mto.similarity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.iis.mto.search.SearchResult;

public class DublerSequenceResult {

    public List<SearchCall> searchCallHistory = new ArrayList<SearchCall>();

    public static class SearchCall {

        public int key;
        public int[] seq;
        public DublerSearchResult result;
    }

    public SearchResult search(int key, int[] seq) {
        SearchCall call = new SearchCall();
        call.key = key;
        call.seq = Arrays.copyOf(seq, seq.length);
        call.result = normalSearch(key, seq);
        searchCallHistory.add(call);
        return call.result;
    }

    private DublerSearchResult normalSearch(int key, int[] seq) {
        boolean f = false;
        int p = -1;
        for (int i = 0; i < seq.length; ++i) {
            if (key == seq[i]) {
                f = true;
                p = i;
            }
        }
        return new DublerSearchResult(f, p);
    }
}
