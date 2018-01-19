package dublers;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceSearcherDubler implements SequenceSearcher {

    int countCall = 0;
    List<Integer> keyList = new ArrayList<Integer>();
    public SearchResult search(int key, int[] seq) {
        countCall++;
        keyList.add(key);
        boolean found = false;
        int position = -1;
        for (int s : seq) {
            if (key == s) {
                found = true;
                position = new ArrayList<int[]>(Arrays.asList(seq)).indexOf(s);
                break;
            }
        }
        return new SearchResultDubler(found, position);
    }

    public int getCountCall() {
        return countCall;
    }

    public List getKeyList() {
        return keyList;
    }
}
