package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MockSequenceSearcher implements SequenceSearcher {

    private Call callHierarchy;
    private int callCounter = 0;

    public SearchResult search(int i, int[] ints) {
        SearchContainer searchContainer = new SearchContainer();

        searchContainer.key = i;
        searchContainer.seq = ints;
        searchContainer.result = calcResult(i, ints);

        return searchContainer.result;
    }

    public int getCallCounter() {
        return callCounter;
    }

    public int getParam() {
        return callHierarchy.param;
    }

    public static class SearchContainer {

        public int key;
        public int[] seq;
        public MockSearchResult result;
    }

    public int[] getSeq() {
        return callHierarchy.sequence;
    }

    private class Call {

        int param = -1;
        int[] sequence;

        public Call(int param, int[] sequence) {
            this.param = param;
            this.sequence = sequence;
        }

    }

    private MockSearchResult calcResult(int i, int[] ints) {
        int pos = 0;
        callHierarchy = new Call(i, ints);
        callCounter++;
        for (int j : ints) {
            if (i == j) {
                return new MockSearchResult(true, pos);
            }
            pos++;
        }
        return new MockSearchResult(false, -1);
    }
}
