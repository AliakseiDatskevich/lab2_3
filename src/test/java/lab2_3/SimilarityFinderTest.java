package lab2_3;

import static lab2_3.dubler.Dubler.when;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

import static lab2_3.dubler.Dubler.*;

public class SimilarityFinderTest {

	public static SearchResult DUB_RESULT_TRUE;

	public static SearchResult DUB_RESULT_FALSE;

	@BeforeClass
	public static void setUp() {
		DUB_RESULT_TRUE = dubler(SearchResult.class);
		when(DUB_RESULT_TRUE.isFound()).thenReturn(true);

		DUB_RESULT_FALSE = dubler(SearchResult.class);
		when(DUB_RESULT_FALSE.isFound()).thenReturn(false);
	}

	@Test
	public void testJackardSimilarityTwoFound() throws Exception {
		int[] seq1 = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] seq2 = new int[] { 5, 6, 7, 8, 9, 10 };

		SequenceSearcher searcherDub = dubler(SequenceSearcher.class);

		when(searcherDub.search(1, seq2)).thenReturn(DUB_RESULT_FALSE);
		when(searcherDub.search(2, seq2)).thenReturn(DUB_RESULT_FALSE);
		when(searcherDub.search(3, seq2)).thenReturn(DUB_RESULT_FALSE);
		when(searcherDub.search(4, seq2)).thenReturn(DUB_RESULT_FALSE);
		when(searcherDub.search(5, seq2)).thenReturn(DUB_RESULT_TRUE);
		when(searcherDub.search(6, seq2)).thenReturn(DUB_RESULT_TRUE);

		SimilarityFinder finder = new SimilarityFinder(searcherDub);
		assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(0.2d));
	}
}
