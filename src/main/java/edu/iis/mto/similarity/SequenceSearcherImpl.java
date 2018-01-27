package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukasz on 2018-01-21.
 */
public class SequenceSearcherImpl implements SequenceSearcher {

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    int counter = 0;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    List<Integer> keys = new ArrayList<Integer>();

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    List<SearchResult> searchResults = new ArrayList<SearchResult>();

    public SearchResult search(int key, int[] seq) {
        counter++;
        keys.add(key);
        return searchResults.get(counter - 1);
    }

}
