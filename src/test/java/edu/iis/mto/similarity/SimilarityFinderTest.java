package edu.iis.mto.similarity;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Justyna on 25.01.2018.
 */
public class SimilarityFinderTest {

    @Test
    public void areEmptySequencesEqual() throws Exception {
        int[] seq1 = {};
        int[] seq2 = {};

        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertEquals(BigDecimal.valueOf(result), BigDecimal.valueOf(1.0d));
    }
}