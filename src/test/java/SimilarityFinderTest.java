import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

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
}
