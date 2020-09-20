package ru.asd.search;

import ru.asd.data.*;
import ru.asd.file.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class SearchUsingString {

    public static void startSearch(String path) {
        Map<Path, String> mapMd5AndFile;
        ListOfFiles listOfFiles = new ListOfFilesImpl(path);
        DataStorage dataStorage = new DataStorageImpl();
        mapMd5AndFile = dataStorage.getMapCodeMd5ThroughHEX(listOfFiles);
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesBubbleMethod(mapMd5AndFile);
        PrintDuplicate.printDuplicate(duplicate);
    }
}
