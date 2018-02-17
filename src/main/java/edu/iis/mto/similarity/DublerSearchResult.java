package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class DublerSearchResult implements SearchResult {

    private boolean found;

    private int position;

    public DublerSearchResult(boolean found, int position) {
        this.found = found;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public boolean isFound() {
        return found;
    }
}
