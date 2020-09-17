package ru.asd.search;

import ru.asd.data.DataStorage;
import ru.asd.data.DataStorageImpl;
import ru.asd.data.SearchOfDuplicates;
import ru.asd.data.SearchOfDuplicatesImpl;
import ru.asd.file.ListOfFiles;
import ru.asd.file.ListOfFilesImpl;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class SearchUsingHashMap {
    public static void startSearch(String path) {
        ListOfFiles listOfFiles = new ListOfFilesImpl(path);
        DataStorage dataStorage = new DataStorageImpl();
        Map<Path, byte[]> mapMd5AndFile = dataStorage.mapByteNotSorted(listOfFiles);
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        var duplicate = getDuplicate.getListOfDuplicatesUsingHashMap(mapMd5AndFile);

        System.out.println("Found " + duplicate.size() + " duplicates:");
        for (int i = 0; i < duplicate.size(); i++) {
            System.out.println(i + 1 + ". " + duplicate.get(i));
        }
    }

}
