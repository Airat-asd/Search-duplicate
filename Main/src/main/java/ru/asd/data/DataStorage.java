package ru.asd.data;

import ru.asd.file.ListOfFiles;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public interface DataStorage {
    Map<Path, String> mapByteNotSorted (ListOfFiles listOfFiles);

    Map<Path, String> mapStringNotSorted (ListOfFiles listOfFiles);

    Map<Path, String> mapSorted (ListOfFiles listOfFiles);

    Map<Path, String> mapStringSorted (ListOfFiles listOfFiles);

}
