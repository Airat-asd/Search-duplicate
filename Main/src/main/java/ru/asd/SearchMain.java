package ru.asd;

import ru.asd.search.*;

public class SearchMain {
    public static void main(String[] args) {
        final String PATH_OF_FOLDER = "Main\\src\\test\\resources\\Search";
//        System.out.println("Search for duplicate using the bubble algorithm using the MD5 code obtained from the ByteArray:");
//        SearchDuplicatesBySortingBubble.searchUsingByteArray(PATH_OF_FOLDER);
//        System.out.println("------------------------");
//
//        System.out.println("Search for duplicate using the bubble algorithm using the MD5 code obtained from the HEX:");
//        SearchDuplicatesBySortingBubble.searchUsingHEX(PATH_OF_FOLDER);
//        System.out.println("------------------------");
//
//        System.out.println("Searching duplicates by sorting using a SET:");
//        SearchDuplicatesUsingSet.searchDuplicateUsingSet(PATH_OF_FOLDER);
//        System.out.println("------------------------");
//
//        System.out.println("Searching duplicates by sorting using a HashSet and using Byte Array:");
//        SearchDuplicatesUsingHashSet.searchDuplicateUsingByteArray(PATH_OF_FOLDER);
//        System.out.println("------------------------");
//
//        System.out.println("Searching duplicates by sorting using a HashSet and using HEX:");
//        SearchDuplicatesUsingHashSet.searchDuplicateUsingByteArray(PATH_OF_FOLDER);
//        System.out.println("------------------------");
//
//        System.out.println("Searching duplicates using a Stream API and Byte Array:");
//        SearchDuplicatesUsingStream.searchDuplicateUsingByteArray(PATH_OF_FOLDER);
//        System.out.println("------------------------");
//
//        System.out.println("Searching duplicates using a Stream API and HEX:");
//        SearchDuplicatesUsingStream.searchDuplicateUsingHEX(PATH_OF_FOLDER);
//        System.out.println("------------------------");
//
//        System.out.println("Searching for duplicates using a HashMap obtained from a ByteArray:");
//        SearchUsingHashMap.searchDuplicateUsingByteArray(PATH_OF_FOLDER);
//        System.out.println("------------------------");
//
        System.out.println("Searching for duplicates using a HashMap obtained from a HEX:");
        SearchUsingHashMap.searchDuplicateUsingHEX(PATH_OF_FOLDER);
        System.out.println("------------------------");

        System.out.println("Searching for duplicates using a sorting:");
        SearchDuplicateUsingSorting.searchDuplicateUsingByteArray(PATH_OF_FOLDER);
        System.out.println("------------------------");

    }
}
