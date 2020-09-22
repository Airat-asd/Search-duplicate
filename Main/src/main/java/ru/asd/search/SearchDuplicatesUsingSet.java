package ru.asd.search;

import ru.asd.data.DataStorage;
import ru.asd.data.DataStorageImpl;
import ru.asd.file.ListOfFiles;
import ru.asd.file.ListOfFilesImpl;

import java.nio.file.Path;
import java.util.List;

public class SearchDuplicatesUsingSet {
    public static void searchDuplicateUsingSet(String path) {
        long begin = System.currentTimeMillis();
        ListOfFiles listOfFiles = new ListOfFilesImpl(path);
        DataStorage dataStorage = new DataStorageImpl();
        List<Path> listDuplicate = dataStorage.getMapCodeMd5ThroughHashSet(listOfFiles);
        PrintDuplicate.printDuplicate(listDuplicate);
        System.out.println("myArr time:" + (System.currentTimeMillis() - begin));
    }
}
