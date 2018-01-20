package lab2_3;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.iis.mto.similarity.SequenceSearcherDubler;
import edu.iis.mto.similarity.SimilarityFinder;

public class TestSimilarityFinder {

    @Test
    public void similarityTwoSameSequencesTest() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] firstSeqence = {10, 11, 2};
        int[] secondSeqeuence = {10, 11, 2};
        double result = similarityFinder.calculateJackardSimilarity(firstSeqence, secondSeqeuence);
        double expected = 1.0d;

        assertThat(result, Matchers.is(expected));
    }
}
