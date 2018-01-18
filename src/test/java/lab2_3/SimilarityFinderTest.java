package lab2_3;

import static lab2_3.dubler.Dubler.dubler;
import static lab2_3.dubler.Dubler.verifyTimes;
import static lab2_3.dubler.Dubler.when;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {

	public static SearchResult DUB_RESULT_TRUE;

	public static SearchResult DUB_RESULT_FALSE;

	@Before
	public void setUp() {
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

	@Test
	public void testBothSeqEmptyJackardSimilarity() {
		int[] seq1 = new int[0];
		int[] seq2 = new int[0];

		SequenceSearcher searcherDub = dubler(SequenceSearcher.class);
		SimilarityFinder finder = new SimilarityFinder(searcherDub);

		assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(1d));
	}

	@Test
	public void testSingleSeqEmptyJackardSimilarity() {
		int[] seq1 = new int[] { 1, 2, 3 };
		int[] seq2 = new int[0];

		SequenceSearcher searcherDub = dubler(SequenceSearcher.class);
		SimilarityFinder finder = new SimilarityFinder(searcherDub);

		when(searcherDub.search(1, seq2)).thenReturn(DUB_RESULT_FALSE);
		when(searcherDub.search(2, seq2)).thenReturn(DUB_RESULT_FALSE);
		when(searcherDub.search(3, seq2)).thenReturn(DUB_RESULT_FALSE);

		assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(0d));
	}

	@Test
	public void testDublerFoundFalseTimesCalled() {
		int[] seq1 = new int[] { 1, 2, 3, 4 };
		int[] seq2 = new int[] { 5, 6, 7, 8, 9, 10 };

		SequenceSearcher searcherDub = dubler(SequenceSearcher.class);

		when(searcherDub.search(1, seq2)).thenReturn(DUB_RESULT_FALSE);
		when(searcherDub.search(2, seq2)).thenReturn(DUB_RESULT_FALSE);
		when(searcherDub.search(3, seq2)).thenReturn(DUB_RESULT_FALSE);
		when(searcherDub.search(4, seq2)).thenReturn(DUB_RESULT_FALSE);

		SimilarityFinder finder = new SimilarityFinder(searcherDub);
		finder.calculateJackardSimilarity(seq1, seq2);

		assertThat(verifyTimes(DUB_RESULT_FALSE.isFound(), 4), is(true));
	}

	@Test
	public void testDublerFoundTrueTimesCalled() {
		int[] seq1 = new int[] { 3, 4 };
		int[] seq2 = new int[] { 3, 4, 5, 6, 7, 8 };

		SequenceSearcher searcherDub = dubler(SequenceSearcher.class);

		when(searcherDub.search(3, seq2)).thenReturn(DUB_RESULT_TRUE);
		when(searcherDub.search(4, seq2)).thenReturn(DUB_RESULT_TRUE);

		SimilarityFinder finder = new SimilarityFinder(searcherDub);
		finder.calculateJackardSimilarity(seq1, seq2);

		assertThat(verifyTimes(DUB_RESULT_TRUE.isFound(), 2), is(true));
	}

	@Test
	public void testDublerSearchTimesCalled() {
		int[] seq1 = new int[] { 3, 4 };
		int[] seq2 = new int[] { 3, 4, 5, 6, 7, 8 };

		SequenceSearcher searcherDub = dubler(SequenceSearcher.class);

		when(searcherDub.search(3, seq2)).thenReturn(DUB_RESULT_TRUE);
		when(searcherDub.search(4, seq2)).thenReturn(DUB_RESULT_TRUE);

		SimilarityFinder finder = new SimilarityFinder(searcherDub);
		finder.calculateJackardSimilarity(seq1, seq2);

		assertThat(verifyTimes(searcherDub.search(3, seq2), 1), is(true));
		assertThat(verifyTimes(searcherDub.search(4, seq2), 1), is(true));
	}

	@Test
	public void testDublerSearchNotCalled() {
		int[] seq1 = new int[] { 3, 4 };
		int[] seq2 = new int[] { 3, 4, 5, 6, 7, 8 };

		SequenceSearcher searcherDub = dubler(SequenceSearcher.class);

		when(searcherDub.search(3, seq2)).thenReturn(DUB_RESULT_TRUE);
		when(searcherDub.search(4, seq2)).thenReturn(DUB_RESULT_TRUE);

		SimilarityFinder finder = new SimilarityFinder(searcherDub);
		finder.calculateJackardSimilarity(seq1, seq2);
		
		assertThat(verifyTimes(searcherDub.search(1, seq2), 0), is(true));
		assertThat(verifyTimes(searcherDub.search(2, seq2), 0), is(true));
		assertThat(verifyTimes(searcherDub.search(5, seq2), 0), is(true));
	}
}
