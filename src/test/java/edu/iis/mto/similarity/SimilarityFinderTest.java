package edu.iis.mto.similarity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SimilarityFinderTest {

    @Test
    public void testTheSameValues() {
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = {1, 2, 3, 4};
        DublerSequenceSearcher searcher = new DublerSequenceSearcher(true, true, true, true);
        SimilarityFinder finder = new SimilarityFinder(searcher);
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(1.0));
    }

    @Test
    public void testDifferentValues() {
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = {5, 6, 7, 8};
        DublerSequenceSearcher searcher = new DublerSequenceSearcher(false, false, false, false);
        SimilarityFinder finder = new SimilarityFinder(searcher);
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(0.0));
    }

    @Test
    public void testEmptyArrays() {
        int[] tab1 = {};
        int[] tab2 = {};
        DublerSequenceSearcher searcher = new DublerSequenceSearcher();
        SimilarityFinder finder = new SimilarityFinder(searcher);
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(1.0));
    }

    @Test
    public void testFirstEmptyArray() {
        int[] tab1 = {};
        int[] tab2 = {1, 2, 3, 4};
        DublerSequenceSearcher searcher = new DublerSequenceSearcher();
        SimilarityFinder finder = new SimilarityFinder(searcher);
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(0.0));
    }

    @Test
    public void testSecondEmptyArray() {
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = {};
        DublerSequenceSearcher searcher = new DublerSequenceSearcher(false, false, false, false);
        SimilarityFinder finder = new SimilarityFinder(searcher);
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(0.0));
    }

    @Test
    public void testHalfOfGoodValues() {
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = {1, 4};
        DublerSequenceSearcher searcher = new DublerSequenceSearcher(true, false, false, true);
        SimilarityFinder finder = new SimilarityFinder(searcher);
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(0.5));
    }

    @Test(expected = NullPointerException.class)
    public void testNullValues() {
        DublerSequenceSearcher searcher = new DublerSequenceSearcher();
        SimilarityFinder finder = new SimilarityFinder(searcher);
        finder.calculateJackardSimilarity(null, null);
    }

    @Test
    public void testLoopCounterSequenceSearcher() {
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = {1, 4};
        DublerSequenceSearcher searcher = new DublerSequenceSearcher(true, false, false, true);
        SimilarityFinder finder = new SimilarityFinder(searcher);
        finder.calculateJackardSimilarity(tab1, tab2);
        assertThat(searcher.getCounter(), is(tab1.length));
    }

    @Test
    public void testLoopKeysSequenceSearcher() {
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = {1, 4};
        DublerSequenceSearcher searcher = new DublerSequenceSearcher(true, false, false, true);
        SimilarityFinder finder = new SimilarityFinder(searcher);
        finder.calculateJackardSimilarity(tab1, tab2);
        assertThat(searcher.getKeys(), is(tab1));
    }
}
