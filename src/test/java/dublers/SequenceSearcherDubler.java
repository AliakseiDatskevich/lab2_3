package dublers;

import java.util.Stack;
import java.util.Vector;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher {

    public static int methodCallCounter = 0;
    public static Vector<Integer> receivedElementVector = new Vector<Integer>();
    public static Stack<Boolean> searchResults = new Stack<Boolean>();

    public SearchResult search(int elem, int[] seq) {

        methodCallCounter++;
        receivedElementVector.addElement(elem);

        return new SearchResultDubler(searchResults.pop());
    }
}
