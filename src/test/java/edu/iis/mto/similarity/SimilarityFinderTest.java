package edu.iis.mto.similarity;

import dublers.SequenceSearcherDubler;
import edu.iis.mto.search.SequenceSearcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void calculateJackardSimilarityBothSeqSame(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 4};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 1.0d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityBothSeqDifferent(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {5, 7, 7, 10, 11};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 0.0d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityBothOneSeqEmpty(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] seq1 = {};
        int[] seq2 = {5, 7, 7, 10, 11};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 0.0d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityFirstSeqHalfOfSecondSeq(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] seq1 = {1, 2};
        int[] seq2 = {1, 2, 3, 4};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 0.5d;

        assertThat(result, is(expected));
    }

    @Test
    public void calculateJackardSimilarityKeyPassedAndCallCountCheck(){
        SequenceSearcherDubler sequenceSearcher = new SequenceSearcherDubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 3, 4};
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 0.75d;
        int callCount = sequenceSearcher.getCountCall();
        List callList = sequenceSearcher.getKeyList();
        int expectedCount = seq1.length;
        List expectedList = new ArrayList<Integer>();
        for (int i: seq1) {
            expectedList.add(i);
        }

        assertThat(result, is(expected));
        assertThat(callCount, is(expectedCount));
        assertThat(callList, is(expectedList));
    }

}
