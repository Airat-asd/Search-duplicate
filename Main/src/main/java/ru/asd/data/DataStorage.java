package ru.asd.data;

import ru.asd.file.ListOfFiles;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface DataStorage {
    Map<Path, String> getMapCodeMd5ThroughByteArray(ListOfFiles listOfFiles);

    Map<Path, String> getMapCodeMd5ThroughHEX(ListOfFiles listOfFiles);

    List<Path> getMapCodeMd5ThroughHashSet(ListOfFiles listOfFiles);

    Map<Path, String> mapSorted (ListOfFiles listOfFiles);
}
