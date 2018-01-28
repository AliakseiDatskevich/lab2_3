package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

/**
 * Created by Justyna on 25.01.2018.
 */
public class SequenceSearcherDubler implements SequenceSearcher{

    private boolean[] results;
    private int[] parameters;
    private int[][] seqParameters;
    private int counter = 0;

    public SequenceSearcherDubler(boolean... results) {
        this.parameters = new int[results.length];
        this.seqParameters = new int[results.length][];
        this.results = results;
    }

    public SearchResult search(int i, int[] ints) {
        parameters[counter] = i;
        seqParameters[counter] = ints;
        boolean result = results[counter++];
        return new SearchResultDubler(result);
    }

    public int getCounter() {
        return counter;
    }

    public int[] getParameters() {
        return parameters;
    }

    public int[][] getSeqParameters() {
        return seqParameters;
    }
}
