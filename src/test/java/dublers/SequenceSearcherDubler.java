package dublers;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;
import java.util.List;

public class SequenceSearcherDubler implements SequenceSearcher {

    int countCall = 0;
    List<Integer> keyList = new ArrayList<Integer>();
    List<SearchResult> returnResults = new ArrayList<SearchResult>();

    public SearchResult search(int key, int[] seq) {
        countCall++;
        keyList.add(key);

        return returnResults.get(countCall - 1);
    }

    public int getCountCall() {
        return countCall;
    }

    public List getKeyList() {
        return keyList;
    }

    public void setReturnResults(List<SearchResult> returnResults) {
        this.returnResults = returnResults;
    }

    public void addReturnResult(SearchResult searchResult) {
        returnResults.add(searchResult);
    }
}
