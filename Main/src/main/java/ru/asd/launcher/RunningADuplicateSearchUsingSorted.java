package ru.asd.launcher;

import ru.asd.data.MapFromHashMd5;
import ru.asd.data.PrintDuplicate;
import ru.asd.search.SearchOfDuplicates;
import ru.asd.search.SearchOfDuplicatesImpl;

import java.nio.file.Path;
import java.util.List;

/**
 * @author Ayrat Zagretdinov
 * created on 05.11.2020
 */
public class RunningADuplicateSearchUsingSorted {
    public static void run(String path) {
        SearchOfDuplicates getDuplicate = new SearchOfDuplicatesImpl();
        List<Path> duplicate = getDuplicate.getListOfDuplicatesUsingSorted(MapFromHashMd5.getListFromHashMd5(path));
        PrintDuplicate.printDuplicate(duplicate);
    }

}
