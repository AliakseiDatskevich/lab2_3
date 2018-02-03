package edu.iis.mto.similarity.test;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.iis.mto.similarity.SequenceSearcherDubler;
import edu.iis.mto.similarity.SimilarityFinder;

public class Tests {

    @Test
    public void similarityBothSequenceEmpty() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] seq1 = {};
        int[] seq2 = {};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(result, Matchers.is(1.0));
    }

    @Test
    public void similarityBothSequenceEqual() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] seq1 = {1, 2, 3, 4, 5};
        int[] seq2 = {1, 2, 3, 4, 5};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(result, Matchers.is(1.0));
    }

    @Test
    public void similarityBothSequenceDifferent() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());
        int[] seq1 = {1, 2, 3, 4, 5};
        int[] seq2 = {6, 7, 8, 9, 10};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertThat(result, Matchers.is(0.0));
    }
}
