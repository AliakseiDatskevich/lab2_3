package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class DublerSequenceResult implements SequenceSearcher {

	public SearchResult search(int key, int[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] == key) {
				return new DublerSearchResult(true, i);
			}
		}
		return new DublerSearchResult(false, -1);
	}
}
