/**
 * @author Zagretdinov Airat
 * @version 1.0 date 02.11.2020
 **/

package ru.asd;

import ru.asd.launcher.*;

public class SearchMain {
    public static void main(String[] args) {
//        final String PATH_OF_FOLDER = "C:\\Java\\Search-duplicate\\Main\\src\\test\\resources\\Search";
//        final String PATH_OF_FOLDER = "C:\\Gradle\\gradle-6.3\\docs\\javadoc";
        final String PATH_OF_FOLDER = "E:\\YandexDisk\\Фотокамера";

        System.out.println("Searching duplicates using a SET:");
        RunningADuplicateSearchUsingAHashSet.run(PATH_OF_FOLDER);
        System.out.println("------------------------");

        System.out.println("Searching duplicates using a sorted:");
        RunningADuplicateSearchUsingSorted.run(PATH_OF_FOLDER);
        System.out.println("------------------------");

    }
}
