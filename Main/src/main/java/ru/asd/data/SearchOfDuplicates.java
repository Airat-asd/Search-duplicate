package ru.asd.data;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface SearchOfDuplicates {

    List<Path> getListOfDuplicatesBubbleMethod(Map<Path, String> mapMd5Byte);

    List<Path> getListOfDuplicatesUsingHashMap(Map<Path, String> mapMd5Byte);


}
