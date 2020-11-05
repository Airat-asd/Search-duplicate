package ru.asd;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.asd.launcher.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.SingleShotTime})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHTestSearch {
//    private static final String PATH_OF_FOLDER = "Main\\src\\test\\resources\\Search";
    private static final String PATH_OF_FOLDER = "C:\\Gradle\\gradle-6.3\\docs";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHTestSearch.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    @Benchmark
    public void RunningADuplicateSearchUsingAHashMapTest() {
        RunningADuplicateSearchUsingAHashMap.run(PATH_OF_FOLDER);
    }

    @Benchmark
    public void RunningADuplicateSearchUsingAStreamTest() {
        RunningADuplicateSearchUsingAStream.run(PATH_OF_FOLDER);
    }
    @Benchmark
    public void RunningADuplicateSearchUsingASortingTest() {
        RunningADuplicateSearchUsingASorting.run(PATH_OF_FOLDER);
    }
    @Benchmark
    public void RunningADuplicateSearchUsingAHashSetTest() {
        RunningADuplicateSearchUsingAHashSet.run(PATH_OF_FOLDER);
    }

}
