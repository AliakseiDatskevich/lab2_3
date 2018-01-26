package dublers;

import edu.iis.mto.search.SearchResult;

public class SearchResultDubler implements SearchResult {

    private boolean found;
    private int position;

    public SearchResultDubler(boolean foundStatus) {
        found = foundStatus;
        position = -1;
    }

    public boolean isFound() {
        return found;
    }

    public int getPosition() {
        return position;
    }
}
