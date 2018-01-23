import edu.iis.mto.similarity.MockSearchResult;
import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.collection.IsIn.isOneOf;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {

    @Test public void testCalculateJackardSimilarityAnotherSizeSeq() throws Exception {
        MockSequenceSearcher searcherDubler = new MockSequenceSearcher();
        searcherDubler.addReturnResult(new MockSearchResult(true, 1));
        searcherDubler.addReturnResult(new MockSearchResult(true, 2));
        searcherDubler.addReturnResult(new MockSearchResult(true, 3));
        searcherDubler.addReturnResult(new MockSearchResult(false));
        searcherDubler.addReturnResult(new MockSearchResult(false));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq1 = new int[] {1, 2, 3, 4, 5};
        int[] seq2 = new int[] {1, 2, 3};
        double expected = (double) 3 / 5;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(result, is(expected));
    }

    @Test public void testCalculateJackardEmptySeq() throws Exception {
        SimilarityFinder similarityFinder = new SimilarityFinder(new MockSequenceSearcher());
        int[] seq1 = new int[] {};
        int[] seq2 = new int[] {};
        double expected = (double) 1;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(result, is(expected));
    }

    @Test public void testCalculateJackardTheSameSeqLenAnotherContents() {
        MockSequenceSearcher searcherDubler = new MockSequenceSearcher();
        searcherDubler.addReturnResult(new MockSearchResult(true, 0));
        searcherDubler.addReturnResult(new MockSearchResult(true, 1));
        searcherDubler.addReturnResult(new MockSearchResult(false));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq = new int[] {1, 2, 3};
        int[] seq1 = new int[] {1, 2, 5};

        double expected = (double) 2 / 4;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq);

        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateJackalThisSameSequence() {
        MockSequenceSearcher searcherDubler = new MockSequenceSearcher();
        searcherDubler.addReturnResult(new MockSearchResult(true, 0));
        searcherDubler.addReturnResult(new MockSearchResult(true, 1));
        searcherDubler.addReturnResult(new MockSearchResult(true, 2));
        searcherDubler.addReturnResult(new MockSearchResult(true, 3));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 4};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 1.0d;

        assertThat(result, CoreMatchers.is(expected));
    }

    @Test public void testCalculateJackardSearchCallNumber() {
        MockSequenceSearcher searcherDubler = new MockSequenceSearcher();
        searcherDubler.addReturnResult(new MockSearchResult(true, 0));
        searcherDubler.addReturnResult(new MockSearchResult(true, 1));
        searcherDubler.addReturnResult(new MockSearchResult(true, 2));
        searcherDubler.addReturnResult(new MockSearchResult(true, 3));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq = new int[] {1, 2, 3};
        int[] seq1 = new int[] {1, 2, 5, 4};

        int expected = 4;

        similarityFinder.calculateJackardSimilarity(seq1, seq);

        assertThat(searcherDubler.getCallCounter(), is(expected));

    }

    @Test public void testCalculateJackardSearchParmCheck() {
        MockSequenceSearcher searcherDubler = new MockSequenceSearcher();
        searcherDubler.addReturnResult(new MockSearchResult(true, 0));
        searcherDubler.addReturnResult(new MockSearchResult(true, 1));
        searcherDubler.addReturnResult(new MockSearchResult(true, 2));
        searcherDubler.addReturnResult(new MockSearchResult(true, 3));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq = new int[] {1, 2, 3};
        int[] seq1 = new int[] {1, 2, 5, 4};

        similarityFinder.calculateJackardSimilarity(seq1, seq);

        assertThat(searcherDubler.getParam(), isIn(getListWithSeq(seq1)));
        assertThat(searcherDubler.getSeq(), isOneOf(seq1, seq));
    }

    private List<Integer> getListWithSeq(int[] seq) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : seq) {
            list.add(i);

        }
        return list;
    }
}
