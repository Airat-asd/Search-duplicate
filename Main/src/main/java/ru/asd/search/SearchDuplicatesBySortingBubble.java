package ru.asd.search;

import ru.asd.data.*;

import java.nio.file.Path;
import java.util.List;

public class SearchDuplicatesBySortingBubble {

    public static void searchUsingByteArray(String path) {
        long begin = System.currentTimeMillis();
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesBubbleMethod(MapCodeMd5FromByteArray.getCodeByteArray(path));
        PrintDuplicate.printDuplicate(duplicate);
        System.out.println("myArr time:" + (System.currentTimeMillis() - begin));
    }

    public static void searchUsingHEX(String path) {
        long begin = System.currentTimeMillis();
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesBubbleMethod(MapCOdeMd5FromHEX.getCodeHEX(path));
        PrintDuplicate.printDuplicate(duplicate);
        System.out.println("myArr time:" + (System.currentTimeMillis() - begin));
    }
}
