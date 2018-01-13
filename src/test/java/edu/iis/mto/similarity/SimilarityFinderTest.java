package edu.iis.mto.similarity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SimilarityFinderTest {

    private SimilarityFinder finder;

    @Before
    public void setUp() {
        finder = new SimilarityFinder(new MockSequenceSearcher());
    }

    @Test
    public void testTheSameValues() {
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = {1, 2, 3, 4};
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(1.0));
    }

    @Test
    public void testDifferentValues() {
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = {5, 6, 7, 8};
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(0.0));
    }

    @Test
    public void testEmptyArrays() {
        int[] tab1 = {};
        int[] tab2 = {};
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(1.0));
    }

    @Test
    public void testFirstEmptyArray() {
        int[] tab1 = {};
        int[] tab2 = {1, 2, 3, 4};
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(0.0));
    }

    @Test
    public void testSecondEmptyArray() {
        int[] tab1 = {1, 2, 3, 4};
        int[] tab2 = {};
        assertThat(finder.calculateJackardSimilarity(tab1, tab2), is(0.0));
    }
}
