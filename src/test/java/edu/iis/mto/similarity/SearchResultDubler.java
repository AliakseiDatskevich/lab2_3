package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

/**
 * Created by Justyna on 25.01.2018.
 */
public class SearchResultDubler implements SearchResult {

    private boolean elementFound;

    public SearchResultDubler(boolean elementFound) {
        this.elementFound = elementFound;
    }

    public boolean isFound() {
        return elementFound;
    }

    public int getPosition() {
        return 0;
    }
}
