package ru.asd.search;

import ru.asd.data.DataStorage;
import ru.asd.data.DataStorageImpl;
import ru.asd.data.SearchOfDuplicates;
import ru.asd.data.SearchOfDuplicatesImpl;
import ru.asd.file.ListOfFiles;
import ru.asd.file.ListOfFilesImpl;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class SearchUsingHashMap {
    public static void searchDuplicateUsingByteArray(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesUsingHashMap(MapCodeMd5FromByteArray.getCodeByteArray(path));
        PrintDuplicate.printDuplicate(duplicate);
    }

    public static void searchDuplicateUsingHEX(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesUsingHashMap(MapCOdeMd5FromHEX.getCodeHEX(path));
        PrintDuplicate.printDuplicate(duplicate);
    }
}
