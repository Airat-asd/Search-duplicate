package ru.asd.search;

import ru.asd.data.*;

import java.nio.file.Path;
import java.util.List;

public class SearchDuplicatesBySortingBubble {

    public static void searchUsingByteArray(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesBubbleMethod(MapCodeMd5FromByteArray.getCodeByteArray(path));
        PrintDuplicate.printDuplicate(duplicate);
    }

    public static void searchUsingHEX(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesBubbleMethod(MapCOdeMd5FromHEX.getCodeHEX(path));
        PrintDuplicate.printDuplicate(duplicate);
    }
}
