package ru.asd;

import ru.asd.search.SearchUsingByteArray;
import ru.asd.search.SearchUsingHashMap;
import ru.asd.search.SearchUsingString;

import java.io.File;
import java.util.*;

public class SearchMain {
    public static void main(String[] args) {
        final String PATH_OF_FOLDER = "Main\\src\\test\\resources\\Search";
        System.out.println("Search for duplicate using the bubble algorithm using the MD5 code obtained from the ByteArray:");
        SearchUsingByteArray.startSearch(PATH_OF_FOLDER);
        System.out.println("Search for duplicate using the bubble algorithm using the MD5 code obtained from the HEX:");
        SearchUsingString.startSearch(PATH_OF_FOLDER);
        System.out.println("Searching for duplicates using a HashMap obtained from a ByteArray:");
        SearchUsingHashMap.startSearch(PATH_OF_FOLDER);
        List<Integer> test1 = Arrays.asList(13,1,10,4,20,21,21,3);
        System.out.println("test1="+test1);
        List<Integer> test2 = new LinkedList<>(Arrays.asList(13,1,10,4,20,21,21,3));
        System.out.println("test2="+test2);
        Set<Integer> test3 = new HashSet<>(Arrays.asList(13,1,10,4,20,21,21,3));
        System.out.println("test3="+test3);
        Set<Integer> test4 = new TreeSet<>(Arrays.asList(13,1,10,4,20,21,21,3));
        System.out.println("test4="+test4);


    }
}
