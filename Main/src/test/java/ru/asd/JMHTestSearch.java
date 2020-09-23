package ru.asd;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.asd.search.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHTestSearch {
    private static final String PATH_OF_FOLDER = "Main\\src\\test\\resources\\Search";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHTestSearch.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    @Benchmark
    public void SearchDuplicatesBySortingBubbleByteArrayTest() {
        SearchDuplicatesBySortingBubble.searchUsingByteArray(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchDuplicatesBySortingBubbleHEXTest() {
        SearchDuplicatesBySortingBubble.searchUsingHEX(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchDuplicatesUsingHashSetByteArrayTest() {
        SearchDuplicatesUsingHashSet.searchDuplicateUsingByteArray(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchDuplicatesUsingHashSetHEXTest() {
        SearchDuplicatesUsingHashSet.searchDuplicateUsingHEX(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchDuplicatesUsingSetTest() {
        SearchDuplicatesUsingSet.searchDuplicateUsingSet(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchDuplicatesUsingStreamByteArrayTest() {
        SearchDuplicatesUsingStream.searchDuplicateUsingByteArray(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchDuplicatesUsingStreamHEXTest() {
        SearchDuplicatesUsingStream.searchDuplicateUsingHEX(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchUsingHashMapByteArrayTest() {
        SearchUsingHashMap.searchDuplicateUsingByteArray(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchUsingHashMapHEXTest() {
        SearchUsingHashMap.searchDuplicateUsingHEX(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchDuplicateUsingSortingByteArrayTest() {
        SearchDuplicateUsingSorting.searchDuplicateUsingByteArray(PATH_OF_FOLDER);
    }

    @Benchmark
    public void SearchDuplicateUsingSortingHEXTest() {
        SearchDuplicateUsingSorting.searchDuplicateUsingHEX(PATH_OF_FOLDER);
    }

}
