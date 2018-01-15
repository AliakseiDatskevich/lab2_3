package edu.iis.mto.similarity;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import dublers.SequenceSearcherDubler;

public class SimilarityFinderTest {

    @Test
    public void calculateJackardSimilarityBothSequencesAreEmpty() {
        int[] fisrtSequence = {};
        int[] secondSequence = {};
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 1.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        double epsilon = 0.00000001;
        boolean actualOutput = delta < epsilon;
        boolean expectedOutput = true;

        assertThat(expectedOutput, Matchers.equalTo(actualOutput));

    }

    @Test
    public void calculateJackardSimilaritySecondSequencesIsEmpty() {
        int[] fisrtSequence = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] secondSequence = {};
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        double epsilon = 0.00000001;
        boolean actualOutput = delta < epsilon;
        boolean expectedOutput = true;

        assertThat(expectedOutput, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilaritySizeIsEqualToOneAndHaveOneCommonElement() {
        int[] fisrtSequence = {1};
        int[] secondSequence = {1};
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 1.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        double epsilon = 0.00000001;
        boolean actualOutput = delta < epsilon;
        boolean expectedOutput = true;

        assertThat(expectedOutput, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilaritySizeIsEqualToOneAndHaveNoCommonElements() {
        int[] fisrtSequence = {1};
        int[] secondSequence = {2};
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        double epsilon = 0.00000001;
        boolean actualOutput = delta < epsilon;
        boolean expectedOutput = true;

        assertThat(expectedOutput, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilarityDifferentSequenceSizesNoCommonElements() {
        int[] fisrtSequence = {1, 2, 3};
        int[] secondSequence = {4, 5, 6, 7, 8, 9};
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        double epsilon = 0.00000001;
        boolean actualOutput = delta < epsilon;
        boolean expectedOutput = true;

        assertThat(expectedOutput, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilarityDifferentSequenceSizesOneCommonElement() {
        int[] fisrtSequence = {1, 2, 3, 4};
        int[] secondSequence = {4, 5, 6, 7, 8, 9};
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.1111111111111111;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        double epsilon = 0.00000001;
        boolean actualOutput = delta < epsilon;
        boolean expectedOutput = true;

        assertThat(expectedOutput, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilarityDifferentSequenceSizesSomeElementsAreCommon() {
        int[] fisrtSequence = {1, 2, 3, 4, 5, 6};
        int[] secondSequence = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.25;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        double epsilon = 0.00000001;
        boolean actualOutput = delta < epsilon;
        boolean expectedOutput = true;

        assertThat(expectedOutput, Matchers.equalTo(actualOutput));
    }

    public void calculateJackardSimilarityTheSameSequenceSizesNoCommonElements() {
        ;
    }

    @Test
    public void calculateJackardSimilarityTheSameSequenceSizesOneCommonElement() {
        ;
    }

    @Test
    public void calculateJackardSimilarityTheSameSequenceSizesAllElementsAreCommon() {
        ;
    }

    @Test
    public void calculateJackardSimilarityTheSameSequenceSizesHalfOfElementsAreCommon() {
        ;
    }

}
