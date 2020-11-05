package ru.asd.search;

import ru.asd.file.ListOfFiles;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface SearchOfDuplicates {

    List<Path> getListOfDuplicatesUsingHashSet(Map<Path, String> mapMd5);

    List<Path> getListOfDuplicatesUsingSorted(Map<Path, String> mapMd5);
}
