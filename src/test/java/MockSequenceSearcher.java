import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MockSequenceSearcher implements SequenceSearcher {

    public SearchResult search(int i, int[] ints) {
        int pos = 0;
        for (int j : ints) {
            if (i == j) {
                return new MockSearchResult(true,pos);
            }
            pos++;
        }
        return new MockSearchResult(false, -1);
    }
}
