package ru.asd.search;

import ru.asd.data.*;
import ru.asd.file.*;

import java.nio.file.Path;
import java.util.Map;

public class SearchUsingByteArray {
    public static void startSearch(String path) {
        Map<Path, byte[]> mapMd5AndFile;
        ListOfFiles listOfFiles = new ListOfFilesImpl(path);
        DataStorage dataStorage = new DataStorageImpl();
        mapMd5AndFile = dataStorage.mapByteNotSorted(listOfFiles);
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        var duplicate = getDuplicate.getListOfDuplicatesFromByte(mapMd5AndFile);
        System.out.println("Found " + duplicate.size() + " duplicates:");
        for (int i = 0; i < duplicate.size(); i++) {
            System.out.println(i+1 + ". " + duplicate.get(i));
        }    }
}
