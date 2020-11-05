package ru.asd.data;

import ru.asd.file.ListOfFiles;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface DataStorage {

    Map<Path, String> getMapFromHashMd5(ListOfFiles listOfFiles);

    List<PathAndMd5> getListFromHashMd5(ListOfFiles listOfFiles);

}
