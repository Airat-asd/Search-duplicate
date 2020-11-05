/**
 *
 * @author Zagretdinov Airat
 * @version 1.0 date 02.11.2020
 **/

package ru.asd;

import ru.asd.launcher.*;

public class SearchMain {
    public static void main(String[] args) {
        final String PATH_OF_FOLDER = "C:\\Java\\Search-duplicate\\Main\\src\\test\\resources\\Search";

        System.out.println("Searching duplicates using a HashMap:");
        RunningADuplicateSearchUsingAHashMap.run(PATH_OF_FOLDER);
        System.out.println("------------------------");

        System.out.println("Searching duplicates using a Stream API:");
        RunningADuplicateSearchUsingAStream.run(PATH_OF_FOLDER);
        System.out.println("------------------------");

        System.out.println("Searching duplicates using a sorting:");
        RunningADuplicateSearchUsingASorting.run(PATH_OF_FOLDER);
        System.out.println("------------------------");

        System.out.println("Searching duplicates using a SET1:");
        RunningADuplicateSearchUsingAHashSet.run(PATH_OF_FOLDER);
        System.out.println("------------------------");

    }
}
