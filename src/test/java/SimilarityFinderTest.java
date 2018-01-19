import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.collection.IsIn.isOneOf;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

    SimilarityFinder similarityFinder;
    private MockSequenceSearcher dummySequenceSearcher;

    @Before
    public void setUp() {
        dummySequenceSearcher = createDummySequenceSearcher();
        similarityFinder = new SimilarityFinder(dummySequenceSearcher);
    }

    private MockSequenceSearcher createDummySequenceSearcher() {
        return new MockSequenceSearcher();
    }

    @Test
    public void testCalculateJackardSimilarityAnotherSizeSeq() throws Exception {
        SimilarityFinder similarityFinder = new SimilarityFinder(new MockSequenceSearcher());
        int[] seq1 = new int[] {1,2,3,4,5};
        int[] seq2 = new int[] {1,2,3};
        double expected = (double) 3/5;

        double result = similarityFinder.calculateJackardSimilarity(seq1,seq2);

        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateJackardEmptySeq() throws Exception {
        SimilarityFinder similarityFinder = new SimilarityFinder(new MockSequenceSearcher());
        int[] seq1 = new int[] {};
        int[] seq2 = new int[] {};
        double expected = (double) 1;

        double result = similarityFinder.calculateJackardSimilarity(seq1,seq2);

        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateJackardTheSameSeqLenAnotherContents() {
        int[] seq = new int[]{1, 2, 3};
        int[] seq1 = new int[]{1, 2, 5};

        double expected = (double) 2 / 4;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq);

        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateJackardSearchCallNumber() {
        int[] seq = new int[]{1, 2, 3};
        int[] seq1 = new int[]{1, 2, 5, 4};

        int expected = 4;

        similarityFinder.calculateJackardSimilarity(seq1, seq);

        assertThat(dummySequenceSearcher.getCallCounter(), is(expected));

    }

    @Test
    public void testCalculateJackardSearchParmCheck() {
        int[] seq = new int[]{1, 2, 3};
        int[] seq1 = new int[]{1, 2, 5, 4};

        int expected = 4;

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq);

        assertThat(dummySequenceSearcher.getParam(), isIn(getListWithSeq(seq1)));
        assertThat(dummySequenceSearcher.getSeq(), isOneOf(seq1, seq));
    }

    private List<Integer> getListWithSeq(int[] seq) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i:seq
                ) {
            list.add(i);

        }
        return list;
    }
}
