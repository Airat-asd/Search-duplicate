package ru.asd;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.asd.launcher.RunningADuplicateSearchUsingSorted;
import ru.asd.launcher.RunningADuplicateSearchUsingAHashSet;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHTestSearch {
//    private static final String PATH_OF_FOLDER = "Main\\src\\test\\resources\\Search";
//    private static final String PATH_OF_FOLDER = "C:\\Gradle\\gradle-6.3\\docs\\javadoc";
    private static final String PATH_OF_FOLDER = "E:\\YandexDisk\\Фотокамера";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHTestSearch.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    @Benchmark
    public void RunningADuplicateSearchUsingAHashSetTest() {
        RunningADuplicateSearchUsingAHashSet.run(PATH_OF_FOLDER);
    }

    @Benchmark
    public void RunningADuplicateSearchUsingSortedTest() {
        RunningADuplicateSearchUsingSorted.run(PATH_OF_FOLDER);

    }
}
