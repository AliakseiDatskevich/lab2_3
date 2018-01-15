package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDubler implements SequenceSearcher {

	public SearchResult search(int key, int[] seq) {

		boolean found = false;
		int position = -1;

		for (int i : seq) {
			if (i == key) {
				found = true;
				position = i;
				break;
			}
		}
		return new SearchResultDubler(found, position);
	}
}
