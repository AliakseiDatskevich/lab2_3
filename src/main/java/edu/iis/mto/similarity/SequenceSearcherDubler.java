package edu.iis.mto.similarity;

import java.util.ArrayList;
import java.util.List;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher {

    private int counter = 0;
    private List<SearchResult> resultList = new ArrayList<SearchResult>();
    private List<Integer> keyList = new ArrayList<Integer>();

    public SearchResult search(int key, int[] seq) {
        keyList.add(key);
        SearchResult result = resultList.get(counter);
        counter++;
        return result;
    }

    public int getCounter() {
        return counter;
    }

    public void setSearchResultList(List<SearchResult> resultList) {
        this.resultList = resultList;
    }

    public void addSearchResultToList(SearchResult searchResult) {
        resultList.add(searchResult);
    }

    public List<Integer> getKeyList() {
        return keyList;
    }
}
