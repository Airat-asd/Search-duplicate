package ru.asd.data;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface SearchOfDuplicates {

    List<Path> getListOfDuplicatesBubbleMethod(Map<Path, String> mapMd5);

    List<Path> getListOfDuplicatesUsingHashMap(Map<Path, String> mapMd5);

    List<Path> getListOfDuplicatesBySortingUsingArrayList(Map<Path, String> mapMd5);

    List<Path> getListOfDuplicatesUsingStream(Map<Path, String> mapMd5);

    List<Path> getListOfDuplicatesUsingHashSet(Map<Path, String> mapMd5);



}
