package ru.asd.search;

import ru.asd.data.SearchOfDuplicates;
import ru.asd.data.SearchOfDuplicatesImpl;

import java.nio.file.Path;
import java.util.List;

public class SearchDuplicatesUsingHashSet {
    public static void searchDuplicateUsingByteArray(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesUsingHashSet(MapCodeMd5FromByteArray.getCodeByteArray(path));
        PrintDuplicate.printDuplicate(duplicate);
    }

    public static void searchDuplicateUsingHEX(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesUsingHashSet(MapCOdeMd5FromHEX.getCodeHEX(path));
        PrintDuplicate.printDuplicate(duplicate);
    }
}
