package ru.asd.data;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface SearchOfDuplicates {

    List<Path> getListOfDuplicatesFromByte(Map<Path, byte[]> mapMd5Byte);

    List<Path> getListOfDuplicatesFromString(Map<Path, String> mapMd5Byte);

    List<Path> getListOfDuplicatesUsingHashMap(Map<Path, byte[]> mapMd5Byte);

}
