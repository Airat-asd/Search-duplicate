package ru.asd.search;

import ru.asd.data.DataStorage;
import ru.asd.data.DataStorageImpl;
import ru.asd.data.SearchOfDuplicates;
import ru.asd.data.SearchOfDuplicatesImpl;
import ru.asd.file.ListOfFiles;
import ru.asd.file.ListOfFilesImpl;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchUsingHashMap {
    public static void startSearch(String path) {
        ListOfFiles listOfFiles = new ListOfFilesImpl(path);
        DataStorage dataStorage = new DataStorageImpl();
        Map<Path, String> mapMd5AndFile = dataStorage.mapByteNotSorted(listOfFiles);
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesUsingHashMap(mapMd5AndFile);
        PrintDuplicate.printDuplicate(duplicate);
    }
}
