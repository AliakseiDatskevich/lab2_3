package dublers;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher {

    public SearchResult search(int elem, int[] seq) {

        boolean foundStatus = false;
        int elemPosition = -1;

        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == elem) {
                foundStatus = true;
                elemPosition = i;
                break;
            }
        }
        return new SearchResultDubler(foundStatus, elemPosition);
    }
}
