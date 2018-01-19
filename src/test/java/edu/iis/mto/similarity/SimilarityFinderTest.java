package edu.iis.mto.similarity;

import dublers.SearchResultDubler;
import dublers.SequenceSearcherDubler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {

    @Test
    public void calculateJackardSimilarityBothSeqAreEmpty() {
        SequenceSearcherDubler searcherDubler = new SequenceSearcherDubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq1 = {};
        int[] seq2 = {};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 1.0d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityBothSeqSame() {
        SequenceSearcherDubler searcherDubler = new SequenceSearcherDubler();
        searcherDubler.addReturnResult(new SearchResultDubler(true, 0));
        searcherDubler.addReturnResult(new SearchResultDubler(true, 1));
        searcherDubler.addReturnResult(new SearchResultDubler(true, 2));
        searcherDubler.addReturnResult(new SearchResultDubler(true, 3));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 4};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 1.0d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityBothSeqDifferent() {
        SequenceSearcherDubler searcherDubler = new SequenceSearcherDubler();
        searcherDubler.addReturnResult(new SearchResultDubler(false));
        searcherDubler.addReturnResult(new SearchResultDubler(false));
        searcherDubler.addReturnResult(new SearchResultDubler(false));
        searcherDubler.addReturnResult(new SearchResultDubler(false));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {5, 7, 7, 10, 11};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 0.0d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityBothOneSeqEmpty() {
        SequenceSearcherDubler searcherDubler = new SequenceSearcherDubler();

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq1 = {};
        int[] seq2 = {5, 7, 7, 10, 11};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 0.0d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityFirstSeqHalfOfSecondSeq() {
        SequenceSearcherDubler searcherDubler = new SequenceSearcherDubler();
        searcherDubler.addReturnResult(new SearchResultDubler(true, 0));
        searcherDubler.addReturnResult(new SearchResultDubler(true, 1));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq1 = {1, 2};
        int[] seq2 = {1, 2, 3, 4};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 0.5d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityKeyPassed() {
        SequenceSearcherDubler searcherDubler = new SequenceSearcherDubler();
        searcherDubler.addReturnResult(new SearchResultDubler(true, 0));
        searcherDubler.addReturnResult(new SearchResultDubler(true, 1));
        searcherDubler.addReturnResult(new SearchResultDubler(true, 2));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 3, 4};
        similarityFinder.calculateJackardSimilarity(seq1, seq2);
        List callList = searcherDubler.getKeyList();
        List expectedList = new ArrayList<Integer>();
        for (int i : seq1) {
            expectedList.add(i);
        }
        assertThat(callList, is(expectedList));
    }

    @Test
    public void calculateJackardSimilarityCallCountCheck() {
        SequenceSearcherDubler searcherDubler = new SequenceSearcherDubler();
        searcherDubler.addReturnResult(new SearchResultDubler(true, 0));
        searcherDubler.addReturnResult(new SearchResultDubler(true, 1));
        searcherDubler.addReturnResult(new SearchResultDubler(true, 2));

        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 3, 4};
        similarityFinder.calculateJackardSimilarity(seq1, seq2);
        int callCount = searcherDubler.getCountCall();
        int expectedCount = 3;

        assertThat(callCount, is(expectedCount));
    }

}
