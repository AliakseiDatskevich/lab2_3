package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class MockSearchResult implements SearchResult {

    private boolean isFound;
    private int position = -1;

    public MockSearchResult(boolean isFound, int position) {
        this.isFound = isFound;
        this.position = position;
    }

    public boolean isFound() {
        return isFound;
    }

    public int getPosition() {
        return position;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
