package edu.iis.mto.similarity;

import dublers.SequenceSearcherDubler;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {

    @Test
    public void calculateJackardSimilarityBothSeqAreEmpty() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] seq1 = {};
        int[] seq2 = {};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 1.0d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityBothSeqSame() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 4};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 1.0d;

        assertThat(result, is(expected));
    }

}
