package ru.asd;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.asd.search.SearchUsingByteArray;
import ru.asd.search.SearchUsingString;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class TestSearch {
    private static final String PATH_OF_FOLDER = "C:\\JAVA\\Search";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(TestSearch.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    @Benchmark
    public void SearchUsingByteArrayTest() {
        SearchUsingByteArray.startSearch(PATH_OF_FOLDER);
    }

//    @Benchmark
//    public void SearchUsingStringTest() {
//        SearchUsingString.startSearch(PATH_OF_FOLDER);
//    }
}
