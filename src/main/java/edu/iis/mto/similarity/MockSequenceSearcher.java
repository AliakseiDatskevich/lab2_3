package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;
import java.util.List;

public class MockSequenceSearcher implements SequenceSearcher {

    private Call callHierarchy ;
    private int callCounter = 0;
    List<Integer> keyList = new ArrayList<Integer>();
    List<SearchResult> returnResults = new ArrayList<SearchResult>();

    public SearchResult search(int i, int[] ints) {
        callHierarchy = new Call(i, ints);
        callCounter++;
        keyList.add(i);

        return returnResults.get(callCounter - 1);
    }

    public int getCallCounter() {
        return callCounter;
    }

    public int getParam() {
        return callHierarchy.param;
    }

    public int[] getSeq() {
        return callHierarchy.sequence;
    }

    public void addReturnResult(SearchResult searchResult) {
        returnResults.add(searchResult);
    }

    private class Call {

        int param = -1;
        int[] sequence;

        public Call(int param, int[] sequence) {
            this.param = param;
            this.sequence = sequence;
        }

    }
}

