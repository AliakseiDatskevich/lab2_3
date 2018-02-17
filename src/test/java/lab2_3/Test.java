package lab2_3;

import static org.junit.Assert.assertEquals;

import edu.iis.mto.similarity.DublerSequenceResult;
import edu.iis.mto.similarity.SimilarityFinder;

public class Test {

    @org.junit.Test
    public void sameSequenceTest() {
        DublerSequenceResult searcherDubler = new DublerSequenceResult();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int seq1[] = {2, 345, 34, 3462, 141};
        int seq2[] = {2, 345, 34, 3462, 141};
        double sim = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        System.out.println(sim);
        assertEquals(sim == 1.0, true);
    }

    @org.junit.Test
    public void differentSequenceTest() {
        DublerSequenceResult searcherDubler = new DublerSequenceResult();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int seq1[] = {2, 345, 34, 3462, 141};
        int seq2[] = {124, 625, 41, 251, 83};
        double sim = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        System.out.println(sim);
        assertEquals(sim == 0.0, true);
    }

    @org.junit.Test
    public void shorterSequenceTest1() {
        DublerSequenceResult searcherDubler = new DublerSequenceResult();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int seq1[] = {2, 345, 34, 3462};
        int seq2[] = {2, 345, 34, 3462, 141};
        double sim = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        System.out.println(sim);
        assertEquals(sim == 0.8, true);
    }

    @org.junit.Test
    public void shorterSequenceTest2() {
        DublerSequenceResult searcherDubler = new DublerSequenceResult();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int seq1[] = {345, 34, 3462, 141};
        int seq2[] = {2, 345, 34, 3462, 141};
        double sim = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        System.out.println(sim);
        assertEquals(sim == 0.8, true);
    }

    @org.junit.Test
    public void anotherSequenceTest() {
        DublerSequenceResult searcherDubler = new DublerSequenceResult();
        SimilarityFinder similarityFinder = new SimilarityFinder(searcherDubler);
        int seq1[] = {2, 345, 34, 3462, 141};
        int seq2[] = {34, 141, 2, 345, 3462};
        double sim = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        System.out.println(sim);
        assertEquals(sim == 1.0, true);
    }
}
