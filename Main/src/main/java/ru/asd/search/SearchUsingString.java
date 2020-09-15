package ru.asd.search;

import ru.asd.data.*;
import ru.asd.file.*;

import java.nio.file.Path;
import java.util.Map;

public class SearchUsingString {

    public static void startSearch(String path) {
        Map<Path, String> mapMd5AndFile;
        ListOfFiles listOfFiles = new ListOfFilesImpl(path);
        DataStorage dataStorage = new DataStorageImpl();
        mapMd5AndFile = dataStorage.mapStringNotSorted(listOfFiles);
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        var duplicate = getDuplicate.getListOfDuplicatesFromString(mapMd5AndFile);
        System.out.println("Duplicates " + duplicate.size() + ":");
        System.out.println(duplicate);
    }
}
