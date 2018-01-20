package dublers;

import edu.iis.mto.search.SearchResult;

public class SearchResultDubler implements SearchResult {

    private boolean found;
    private int position = -1;

    public SearchResultDubler(boolean found, int position) {
        this.found = found;
        this.position = position;
    }

    public SearchResultDubler(boolean found) {
        this.found = found;
    }

    public boolean isFound() {
        return found;
    }

    public int getPosition() {
        return position;
    }
}
