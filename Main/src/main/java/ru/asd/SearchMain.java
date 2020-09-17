package ru.asd;

import ru.asd.search.SearchUsingByteArray;
import ru.asd.search.SearchUsingHashMap;
import ru.asd.search.SearchUsingString;

import java.util.HashMap;
import java.util.Map;

public class SearchMain {
    public static void main(String[] args) {
        final String PATH_OF_FOLDER = "D:\\AUTORUN\\AUTORUNX";
//        SearchUsingByteArray.startSearch(PATH_OF_FOLDER);
//        SearchUsingString.startSearch(PATH_OF_FOLDER);
        var duplicate = SearchUsingHashMap.startSearch(PATH_OF_FOLDER);
        System.out.println("Found " + duplicate.size() + " duplicates:");
        for (int i = 0; i < duplicate.size(); i++) {
            System.out.println(i + 1 + ". " + duplicate.get(i));
        }

    }
}
