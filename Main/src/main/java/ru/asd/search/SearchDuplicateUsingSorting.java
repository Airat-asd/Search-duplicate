package ru.asd.search;

import ru.asd.data.SearchOfDuplicates;
import ru.asd.data.SearchOfDuplicatesImpl;

import java.nio.file.Path;
import java.util.List;

public class SearchDuplicateUsingSorting {
    public static void searchDuplicateUsingByteArray(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesUsingSorted(MapCodeMd5FromByteArray.getCodeByteArray(path));
        PrintDuplicate.printDuplicate(duplicate);
    }

    public static void searchDuplicateUsingHEX(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesUsingSorted(MapCOdeMd5FromHEX.getCodeHEX(path));
        PrintDuplicate.printDuplicate(duplicate);
    }

}
