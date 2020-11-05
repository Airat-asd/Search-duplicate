package ru.asd.launcher;

import ru.asd.data.MapFromHashMd5;
import ru.asd.data.PrintDuplicate;
import ru.asd.search.SearchOfDuplicates;
import ru.asd.search.SearchOfDuplicatesImpl;

import java.nio.file.Path;
import java.util.List;

public class RunningADuplicateSearchUsingAHashSet {

    public static void run(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesUsingHashSet(MapFromHashMd5.getMapFromHashMd5(path));
        PrintDuplicate.printDuplicate(duplicate);
    }
}
