package ru.asd.search;

import ru.asd.data.PathAndMd5;
import ru.asd.file.ListOfFiles;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface SearchOfDuplicates {

    List<Path> getListOfDuplicatesUsingHashSet(Map<Path, String> mapMd5);

    List<Path> getListOfDuplicatesUsingSorted(List<PathAndMd5> mapMd5);

}
