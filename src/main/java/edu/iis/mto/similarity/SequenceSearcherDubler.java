package edu.iis.mto.similarity;

import java.util.ArrayList;
import java.util.List;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher {

	private boolean[] found;
	private static int count;
	private List<Integer> keys;

	SequenceSearcherDubler(boolean... found) {
		this.found = found;
		count = 0;
		keys = new ArrayList<Integer>();
	}

	public SearchResult search(int key, int[] seq) {
		keys.add(key);
		count++;
		return new SearchResultDubler(found[count - 1]);
	}

	public static int getCount() {
		return count;
	}
}
