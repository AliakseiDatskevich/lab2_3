package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2018-01-21.
 */
public class SimilarityFinderTest {

    @Test
    public void sameSequenceReturnOneInJaccardaIndex() {
        SequenceSearcherImpl sequenceSearcher = new SequenceSearcherImpl();
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(true, 0));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(true, 1));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(true, 2));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(true, 3));
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int[] seq1 = {7, 17, 27, 37};
        int[] seq2 = {7, 17, 27, 37};

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(1.0));
    }

    @Test
    public void differentSequenceReturnZeroInJaccardaIndex() {
        SequenceSearcherImpl sequenceSearcher = new SequenceSearcherImpl();
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int[] seq1 = {7, 17, 27, 37};
        int[] seq2 = {117, 1117, 1127, 1137};
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0.0));
    }

    @Test
    public void similarSequenceReturnValueBeetwenZeroAndOneInJaccardaIndex() {
        SequenceSearcherImpl sequenceSearcher = new SequenceSearcherImpl();
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(true, 0));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int[] seq1 = {7, 17, 27, 37};
        int[] seq2 = {7, 1117, 1127, 1137};
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), allOf(greaterThan(0.0), lessThan(1.0)));
    }

    @Test
    public void whenFirstSequenceIsEmptyJaccardaIndexIsZero() {
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherImpl());
        int[] seq1 = {};
        int[] seq2 = {117, 1117, 1127, 1137};
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0.0));
    }

    @Test
    public void whenSecondSequenceIsEmptyJaccardaIndexIsZero() {
        SequenceSearcherImpl sequenceSearcher = new SequenceSearcherImpl();
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        sequenceSearcher.getSearchResults().add(new SearchResultImpl(false, -1));
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int[] seq1 = {7, 17, 27, 37};
        int[] seq2 = {};
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0.0));
    }


}