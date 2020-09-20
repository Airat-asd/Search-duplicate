package ru.asd.search;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintDuplicate {
    public static void printDuplicate(List duplicate) {
        Stream<Path> stream = duplicate.stream();
        List<Path> collect = stream.collect(Collectors.toList());
        System.out.println("Found " + duplicate.size() + " duplicates:");
        for (int i = 0; i < duplicate.size(); i++) {
            System.out.println(i + 1 + ". " + duplicate.get(i));
        }
    }
}
