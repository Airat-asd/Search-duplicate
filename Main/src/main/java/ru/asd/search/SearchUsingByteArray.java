package ru.asd.search;

import ru.asd.data.*;
import ru.asd.file.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class SearchUsingByteArray {
    public static void startSearch(String path) {
        ListOfFiles listOfFiles = new ListOfFilesImpl(path);
        DataStorage dataStorage = new DataStorageImpl();
        Map<Path, String> mapMd5AndFile = dataStorage.mapByteNotSorted(listOfFiles);
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicates(mapMd5AndFile);
        PrintDuplicate.printDuplicate(duplicate);
    }
}
