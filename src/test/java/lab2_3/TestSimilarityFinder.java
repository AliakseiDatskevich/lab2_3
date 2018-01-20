package lab2_3;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.iis.mto.similarity.SearchResultDubler;
import edu.iis.mto.similarity.SequenceSearcherDubler;
import edu.iis.mto.similarity.SimilarityFinder;

public class TestSimilarityFinder {

    @Test
    public void similarityTwoSameSequencesTest() {
        SequenceSearcherDubler searcherDubler = new SequenceSearcherDubler();
        searcherDubler.addSearchResultToList(new SearchResultDubler(true, 0));
        searcherDubler.addSearchResultToList(new SearchResultDubler(true, 1));
        searcherDubler.addSearchResultToList(new SearchResultDubler(true, 2));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] firstSequence = {10, 11, 2};
        int[] secondSequence = {10, 11, 2};
        double result = similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
        double expected = 1.0d;

        assertThat(result, Matchers.is(expected));
    }

    @Test
    public void similarityTwoEmptySequencesTest() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] firstSeqence = {};
        int[] secondSeqeuence = {};
        double result = similarityFinder.calculateJackardSimilarity(firstSeqence, secondSeqeuence);
        double expected = 1.0d;

        assertThat(result, Matchers.is(expected));
    }

    @Test
    public void similarityTwoDifferentSentencesTest() {
        SequenceSearcherDubler searcherDubler = new SequenceSearcherDubler();
        searcherDubler.addSearchResultToList(new SearchResultDubler(false));
        searcherDubler.addSearchResultToList(new SearchResultDubler(false));
        searcherDubler.addSearchResultToList(new SearchResultDubler(false));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] firstSeqence = {10, 11, 2};
        int[] secondSeqence = {10, 11, 12};
        double result = similarityFinder.calculateJackardSimilarity(firstSeqence, secondSeqence);
        double expected = 0.0d;

        assertThat(result, Matchers.is(expected));
    }

}
