package lab2_3;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.iis.mto.similarity.SearchResultDubler;
import edu.iis.mto.similarity.SequenceSearcherDubler;
import edu.iis.mto.similarity.SimilarityFinder;

public class TestSimilarityFinder {

    double result = 0;
    double expected = 0;

    @Test
    public void similarityTwoSameSequencesTest() {
        SequenceSearcherDubler sequenceSearcherDubler = new SequenceSearcherDubler();
        sequenceSearcherDubler.listProvider(new SearchResultDubler(true, 0), new SearchResultDubler(true, 1),
                new SearchResultDubler(true, 2));
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDubler);
        int[] firstSequence = {10, 11, 2};
        int[] secondSequence = {10, 11, 2};
        result = similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
        expected = 1.0d;

        assertThat(result, Matchers.is(expected));
    }

    @Test
    public void similarityTwoEmptySequencesTest() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] firstSeqence = {};
        int[] secondSeqeuence = {};
        result = similarityFinder.calculateJackardSimilarity(firstSeqence, secondSeqeuence);
        expected = 1.0d;

        assertThat(result, Matchers.is(expected));
    }

    @Test
    public void similarityTwoDifferentSentencesTest() {
        SequenceSearcherDubler sequenceSearcherDubler = new SequenceSearcherDubler();
        sequenceSearcherDubler.listProvider(new SearchResultDubler(false), new SearchResultDubler(false),
                new SearchResultDubler(false));
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDubler);
        int[] firstSeqence = {11, 2, 23};
        int[] secondSeqence = {10, 12, 12};
        result = similarityFinder.calculateJackardSimilarity(firstSeqence, secondSeqence);
        expected = 0.0d;

        assertThat(result, Matchers.is(expected));
    }

    @Test
    public void counterTest() {
        SequenceSearcherDubler sequenceSearcherDubler = new SequenceSearcherDubler();
        sequenceSearcherDubler.listProvider(new SearchResultDubler(true, 0), new SearchResultDubler(true, 1),
                new SearchResultDubler(false, 2), new SearchResultDubler(false, 3));

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDubler);
        int[] firstSeqence = {10, 78, 32, 44};
        int[] secondSeqence = {10, 78};
        similarityFinder.calculateJackardSimilarity(secondSeqence, firstSeqence);
        result = sequenceSearcherDubler.getCounter();
        expected = 2;

        assertThat(result, Matchers.is(expected));
    }

    @Test
    public void similarityTwoHalfSimilarSentencesTest() {
        SequenceSearcherDubler sequenceSearcherDubler = new SequenceSearcherDubler();
        sequenceSearcherDubler.listProvider(new SearchResultDubler(false), new SearchResultDubler(false),
                new SearchResultDubler(true), new SearchResultDubler(true));
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDubler);
        int[] firstSeqence = {0, 1, 11, 12};
        int[] secondSeqence = {11, 12};
        result = similarityFinder.calculateJackardSimilarity(firstSeqence, secondSeqence);
        expected = 0.5d;

        assertThat(result, Matchers.is(expected));
    }

}
