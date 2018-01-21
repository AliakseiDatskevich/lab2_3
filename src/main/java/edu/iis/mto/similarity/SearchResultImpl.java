package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

/**
 * Created by Lukasz on 2018-01-21.
 */

public class SearchResultImpl implements SearchResult {

    private boolean found;
    private int position;

    SearchResultImpl(boolean found, int position) {
        this.found = found;
        this.position = position;
    }

    public boolean isFound() {
        return found;
    }

    public int getPosition() {
        return position;
    }
}
