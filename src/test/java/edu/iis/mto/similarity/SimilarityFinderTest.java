package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2018-01-21.
 */
public class SimilarityFinderTest {

    @Test
    public void sameSequenceReturnOneInJaccardaIndex() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSeracherImpl());
        int[] seq1 = {7, 17, 27, 37};
        int[] seq2 = {7, 17, 27, 37};
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(1.0));
    }



}